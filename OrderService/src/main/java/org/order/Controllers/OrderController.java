package org.order.Controllers;

import org.order.Services.OrderService;
import org.shared.Entities.Orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameNotFoundException;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;




//    @GetMapping  //all
//    public List<Order> getAllOrders(){
//        return orderService.getAllOrders();
//    }

//    @GetMapping("/id/{id}")
    //all
//    public ResponseEntity<?> getOrderById(@PathVariable("id") Long id){
//        try {
//            return ResponseEntity.ok(orderService.getOrderById(id));
//        }
//        catch (NameNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

//    @GetMapping("/name/{name}")
//    public ResponseEntity<?> getOrderByName(@PathVariable("name") String name){
//        try {
//            System.out.println("name: "+name);
//            return ResponseEntity.ok(orderService.getOrderByName(name));
//        }
//        catch (NameNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @PostMapping
//    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> createNewOrder(@RequestBody Order order){
        try {

            return ResponseEntity.ok(orderService.insertOrder(order));
        }
        catch (NameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PostMapping("/update/{id}")
////    @PreAuthorize("hasRole('Admin') || hasRole('Instructor') ")
//    public ResponseEntity<?> updateOrder(@PathVariable Long id ,@RequestBody Order order){
//        try {
//            return ResponseEntity.ok(orderService.updateOrder(id ,order));
//        }
//        catch (NameNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

//    @GetMapping("/delete/{name}")
////    @PreAuthorize("hasRole('Admin')")
//    public ResponseEntity<?> deleteOrder(@PathVariable("name") String name){
//        try {
//            return ResponseEntity.ok(orderService.deleteByName(name));
//        }
//        catch (NameNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

}
