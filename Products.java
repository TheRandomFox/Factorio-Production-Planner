package com.example.factorioproductionplanner;

public class Products {
    //attributes
    private String itemName; //displayed name
    private int itemId;         //unique ID for referencing object
    private double baseTime;    //base crafting time in seconds
    private int noOfOutputs;    //number of output products per cycle
    private int[][] components; //for each object in array == {itemId, qty}

    //methods
    //nil
}
