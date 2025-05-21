package org.inventory.Controllers;

import org.inventory.Entities.Ingredient;
import org.inventory.Services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameNotFoundException;
import java.util.List;

@RestController
@RequestMapping("ingredient")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;



    @GetMapping  //all
    public List<Ingredient> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/id/{id}")
    //all
    public ResponseEntity<?> getIngredientById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(ingredientService.getIngredientById(id));
        }
        catch (NameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getIngredientByName(@PathVariable("name") String name){
        try {
            System.out.println("name: "+name);
            return ResponseEntity.ok(ingredientService.getIngredientByName(name));
        }
        catch (NameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
//    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> insertNewIngredient(@RequestBody Ingredient ingredient){
        try {
            return ResponseEntity.ok(ingredientService.insertIngredient(ingredient));
        }
        catch (NameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/update/{id}")
//    @PreAuthorize("hasRole('Admin') || hasRole('Instructor') ")
    public ResponseEntity<?> updateIngredient(@PathVariable Long id ,@RequestBody Ingredient ingredient){
        try {
            return ResponseEntity.ok(ingredientService.updateIngredient(id ,ingredient));
        }
        catch (NameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/delete/{name}")
//    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> deleteIngredient(@PathVariable("name") String name){
        try {
            return ResponseEntity.ok(ingredientService.deleteByName(name));
        }
        catch (NameNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
