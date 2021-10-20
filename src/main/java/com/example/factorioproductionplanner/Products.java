package com.example.factorioproductionplanner;

import java.util.List;

public class Products {
    /*
    Desc:
    Defines attributes of each product.
     */

    //attributes
    public String name;            //displayed item name
    public double baseTime;        //base crafting time in seconds
    public int noOfOutputs;        //number of output products per cycle
    public String[] madeIn;        //list of machines that can produce this item
    public Object[][] components;   //for each object in array == {product object name, qty}

    //constructor
    public Products(String name, double baseTime, int noOfOutputs)
    {
        this.name = name;
        this.baseTime = baseTime;
        this.noOfOutputs = noOfOutputs;
    }

    //getters
    public String getName() {
        return name;
    }
    public double getBaseTime() {
        return baseTime;
    }
    public int getNoOfOutputs() {
        return noOfOutputs;
    }
    public String[] getMadeIn() {
        return madeIn;
    }
    public Object[][] getComponents() {
        return components;
    }

    //Populate item database
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
        Products name = new Products(String, double, int);
        name.madeIn = new String[]{};
        name.components = new Object[][]{{}};
     */
    public static void product(String[] args)
    {
        /*
        LOGISTICS PRODUCTS TAB
                Note: Only 4 commonly used recipes included in this build, to save time.
         */

        Products yBelt = new Products("Transport belt", 0.5, 2);
        yBelt.madeIn = new String[]{"am1", "am2", "am3"};
        yBelt.components = new Object[][]{{"ironPlate", 1}, {"ironGear", 1}};

        Products inserter = new Products("Inserter", 0.5, 1);
        inserter.madeIn = new String[]{"am1", "am2", "am3"};
        inserter.components = new Object[][]{{"ironPlate", 1}, {"ironGear", 1}, {"grnCircuit", 1}};

        Products pipe = new Products("Pipe", 0.5, 1);
        pipe.madeIn = new String[]{"am1", "am2", "am3"};
        pipe.components = new Object[][]{{"ironPlate", 1}};

        Products rail = new Products("Rail", 0.5, 2);
        rail.madeIn = new String[]{"am1", "am2", "am3"};
        rail.components = new Object[][]{{"steelPlate", 1}, {"ironStick", 1}, {"stone", 1}};

        /*
        PRODUCTION TAB
                Note: excluded from build with exception of Productivity Module 1
         */

        Products prod1 = new Products("Productivity module 1",15.0,1);
        prod1.madeIn = new String[]{"am1", "am2", "am3"};
        prod1.components = new Object[][]{{"grnCircuit",5}, {"redCircuit",5}};

        /*
        INTERMEDIATE PRODUCTS TAB
                Note: Raw resources and fluids have baseTime==0 as it is assumed that supply is infinite for the sake of simplification.
                noOfOutputs==1 so that the quantity required for consumption can be calculated.
         */

        //      INTERMEDIATE/FLUIDS
        Products water = new Products("Water", 0, 1);
        Products petrol = new Products("Petroleum gas", 0, 1);
        Products lightOil = new Products("Light oil",0,1);
        Products heavyOil = new Products("Heavy oil", 0,1);
        Products sulAcid = new Products("Sulphuric acid", 0, 1);
        Products lube = new Products("Lubricant",0,1);

        //      INTERMEDIATE/RAW RESOURCES
        Products ironOre = new Products("Iron ore",0,1);
        Products copperOre = new Products("Copper ore",0,1);
        Products coal = new Products("Coal",0,1);
        Products stone = new Products("Stone",0,1);

        //      INTERMEDIATE/MATERIALS
        Products ironPlate = new Products("Iron plate",3.2,1);
        ironPlate.madeIn = new String[]{"stoneFur", "steelFur", "elecFur"};
        ironPlate.components = new Object[][]{{"ironOre", 1}};

        Products copperPlate = new Products("Copper plate",3.2,1);
        copperPlate.madeIn = new String[]{"stoneFur", "steelFur", "elecFur"};
        copperPlate.components = new Object[][]{{"copperOre", 1}};

        Products steelPlate = new Products("Steel plate",16.0,1);
        steelPlate.madeIn = new String[]{"stoneFur", "steelFur", "elecFur"};
        steelPlate.components = new Object[][]{{"ironPlate", 5}};

        Products solidFuel = new Products("Solid fuel",2.0,1);
        solidFuel.madeIn = new String[]{"chemPlant"};
        solidFuel.components = new Object[][]{{"petrol", 20}, {"lightOil", 10}, {"heavyOil", 20}};

        Products plasticBar = new Products("Plastic bar",1.0,2);
        plasticBar.madeIn = new String[]{"chemPlant"};
        plasticBar.components = new Object[][]{{"petrol", 20}};

        Products sulphur = new Products("Sulphur",1.0,2);
        sulphur.madeIn = new String[]{"chemPlant"};
        sulphur.components = new Object[][]{{"petrol", 30}, {"water", 30}};

        Products battery = new Products("Battery",4.0,1);
        battery.madeIn = new String[]{"chemPlant"};
        battery.components = new Object[][]{{"copperPlate", 1}, {"ironPlate", 1}, {"sulAcid", 20}};

        Products explosive = new Products("Explosives",4.0,2);
        explosive.madeIn = new String[]{"chemPlant"};
        explosive.components = new Object[][]{{"coal", 1}, {"sulphur", 1}, {"water", 10}};

        //      INTERMEDIATE/CRAFTING COMPONENTS
        Products copperCable = new Products("Copper cable",0.5,2);
        copperCable.madeIn = new String[]{"am1", "am2", "am3"};
        copperCable.components = new Object[][]{{"copperPlate", 1}};

        Products ironStick = new Products("Iron stick",0.5,2);
        ironStick.madeIn = new String[]{"am1", "am2", "am3"};
        ironStick.components = new Object[][]{{"ironPlate", 1}};

        Products ironGear = new Products("Iron gear wheel",0.5,1);
        ironGear.madeIn = new String[]{"am1", "am2", "am3"};
        ironGear.components = new Object[][]{{"ironPlate", 2}};

        Products grnCircuit = new Products("Electronic circuit",0.5,1);
        grnCircuit.madeIn = new String[]{"am1", "am2", "am3"};
        grnCircuit.components = new Object[][]{{"copperCable", 3}, {"ironPlate", 1}};

        Products redCircuit = new Products("Advanced circuit",6.0,1);
        redCircuit.madeIn = new String[]{"am1", "am2", "am3"};
        redCircuit.components = new Object[][]{{"copperCable", 4}, {"grnCircuit", 2}, {"plasticBar", 2}};

        Products blueCircuit = new Products("Processing unit",10.0,1);
        blueCircuit.madeIn = new String[]{"am2", "am3"};
        blueCircuit.components = new Object[][]{{"redCircuit", 2}, {"grnCircuit", 20}, {"sulAcid", 5}};

        Products engineUnit = new Products("Engine unit",10.0,1);
        engineUnit.madeIn = new String[]{"am1", "am2", "am3"};
        engineUnit.components = new Object[][]{{"ironGear", 1}, {"pipe", 2}, {"steelPlate", 1}};

        Products elecEngine = new Products("Electric engine unit",10.0,1);
        elecEngine.madeIn = new String[]{"am2", "am3"};
        elecEngine.components = new Object[][]{{"grnCircuit", 2}, {"engineUnit", 1}, {"lube", 15}};

        Products flyingRobot = new Products("Flying Robot Frame",20.0,1);
        flyingRobot.madeIn = new String[]{"am1", "am2", "am3"};
        flyingRobot.components = new Object[][]{{"grnCircuit", 3}, {"battery", 2}, {"elecEngine", 1}};

        /*
        Products rocketPart = new Products("Rocket part",3.0.,1);           //dependant on rocket silo
        rocketPart.madeIn = new String[]{};
        rocketPart.components = new Object[][]{{}};
        */

        Products rcu = new Products("Rocket control unit",30.0,1);
        rcu.madeIn = new String[]{"am1", "am2", "am3"};
        rcu.components = new Object[][]{{"blueCircuit", 1}, {"speed1", 1}};

        Products ldStruct = new Products("Low density structure",20.0,1);
        ldStruct.madeIn = new String[]{"am1", "am2", "am3"};
        ldStruct.components = new Object[][]{{"copperPlate", 20}, {"steelPlate", 2}, {"plasticBar", 5}};

        Products rocketFuel = new Products("Rocket fuel",30.0,1);
        rocketFuel.madeIn = new String[]{"am2", "am3"};
        rocketFuel.components = new Object[][]{{"lightOil", 10}, {"solidFuel", 10}};

        /*
        Products nukeFuel = new Products("Nuclear fuel", x, x);           //nuclear tech
        rocketFuel.madeIn = new String[]{};
        rocketFuel.components = new Object[][]{{}};
         */

        //      INTERMEDIATE/SCIENCE PACKS
        Products redSci = new Products("Automation science pack",5.0,1);
        redSci.madeIn = new String[]{"am1", "am2", "am3"};
        redSci.components = new Object[][]{{"copperPlate", 1}, {"ironGear", 1}};

        Products grnSci = new Products("Logistic science pack",6.0,1);
        grnSci.madeIn = new String[]{"am1", "am2", "am3"};
        grnSci.components = new Object[][]{{"inserter", 1}, {"yBelt", 1}};
        /*
        Products blkSci = new Products("Military science pack",10.0,2);             //Dependant on Military Products
        blkSci.madeIn = new String[]{"am1", "am2", "am3"};
        blkSci.components = new Object[][]{{"grenade", 1}, {"redMag", 1}, {"wall", 2}};
        */
        Products bluSci = new Products("Chemical science pack",24.0,2);
        bluSci.madeIn = new String[]{"am1", "am2", "am3"};
        bluSci.components = new Object[][]{{"redCircuit", 3}, {"engineUnit", 2}, {"sulphur", 1}};

        Products purpSci = new Products("Production science pack",21.0,3);
        purpSci.madeIn = new String[]{"am1", "am2", "am3"};
        purpSci.components = new Object[][]{{"elecFur", 1}, {"prod1", 1}, {"rail", 30}};

        Products yelSci = new Products("Utility science pack",21.0,3);
        yelSci.madeIn = new String[]{"am1", "am2", "am3"};
        yelSci.components = new Object[][]{{"flyingRobot", 1}, {"ldStruct", 3}, {"blueCircuit", 2}};

        /*
        MILITARY PRODUCTS TAB
                Note: excluded from build
         */
    }
}
