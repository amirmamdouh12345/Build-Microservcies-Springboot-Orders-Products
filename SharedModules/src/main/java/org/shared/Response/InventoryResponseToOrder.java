package org.shared.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class InventoryResponseToOrder {

    String name;

    Boolean isOk;

    @Override
    public String toString() {
        return "{name: "+name+ " isOk: "+isOk+"}";
    }
}
