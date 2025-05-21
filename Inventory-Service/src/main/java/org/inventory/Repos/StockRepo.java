package org.inventory.Repos;

import org.inventory.Entities.Ingredient;
import org.inventory.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Parameter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StockRepo extends JpaRepository<Stock,Long> {

    public Optional<Stock> findByName(String CourseName);

    @Procedure(name = "checkStockAndQuantity")
    @Transactional
    public Boolean checkStockAndQuantity(@Param("nameItem") String nameItem,
                                         @Param("quantity") Integer quantity
                                         );

}
