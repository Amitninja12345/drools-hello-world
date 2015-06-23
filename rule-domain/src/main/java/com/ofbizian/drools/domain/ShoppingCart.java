package com.ofbizian.drools.domain;

import java.util.List;

/**
 * User: bibryam
 * Date: 23/06/15
 */
public class ShoppingCart {
    private List<Product> items;

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                '}';
    }
}


