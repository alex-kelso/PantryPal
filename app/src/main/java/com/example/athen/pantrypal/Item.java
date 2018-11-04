package com.example.athen.pantrypal;

public class Item {
    private String name;
    private String category;
    private String expiration;
    private String multipleType;
    private int pricePerMultipleType;

    public Item(String name, String category, String expiration, String multipleType, int pricePerMultipleType) {
        this.name = name;
        this.category = category;
        this.expiration = expiration;
        this.multipleType = multipleType;
        this.pricePerMultipleType = pricePerMultipleType;
    }

    public Item(String name, String category, String expiration) {
        this.name = name;
        this.category = category;
        this.expiration = expiration;
        this.multipleType = name;
        this.pricePerMultipleType = 5;
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

    public String getMultipleType() {
        return multipleType;
    }

    public int getPricePerMultipleType() {
        return pricePerMultipleType;
    }
}
