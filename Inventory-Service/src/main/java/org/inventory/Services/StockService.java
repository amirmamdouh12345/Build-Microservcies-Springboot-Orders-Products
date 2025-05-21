package org.inventory.Services;


import org.inventory.Entities.Stock;
import org.inventory.Repos.StockRepo;
import org.shared.Response.InventoryResponseToOrder;
import org.shared.Entities.Orders.Item;
import org.shared.Entities.Orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    StockRepo stockRepo;


    @Autowired
    IngredientService ingredientService;

//    @Autowired
//    ApplicationEventPublisher applicationEventPublisher;

    public List<Stock> getAllStocks(){
        return stockRepo.findAll();
    }


    @Transactional
    public List<InventoryResponseToOrder> OrderRequest(Order order){

        List<Item> items =order.getItems();

        List<InventoryResponseToOrder> responses=items.stream().map(i->
          new InventoryResponseToOrder(i.getItemName(),stockRepo.checkStockAndQuantity(i.getItemName(),i.getPiece()))
        ).toList();
        System.out.println(responses);
        return responses;

    }






















    public Stock getStockById(Long id) throws NameNotFoundException {
        Optional<Stock> stock=stockRepo.findById(id);
        if(stock.isPresent()){
            return stock.get();
        }
        throw new NameNotFoundException("Id is not Matched..");
    }

    public Stock getStockByName(String  name) throws NameNotFoundException {
        Optional<Stock> stock=stockRepo.findByName(name);
        if(stock.isPresent()){
            return stock.get();
        }
        throw new NameNotFoundException("Stock Name is not Matched..");
    }

    @Transactional
    public Stock insertStock(Stock  stock) throws NameNotFoundException {



        return stockRepo.save(stock);
    }

    public Stock updateStock(Long id,Stock  stock) throws NameNotFoundException {
        Optional<Stock> alreadyFound = stockRepo.findById(id);
        if(alreadyFound.isPresent()){
            stock.setId(id);
            return stockRepo.save(stock);
        }
        throw new NameNotFoundException("Stock Id is not Matched for the Update..");
    }

    public String deleteByName(String name) throws NameNotFoundException {
        Optional<Stock> alreadyFound = stockRepo.findByName(name);
        if(alreadyFound.isPresent()){
            stockRepo.delete(alreadyFound.get());
            return "Deleted Successfully";
        }
        throw new NameNotFoundException("Stock Id is not Matched for the Update..");
    }




}
