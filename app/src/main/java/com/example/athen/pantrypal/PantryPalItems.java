package com.example.athen.pantrypal;

import java.util.ArrayList;
import java.util.List;

public class PantryPalItems {
    ArrayList<Item> ItemArr = new ArrayList<Item>();

    Item Spinach = new Item("Spinach", "Vegetable", "7 Days", "oz", 3);
    Item Eggs = new Item("Eggs", "Eggs/Dairy", "21 Days", "dozen", 4);
    Item Carrots = new Item("Carrots", "Vegetable", "21 Days", "carrots", 3);
    Item Potatoes = new Item("Potatoes", "Starch", "60 Days", "potatoes", 2);
    Item Apples = new Item("Apples", "Fruit", "40 Days", "apple", 4);
    Item Chicken = new Item("Chicken", "Protein", "2 Days", "chicken", 5);
    Item Oranges = new Item("Oranges", "Fruit", "6 Days", "oranges", 3);
    Item Bananas = new Item("Bananas", "Fruit", "6 days", "bananas", 2);

    public void createItemArr() {
        ItemArr.add(Spinach);
        ItemArr.add(Eggs);
        ItemArr.add(Carrots);
        ItemArr.add(Potatoes);
        ItemArr.add(Apples);
        ItemArr.add(Chicken);
        ItemArr.add(Oranges);
        ItemArr.add(Bananas);
    }
}
