package com.example.factorioproductionplanner;

import java.io.Serializable;
import java.util.*;

public class Products implements Serializable
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
    public static String[] madeIn;         //list of machines that can produce this item
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
    public static String[] getMadeIn() {
        return madeIn;
    }
    public static Object[][] getComponents() {
        return components;
    }
    
    public static List loadProductList()
    {
        //Populate products list
        /*
        Excluded elements due to lack of time:
            - All Production tech, except "Productivity Module 1"
            - All Military tech
            - All nuclear tech
            - Most of Logistics tech
            - Rocket Silo and techs/products that require it
    
        Included Logistics tech:
            - Transport belt (yBelt)
            - inserter
            - pipe
            - rail
    
        object template to copy-paste:
            Products name = new Products(int, String, double, int);
            name.madeIn = new String[]{};
            name.components = new Object[][]{{}};
            productList.add(name);
         */
        
        List productList = new ArrayList();
        
        //LOGISTICS PRODUCTS TAB (id: 0-61)
        //Note: Only 4 commonly used recipes included in this build, to save time.
        
        Object yelBelt = new Products(4, "Transport belt", 0.5, 2);
        ((Products) yelBelt).madeIn = new String[]{"am1", "am2", "am3"};
        ((Products) yelBelt).components = new Object[][]{{"ironPlate", 1}, {"ironGear", 1}};
        productList.add(yelBelt);
        
        Products inserter = new Products(14, "Inserter", 0.5, 1);
        inserter.madeIn = new String[]{"am1", "am2", "am3"};
        inserter.components = new Object[][]{{"ironPlate", 1}, {"ironGear", 1}, {"grnCircuit", 1}};
        productList.add(inserter);
        
        Products pipe = new Products(24, "Pipe", 0.5, 1);
        pipe.madeIn = new String[]{"am1", "am2", "am3"};
        pipe.components = new Object[][]{{"ironPlate", 1}};
        productList.add(pipe);
        
        Products rail = new Products(27, "Rail", 0.5, 2);
        rail.madeIn = new String[]{"am1", "am2", "am3"};
        rail.components = new Object[][]{{"steelPlate", 1}, {"ironStick", 1}, {"stone", 1}};
        productList.add(rail);
        
        //PRODUCTION TAB (id: 62-100)
        //Note: excluded from build with exception of Productivity Module 1
        
        Products prod1 = new Products(96, "Productivity module 1", 15.0, 1);
        prod1.madeIn = new String[]{"am1", "am2", "am3"};
        prod1.components = new Object[][]{{"grnCircuit", 5}, {"redCircuit", 5}};
        productList.add(prod1);
        
        //INTERMEDIATE PRODUCTS TAB (id: 101-159)
        //Note: Raw resources and fluids have baseTime==0 as it is assumed that supply is infinite for the sake of simplification.
        //noOfOutputs==1 so that the quantity required for consumption can be calculated.
        
        //      INTERMEDIATE/FLUIDS
        //id:101, crude oil
        Products heavyOil = new Products(102, "Heavy oil", 0, 1);
        productList.add(heavyOil);
        Products lightOil = new Products(103, "Light oil", 0, 1);
        productList.add(lightOil);
        Products lube = new Products(104, "Lubricant", 0, 1);
        productList.add(lube);
        Products petrol = new Products(105, "Petroleum gas", 0, 1);
        productList.add(petrol);
        Products sulAcid = new Products(106, "Sulphuric acid", 0, 1);
        productList.add(sulAcid);
        Products water = new Products(107, "Water", 0, 1);
        productList.add(water);
        //id:108, steam
        
        //      INTERMEDIATE/RAW RESOURCES
        //id:109, wood
        Products coal = new Products(110, "Coal", 0, 1);
        productList.add(coal);
        Products stone = new Products(111, "Stone", 0, 1);
        productList.add(stone);
        Products ironOre = new Products(112, "Iron ore", 0, 1);
        productList.add(ironOre);
        Products copperOre = new Products(113, "Copper ore", 0, 1);
        productList.add(copperOre);
        //id:114, uranium ore
        //id:115, raw fish
        
        //      INTERMEDIATE/MATERIALS
        Products ironPlate = new Products(116, "Iron plate", 3.2, 1);
        ironPlate.madeIn = new String[]{"stoneFur", "steelFur", "elecFur"};
        ironPlate.components = new Object[][]{{"ironOre", 1}};
        productList.add(ironPlate);
        
        Products copPlate = new Products(117, "Copper plate", 3.2, 1);
        copPlate.madeIn = new String[]{"stoneFur", "steelFur", "elecFur"};
        copPlate.components = new Object[][]{{"copperOre", 1}};
        productList.add(copPlate);
        
        Products solidFuel = new Products(118, "Solid fuel", 2.0, 1);
        solidFuel.madeIn = new String[]{"chemPlant"};
        solidFuel.components = new Object[][]{{"petrol", 20}, {"lightOil", 10}, {"heavyOil", 20}};
        productList.add(solidFuel);
        
        Products steelPlate = new Products(119, "Steel plate", 16.0, 1);
        steelPlate.madeIn = new String[]{"stoneFur", "steelFur", "elecFur"};
        steelPlate.components = new Object[][]{{"ironPlate", 5}};
        productList.add(steelPlate);
        
        Products plastic = new Products(120, "Plastic bar", 1.0, 2);
        plastic.madeIn = new String[]{"chemPlant"};
        plastic.components = new Object[][]{{"petrol", 20}};
        productList.add(plastic);
        
        Products sulphur = new Products(121, "Sulphur", 1.0, 2);
        sulphur.madeIn = new String[]{"chemPlant"};
        sulphur.components = new Object[][]{{"petrol", 30}, {"water", 30}};
        productList.add(sulphur);
        
        Products battery = new Products(122, "Battery", 4.0, 1);
        battery.madeIn = new String[]{"chemPlant"};
        battery.components = new Object[][]{{"copPlate", 1}, {"ironPlate", 1}, {"sulAcid", 20}};
        productList.add(battery);
        
        Products explosives = new Products(123, "Explosives", 4.0, 2);
        explosives.madeIn = new String[]{"chemPlant"};
        explosives.components = new Object[][]{{"coal", 1}, {"sulphur", 1}, {"water", 10}};
        productList.add(explosives);
        
        //id:124, uranium processing -- nuclear tech
        //id:125-131, fluid barrels
        
        //      INTERMEDIATE/CRAFTING COMPONENTS
        Products copCable = new Products(132, "Copper cable", 0.5, 2);
        copCable.madeIn = new String[]{"am1", "am2", "am3"};
        copCable.components = new Object[][]{{"copPlate", 1}};
        productList.add(copCable);
        
        Products ironStick = new Products(133, "Iron stick", 0.5, 2);
        ironStick.madeIn = new String[]{"am1", "am2", "am3"};
        ironStick.components = new Object[][]{{"ironPlate", 1}};
        productList.add(ironStick);
        
        Products ironGear = new Products(134, "Iron gear wheel", 0.5, 1);
        ironGear.madeIn = new String[]{"am1", "am2", "am3"};
        ironGear.components = new Object[][]{{"ironPlate", 2}};
        productList.add(ironGear);
        
        //id:135, empty barrel
        
        Products grnCircuit = new Products(136, "Electronic circuit", 0.5, 1);
        grnCircuit.madeIn = new String[]{"am1", "am2", "am3"};
        grnCircuit.components = new Object[][]{{"copCable", 3}, {"ironPlate", 1}};
        productList.add(grnCircuit);
        
        Products redCircuit = new Products(137, "Advanced circuit", 6.0, 1);
        redCircuit.madeIn = new String[]{"am1", "am2", "am3"};
        redCircuit.components = new Object[][]{{"copCable", 4}, {"grnCircuit", 2}, {"plastic", 2}};
        productList.add(redCircuit);
        
        Products bluCircuit = new Products(138, "Processing unit", 10.0, 1);
        bluCircuit.madeIn = new String[]{"am2", "am3"};
        bluCircuit.components = new Object[][]{{"redCircuit", 2}, {"grnCircuit", 20}, {"sulAcid", 5}};
        productList.add(bluCircuit);
        
        Products engineUnit = new Products(139, "Engine unit", 10.0, 1);
        engineUnit.madeIn = new String[]{"am1", "am2", "am3"};
        engineUnit.components = new Object[][]{{"ironGear", 1}, {"pipe", 2}, {"steelPlate", 1}};
        productList.add(engineUnit);
        
        Products elecEngine = new Products(140, "Electric engine unit", 10.0, 1);
        elecEngine.madeIn = new String[]{"am2", "am3"};
        elecEngine.components = new Object[][]{{"grnCircuit", 2}, {"engineUnit", 1}, {"lube", 15}};
        productList.add(elecEngine);
        
        Products flyingRobot = new Products(141, "Flying robot frame", 20.0, 1);
        flyingRobot.madeIn = new String[]{"am1", "am2", "am3"};
        flyingRobot.components = new Object[][]{{"grnCircuit", 3}, {"battery", 2}, {"elecEngine", 1}};
        productList.add(flyingRobot);
        
        //id:142, rocket part -- dependant on rocket silo
        
        Products rcu = new Products(143, "Rocket control unit", 30.0, 1);
        rcu.madeIn = new String[]{"am1", "am2", "am3"};
        rcu.components = new Object[][]{{"bluCircuit", 1}, {"speed1", 1}};
        productList.add(rcu);
        
        Products ldStruct = new Products(144, "Low density structure", 20.0, 1);
        ldStruct.madeIn = new String[]{"am1", "am2", "am3"};
        ldStruct.components = new Object[][]{{"copPlate", 20}, {"steelPlate", 2}, {"plastic", 5}};
        productList.add(ldStruct);
        
        Products rocketFuel = new Products(145, "Rocket fuel", 30.0, 1);
        rocketFuel.madeIn = new String[]{"am2", "am3"};
        rocketFuel.components = new Object[][]{{"lightOil", 10}, {"solidFuel", 10}};
        productList.add(rocketFuel);
        
        //id:146-152, nuclear tech
        
        //      INTERMEDIATE/SCIENCE PACKS
        Products redSci = new Products(153, "Automation science pack", 5.0, 1);
        redSci.madeIn = new String[]{"am1", "am2", "am3"};
        redSci.components = new Object[][]{{"copPlate", 1}, {"ironGear", 1}};
        productList.add(redSci);
        
        Products grnSci = new Products(154, "Logistic science pack", 6.0, 1);
        grnSci.madeIn = new String[]{"am1", "am2", "am3"};
        grnSci.components = new Object[][]{{"inserter", 1}, {"yBelt", 1}};
        productList.add(grnSci);
        
        //id:155, black science pack
        
        Products bluSci = new Products(156, "Chemical science pack", 24.0, 2);
        bluSci.madeIn = new String[]{"am1", "am2", "am3"};
        bluSci.components = new Object[][]{{"redCircuit", 3}, {"engineUnit", 2}, {"sulphur", 1}};
        productList.add(bluSci);
        
        Products prpSci = new Products(157, "Production science pack", 21.0, 3);
        prpSci.madeIn = new String[]{"am1", "am2", "am3"};
        prpSci.components = new Object[][]{{"elecFur", 1}, {"prod1", 1}, {"rail", 30}};
        productList.add(prpSci);
        
        Products yelSci = new Products(158, "Utility science pack", 21.0, 3);
        yelSci.madeIn = new String[]{"am1", "am2", "am3"};
        yelSci.components = new Object[][]{{"flyingRobot", 1}, {"ldStruct", 3}, {"bluCircuit", 2}};
        productList.add(yelSci);
        
        //id:159, space science -- requires rocket silo
        
        //MILITARY PRODUCTS TAB (id:160-214)
        //Note: excluded from build
        return productList;
    }
}
