package org.shared.Entities.Orders;

//import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name = "items", schema = "food_db")
@Getter
@Setter

public class Item {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String itemName;

    Integer piece;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", piece=" + piece +
                '}';
    }


}
