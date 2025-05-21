package org.inventory.Services;


import org.inventory.Entities.Ingredient;
import org.inventory.Repos.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NameNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    IngredientRepo ingredientRepo;
    
//    @Autowired
//    ApplicationEventPublisher applicationEventPublisher;

    public List<Ingredient> getAllIngredients(){
        return ingredientRepo.findAll();
    }

    public Ingredient getIngredientById(Long id) throws NameNotFoundException {
        Optional<Ingredient> ingredient=ingredientRepo.findById(id);
        if(ingredient.isPresent()){
            return ingredient.get();
        }
        throw new NameNotFoundException("Id is not Matched..");
    }

    public Ingredient getIngredientByName(String  name) throws NameNotFoundException {
        Optional<Ingredient> ingredient=ingredientRepo.findByItemName(name);
        if(ingredient.isPresent()){
            return ingredient.get();
        }
        throw new NameNotFoundException("Ingredient Name is not Matched..");
    }

    @Transactional
    public Ingredient insertIngredient(Ingredient  ingredient) throws NameNotFoundException {



        return ingredientRepo.save(ingredient);
    }

    public Ingredient updateIngredient(Long id,Ingredient  ingredient) throws NameNotFoundException {
        Optional<Ingredient> alreadyFound = ingredientRepo.findById(id);
        if(alreadyFound.isPresent()){
            ingredient.setId(id);
            return ingredientRepo.save(ingredient);
        }
        throw new NameNotFoundException("Ingredient Id is not Matched for the Update..");
    }

    public String deleteByName(String name) throws NameNotFoundException {
        Optional<Ingredient> alreadyFound = ingredientRepo.findByItemName(name);
        if(alreadyFound.isPresent()){
            ingredientRepo.delete(alreadyFound.get());
            return "Deleted Successfully";
        }
        throw new NameNotFoundException("Ingredient Id is not Matched for the Update..");
    }




}
