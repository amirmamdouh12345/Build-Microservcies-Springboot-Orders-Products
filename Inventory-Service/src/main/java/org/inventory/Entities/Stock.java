package org.inventory.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Stocks" , schema = "food_db")
@Setter
@Getter
public class Stock { //ManyToMany

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToMany
    @JoinTable(name = "stock_ingredient_relation",
    schema = "food_db"
    ,joinColumns = @JoinColumn(name = "stock_id" ,referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id" ,referencedColumnName = "id"))
    List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }
    public void remove(String itemName){
        ingredients.removeIf(i->i.getItemName().equals(itemName));
    }

}
