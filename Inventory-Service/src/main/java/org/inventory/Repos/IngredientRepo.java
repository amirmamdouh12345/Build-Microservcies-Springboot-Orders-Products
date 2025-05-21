package org.inventory.Repos;

import jakarta.persistence.NamedStoredProcedureQuery;
import org.inventory.Entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient,Long> {
//
    public Optional<Ingredient> findByItemName(String itemName);


}