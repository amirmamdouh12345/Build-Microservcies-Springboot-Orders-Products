package org.inventory.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Ingredients" , schema = "food_db")
@Setter
@Getter
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String itemName;

    Integer pieces;
}
