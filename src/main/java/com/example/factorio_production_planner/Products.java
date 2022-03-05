package com.example.factorio_production_planner;

import java.io.Serializable;
import java.util.*;

public class Products
{
    /*
    Desc:
    Defines attributes of each product.
     */

    //attributes
    public static int id;                  //unique reference ID number
    public static String name;             //displayed item name
    public static double baseTime;         //base crafting time in seconds
    public static int noOfOutputs;         //number of output products per cycle
    public static double[] madeIn;         //list of machines that can produce this item
    public static Object[][] components;   //for each object in array == {product object name, qty}

    //constructor
    public Products(int id, String name, double baseTime, int noOfOutputs)
    {
        this.id = id;
        this.name = name;
        this.baseTime = baseTime;
        this.noOfOutputs = noOfOutputs;
        //list-type properties have to be assigned separately
    }

    //getters
    public static int getId() {
        return id;
    }
    public static String getName() {
        return name;
    }
    public static double getBaseTime() {
        return baseTime;
    }
    public static int getNoOfOutputs() {
        return noOfOutputs;
    }
    public static double[] getMadeIn() {
        return madeIn;
    }
    public static Object[][] getComponents() {
        return components;
    }

    public String idToString()
    {
        return String.valueOf(id);
    }


}
