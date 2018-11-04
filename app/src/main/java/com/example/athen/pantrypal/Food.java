package com.example.athen.pantrypal;

public class Food {
    private String name, type, expiration;

    public Food() {
    }

    public Food(String name, String type, String expiration) {
        this.name = name;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
