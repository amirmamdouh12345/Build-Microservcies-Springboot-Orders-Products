package org.inventory.Controllers;

import org.inventory.Entities.Stock;
import org.shared.Response.InventoryResponseToOrder;
import org.inventory.Services.StockService;
import org.shared.Entities.Orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock")
public class StockController {

    @Autowired
    StockService stockService;



    @GetMapping  //all
    public List<Stock> getAllStocks(){
        return stockService.getAllStocks();
    }

    @PostMapping
    public List<InventoryResponseToOrder> OrderRequest(@RequestBody Order order){
        System.out.println("Request in Stock Service now");
        System.out.println("orderrrr" +order);
        return stockService.OrderRequest(order);
    }



}
