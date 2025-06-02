package org.order.Services;


//import org.order.Repos.OrderRepo;
import org.shared.Entities.Orders.Order;
import org.shared.Response.InventoryResponseToOrder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.naming.NameNotFoundException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import java.util.stream.Stream;

@Service
public class OrderService {

//    @Autowired
//    OrderRepo orderRepo;

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private WebClient.Builder webClientBuilder;

    public String insertOrder(Order  order) throws NameNotFoundException {

        List<InventoryResponseToOrder> response ;
        try {
            response=webClientBuilder
                    .build()
                    .post()
                    .uri("http://localhost:8085/stock")
                    .bodyValue(order)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<InventoryResponseToOrder>>() {})
                    .block();

            assert response != null;

        }catch (WebClientResponseException ex) {
            logger.error("Client error response from inventory service: {}", ex.getMessage(), ex);
            throw new RuntimeException("Client error response from inventory service", ex);
        } catch (WebClientException ex) {
            logger.error("Error calling inventory service: {}", ex.getMessage(), ex);
            throw new RuntimeException("Error calling inventory service", ex);
        }
        boolean successOrder = response.stream().allMatch(InventoryResponseToOrder::getIsOk);

        if(successOrder){
            return "Success Order";
        }
        else{
            StringBuilder allFailed=new StringBuilder();
            response.stream().filter(i-> !i.getIsOk()).forEach(i->{
                allFailed.append(i.getName()).append(" ");
            });
            allFailed.append("have no enough ingredients..");
            return allFailed.toString();
        }


    }


}
