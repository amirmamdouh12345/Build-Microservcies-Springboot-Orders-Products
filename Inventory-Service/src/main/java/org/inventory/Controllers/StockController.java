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


//
//    @GetMapping("/id/{id}")
//    //all
//    public ResponseEntity<?> getStockById(@PathVariable("id") Long id){
//        try {
//            return ResponseEntity.ok(stockService.getStockById(id));
//        }
//        catch (NameNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @GetMapping("/name/{name}")
//    public ResponseEntity<?> getStockByName(@PathVariable("name") String name){
//        try {
//            System.out.println("name: "+name);
//            return ResponseEntity.ok(stockService.getStockByName(name));
//        }
//        catch (NameNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @PostMapping
////    @PreAuthorize("hasRole('Admin')")
//    public ResponseEntity<?> insertNewStock(@RequestBody Stock stock){
//        try {
//            return ResponseEntity.ok(stockService.insertStock(stock));
//        }
//        catch (NameNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @PostMapping("/update/{id}")
////    @PreAuthorize("hasRole('Admin') || hasRole('Instructor') ")
//    public ResponseEntity<?> updateStock(@PathVariable Long id ,@RequestBody Stock stock){
//        try {
//            return ResponseEntity.ok(stockService.updateStock(id ,stock));
//        }
//        catch (NameNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @GetMapping("/delete/{name}")
////    @PreAuthorize("hasRole('Admin')")
//    public ResponseEntity<?> deleteStock(@PathVariable("name") String name){
//        try {
//            return ResponseEntity.ok(stockService.deleteByName(name));
//        }
//        catch (NameNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

}
