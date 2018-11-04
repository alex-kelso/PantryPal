package com.example.athen.pantrypal;

public class Item {
    private String name;
    private String category;
    private String expiration;

    public Item(String name, String category, String expiration) {
        this.name = name;
        this.category = category;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getExpiration() {
        return expiration;
    }
}
