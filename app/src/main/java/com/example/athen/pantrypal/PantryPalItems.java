package com.example.athen.pantrypal;

import java.util.ArrayList;
import java.util.List;

public class PantryPalItems {
    ArrayList<Item> ItemArr = new ArrayList<Item>();

    Item Spinach = new Item("Spinach", "Vegetable", "7 Days", "oz", 3);
    Item Eggs = new Item("Eggs", "Eggs/Dairy", "7 Days", "dozen", 4);
    Item Carrots = new Item("Carrots", "Vegetable", "7 Days", "carrots", 3);
    Item Potatoes = new Item("Potatoes", "Starch", "7 Days");
    Item Apples = new Item("Apples", "Fruit", "7 Days");
    Item Chicken = new Item("Chicken", "Protein", "7 Days");

    public void createItemArr() {
        ItemArr.add(Spinach);
        ItemArr.add(Eggs);
        ItemArr.add(Carrots);
        ItemArr.add(Potatoes);
        ItemArr.add(Apples);
        ItemArr.add(Chicken);
    }
}
