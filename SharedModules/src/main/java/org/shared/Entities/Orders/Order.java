package org.shared.Entities.Orders;

//import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Entity
//@Table(name = "courses" , schema = "onelinelearning")
@Setter
@Getter
public class Order { //OneToMany

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    List<Item> items;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("id=").append(id);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
