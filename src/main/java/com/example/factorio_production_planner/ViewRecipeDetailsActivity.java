package com.example.factorio_production_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

/*
Desc:
From BrowseRecipesActivity, user clicks on a recipe button from the list of recipes.
The user is taken to this activity where they are asked to define some parameters for their
new production line. Use spinner menus for selection.
Params:
    - Output goal (int)
        -- Fill yBelt, Fill rBelt, Fill bBelt, Custom input (editText)
    - Production machine used (String)
        -- am1, am2, am3, chemPlant, stoneFur, steelFur, elecFur
    - Modules used (String)
        -- speed1, speed2, speed3
Finally, button to confirm parameters and calculate values. Create new object in
 MainActivity.savedRecipesTable. Export calculated values to there.
 */

public class ViewRecipeDetailsActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_production);
        /*
        Receive getExtra
        Retrieve object id attribute
         */
        Intent fromBrowseRecipes = getIntent();
        int id = fromBrowseRecipes.getExtras().getInt("id");

        ArrayList<Products> productList = loadProductList();

        Products goal = findById(id, productList);
        TextView productNameTextView = findViewById(R.id.recipeNameTextView);

        if(goal != null) {
            productNameTextView.setText(goal.getName());
            init(goal);
        }
        else {
            productNameTextView.setText(getString(R.string.recipe_name_default));
            init(null);
        }
    }

    public void init(Products goal)
    {
        /*
        Generate dynamic recipe ingredient table.
        Based on name given by received Intent, get relevant attribute data from Products class.
        Attributes:
            - int id
            - String name
            - double baseTime
            - int noOfOutputs
            - String[] madeIn
            - Object[][] components
         */
        TableLayout recipeTable = (TableLayout) findViewById(R.id.recipeTableLayout);


        //1st row: Table headers
        TextView productNameTitle = findViewById(R.id.productNameTitleText);    //col 1
        productNameTitle.setText("PRODUCT NAME |");
        productNameTitle.setTextColor(Color.WHITE);
        productNameTitle.setTypeface(null, Typeface.BOLD);
        productNameTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        TextView outputRateTitle = findViewById(R.id.outputRateTitleText);  //col 2
        outputRateTitle.setText("| OUTPUT RATE |");
        outputRateTitle.setTextColor(Color.WHITE);
        outputRateTitle.setTypeface(null, Typeface.BOLD);
        outputRateTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        TextView factsNeededTitle = findViewById(R.id.factoriesNeededTitleText); //col 3
        factsNeededTitle.setText("| FACTORIES NEEDED");
        factsNeededTitle.setTextColor(Color.WHITE);
        factsNeededTitle.setTypeface(null, Typeface.BOLD);
        factsNeededTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        //2nd row: this item
        TableRow tbRow = new TableRow(this); //new row

        TextView tv0 = new TextView(this);  //col 1
        TextView tv1 = new TextView(this);  //col 2
        TextView tv2 = new TextView(this);  //col 3
        //unable to continue while Products class is still broken
    }

    private Products findById(int id, ArrayList<Products> productList)
    {
        /* Receive ID from Intent. Compare against ID attribute of Products instances to find
        matching ID. If match found, return that instance. Else, pop error via toast.
        Params:
            int id
        Returns:
            Product product
            OR, null
        */
        Object id_obj = (Object) id;
        int listLen = productList.size();
        String listSize = String.valueOf(listLen);
        Log.d("productList size", listSize);

        for(Products n : productList)
        {
            Object id_n = n.getId();
            Log.d("idx_n == ", id_n + "::" + n.toString());

            if(id_n == id_obj)
            {
                return n;
            }
        }
        //if reached end of list without returning 'n'
        Toast cantFindItToast = Toast.makeText(getApplicationContext(),
                "Product ID "+ id +" can't be found", Toast.LENGTH_SHORT);
        cantFindItToast.setMargin(25,50);
        cantFindItToast.show();
        return null;
    }

    public ArrayList<Products> loadProductList()
    {
        /* Populate Products list (40 products in curr build)
        Params:
            None
        Returns:
            ArrayList<Products> productList

        The core functionality of the app relies on the implementation of the productList array.
            Without it, the rest of the app can't work. Unfortunately, that's exactly what happened...
        I can't get the 'Products' object class to work properly and I don't know why.
        getId() returns '158' for all 40 objects in the ArrayList and the other attributes
            are completely scrambled junk data.
        The large commented-out section below was an extremely dirty last-ditch workaround attempt.
        It did not work because I did not know that Java cannot return multiple values
            in a single method until it was already too late.
         */
        ArrayList<Products> productList = new ArrayList();

        double am1 = Modifiers.getAm1(); double am2 = Modifiers.getAm2(); double am3 = Modifiers.getAm3();
        double stoneFur = Modifiers.getStoneFur(); double steelFur = Modifiers.getSteelFur();
        double elecFur = Modifiers.getElecFur();
        double chemPlant = Modifiers.getChemPlant();
        
        /*
        //attributes
        int[] listID = new int[40]; //ID
        String[] listName = new String[40]; //Name
        double[] listBaseTime = new double[40]; //Base time
        int[] listNOO = new int[40];    //No. of outputs
        ArrayList<List<Double>> listMadeIn = new ArrayList();   //Made in
        ArrayList<ArrayList<ArrayList<Object>>> listComponents = new ArrayList();   //components
        ArrayList<ArrayList<Object>> comp1 = null;   //components sub-arrays
        ArrayList<Object> comp0 = null;     

        //ArrayList<Products> productList = new ArrayList();
        //LOGISTICS PRODUCTS TAB (id: 0-61)
        //Note: Only 4 commonly used recipes included in this build, to save time.

        listID[0] = 4; listName[0] = "Transport belt"; listBaseTime[0] = 0.5; listNOO[0] = 2;
        List<Double> madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("Iron plate"); comp0.add(1); comp1.add(comp0);
        comp0 = new ArrayList(); //reset comp0
        comp0.add("ironGear"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[1] = 14; listName[1] = "Inserter"; listBaseTime[1] = 0.5; listNOO[1] = 1;
        madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("Iron plate"); comp0.add(1); comp1.add(comp0);
        comp0 = new ArrayList(); //reset comp0
        comp0.add("ironGear"); comp0.add(1); comp1.add(comp0);
        comp0 = new ArrayList(); //reset comp0
        comp0.add("grnCircuit"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[2] = 24; listName[2] = "Pipe"; listBaseTime[2] = 0.5; listNOO[2] = 1;
        madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("Iron plate"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[3] = 27; listName[3] = "Rail"; listBaseTime[3] = 0.5; listNOO[3] = 2;
        madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("steelPlate"); comp0.add(1); comp1.add(comp0);
        comp0 = new ArrayList(); //reset comp0
        comp0.add("ironStick"); comp0.add(1); comp1.add(comp0);
        comp0 = new ArrayList(); //reset comp0
        comp0.add("stone"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        //PRODUCTION TAB (id: 62-100)
        //Note: excluded from build with exception of Productivity Module 1

        listID[4] = 96; listName[4] = "Productivity module 1"; listBaseTime[4] = 15.0; listNOO[4] = 1;
        madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("grnCircuit"); comp0.add(5); comp1.add(comp0);
        comp0 = new ArrayList(); //reset comp0
        comp0.add("redCircuit"); comp0.add(5); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        //INTERMEDIATE PRODUCTS TAB (id: 101-159)
        //Note: Raw resources and fluids have baseTime==0 as it is assumed that supply is infinite for the sake of simplification.
        //noOfOutputs==1 so that the quantity required for consumption can be calculated.

        //      INTERMEDIATE/FLUIDS
        //id:101, crude oil
        listID[5] = 102; listName[5] = "Heavy oil"; listBaseTime[5] = 0; listNOO[5] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[6] = 103; listName[6] = "Light oil"; listBaseTime[6] = 0; listNOO[6] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[7] = 104; listName[7] = "Light oil"; listBaseTime[7] = 0; listNOO[7] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[8] = 105; listName[8] = "Petroleum gas"; listBaseTime[8] = 0; listNOO[8] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[9] = 106; listName[9] = "Sulphuric acid"; listBaseTime[9] = 0; listNOO[9] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[10] = 107; listName[10] = "Water"; listBaseTime[10] = 0; listNOO[10] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        //id:108, steam

        //      INTERMEDIATE/RAW RESOURCES
        //id:109, wood
        listID[11] = 110; listName[11] = "Coal"; listBaseTime[11] = 0; listNOO[11] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[12] = 111; listName[12] = "Stone"; listBaseTime[12] = 0; listNOO[12] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[13] = 112; listName[13] = "Iron ore"; listBaseTime[13] = 0; listNOO[13] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[14] = 113; listName[14] = "Iron ore"; listBaseTime[14] = 0; listNOO[14] = 1;
        madeIn = null;
        listMadeIn.add(madeIn);
        comp0 = null; comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        //id:114, uranium ore
        //id:115, raw fish

        //      INTERMEDIATE/MATERIALS
        listID[15] = 116; listName[15] = "Iron plate"; listBaseTime[15] = 3.2; listNOO[15] = 1;
        madeIn = Arrays.asList(stoneFur, steelFur, elecFur);
        listMadeIn.add(madeIn);
        comp0.add("ironOre"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[16] = 117; listName[16] = "Copper plate"; listBaseTime[16] = 3.2; listNOO[16] = 1;
        madeIn = Arrays.asList(stoneFur, steelFur, elecFur);
        listMadeIn.add(madeIn);
        comp0.add("copperOre"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        //id:118, solid fuel

        listID[17] = 119; listName[17] = "Steel plate"; listBaseTime[17] = 16.0; listNOO[17] = 1;
        madeIn = Arrays.asList(stoneFur, steelFur, elecFur);
        listMadeIn.add(madeIn);
        comp0.add("Iron plate"); comp0.add(5); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[18] = 120; listName[18] = "Plastic bar"; listBaseTime[18] = 1.0; listNOO[18] = 2;
        madeIn = Arrays.asList(chemPlant);
        listMadeIn.add(madeIn);
        comp0.add("Petroleum gas"); comp0.add(20); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[19] = 121; listName[19] = "Sulphur"; listBaseTime[19] = 1.0; listNOO[19] = 2;
        madeIn = Arrays.asList(chemPlant);
        listMadeIn.add(madeIn);
        comp0.add("Petroleum gas"); comp0.add(30); comp1.add(comp0);
        comp0 = new ArrayList();
        comp0.add("Water"); comp0.add(30); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[20] = 122; listName[20] = "Battery"; listBaseTime[20] = 4.0; listNOO[20] = 1;
        madeIn = Arrays.asList(chemPlant);
        listMadeIn.add(madeIn);
        comp0.add("Copper plate"); comp0.add(1); comp1.add(comp0);
        comp0 = new ArrayList();
        comp0.add("Iron plate"); comp0.add(1); comp1.add(comp0);
        comp0 = new ArrayList();
        comp0.add("Sulphuric acid"); comp0.add(20); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[21] = 123; listName[21] = "Explosives"; listBaseTime[21] = 4.0; listNOO[21] = 2;
        madeIn = Arrays.asList(chemPlant);
        listMadeIn.add(madeIn);
        comp0.add("Coal"); comp0.add(1); comp1.add(comp0);
        comp0 = new ArrayList();
        comp0.add("Sulphur"); comp0.add(1); comp1.add(comp0);
        comp0 = new ArrayList();
        comp0.add("Water"); comp0.add(10); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        //id:124, uranium processing -- nuclear tech
        //id:125-131, fluid barrels

        //      INTERMEDIATE/CRAFTING COMPONENTS
        listID[22] = 132; listName[22] = "Copper cable"; listBaseTime[22] = 0.5; listNOO[22] = 2;
        madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("Copper plate"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[23] = 133; listName[23] = "Iron stick"; listBaseTime[23] = 0.5; listNOO[23] = 2;
        madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("Iron plate"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[24] = 134; listName[24] = "Iron gear wheel"; listBaseTime[24] = 0.5; listNOO[24] = 1;
        madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("Iron plate"); comp0.add(2); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        //id:135, empty barrel

        listID[25] = 136; listName[25] = "Electronic circuit"; listBaseTime[25] = 0.5; listNOO[25] = 1;
        madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("Copper plate"); comp0.add(3); comp1.add(comp0);
        listComponents.add(comp1);
        comp0.add("Iron plate"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();

        listID[26] = 137; listName[26] = "Electronic circuit"; listBaseTime[26] = 0.5; listNOO[26] = 1;
        madeIn = Arrays.asList(am1, am2, am3);
        listMadeIn.add(madeIn);
        comp0.add("Copper plate"); comp0.add(3); comp1.add(comp0);
        listComponents.add(comp1);
        comp0.add("Iron plate"); comp0.add(1); comp1.add(comp0);
        listComponents.add(comp1);
        //reset comp0, comp1, madeIn
        comp0 = new ArrayList(); comp1 = new ArrayList(); madeIn = new ArrayList();
        */

        Products yelBelt = new Products(4, "Transport belt", 0.5, 2);
        ((Products) yelBelt).madeIn = new double[]{am1, am2, am3};
        ((Products) yelBelt).components = new Object[][]{{"ironPlate", 1}, {"ironGear", 1}};
        productList.add(yelBelt);

        Products inserter = new Products(14, "Inserter", 0.5, 1);
        inserter.madeIn = new double[]{am1, am2, am3};
        inserter.components = new Object[][]{{"ironPlate", 1}, {"ironGear", 1}, {"grnCircuit", 1}};
        productList.add(inserter);

        Products pipe = new Products(24, "Pipe", 0.5, 1);
        pipe.madeIn = new double[]{am1, am2, am3};
        pipe.components = new Object[][]{{"ironPlate", 1}};
        productList.add(pipe);

        Products rail = new Products(27, "Rail", 0.5, 2);
        rail.madeIn = new double[]{am1, am2, am3};
        rail.components = new Object[][]{{"steelPlate", 1}, {"ironStick", 1}, {"stone", 1}};
        productList.add(rail);

        //PRODUCTION TAB (id: 62-100)
        //Note: excluded from build with exception of Productivity Module 1

        Products prod1 = new Products(96, "Productivity module 1", 15.0, 1);
        prod1.madeIn = new double[]{am1, am2, am3};
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
        ironPlate.madeIn = new double[]{stoneFur, steelFur, elecFur};
        ironPlate.components = new Object[][]{{"ironOre", 1}};
        productList.add(ironPlate);

        Products copPlate = new Products(117, "Copper plate", 3.2, 1);
        copPlate.madeIn = new double[]{stoneFur, steelFur, elecFur};
        copPlate.components = new Object[][]{{"copperOre", 1}};
        productList.add(copPlate);

        Products solidFuel = new Products(118, "Solid fuel", 2.0, 1);
        solidFuel.madeIn = new double[]{chemPlant};
        solidFuel.components = new Object[][]{{"petrol", 20}, {"lightOil", 10}, {"heavyOil", 20}};
        productList.add(solidFuel);

        Products steelPlate = new Products(119, "Steel plate", 16.0, 1);
        steelPlate.madeIn = new double[]{stoneFur, steelFur, elecFur};
        steelPlate.components = new Object[][]{{"ironPlate", 5}};
        productList.add(steelPlate);

        Products plastic = new Products(120, "Plastic bar", 1.0, 2);
        plastic.madeIn = new double[]{chemPlant};
        plastic.components = new Object[][]{{"petrol", 20}};
        productList.add(plastic);

        Products sulphur = new Products(121, "Sulphur", 1.0, 2);
        sulphur.madeIn = new double[]{chemPlant};
        sulphur.components = new Object[][]{{"petrol", 30}, {"water", 30}};
        productList.add(sulphur);

        Products battery = new Products(122, "Battery", 4.0, 1);
        battery.madeIn = new double[]{chemPlant};
        battery.components = new Object[][]{{"copPlate", 1}, {"ironPlate", 1}, {"sulAcid", 20}};
        productList.add(battery);

        Products explosives = new Products(123, "Explosives", 4.0, 2);
        explosives.madeIn = new double[]{chemPlant};
        explosives.components = new Object[][]{{"coal", 1}, {"sulphur", 1}, {"water", 10}};
        productList.add(explosives);

        //id:124, uranium processing -- nuclear tech
        //id:125-131, fluid barrels

        //      INTERMEDIATE/CRAFTING COMPONENTS
        Products copCable = new Products(132, "Copper cable", 0.5, 2);
        copCable.madeIn = new double[]{am1, am2, am3};
        copCable.components = new Object[][]{{"copPlate", 1}};
        productList.add(copCable);

        Products ironStick = new Products(133, "Iron stick", 0.5, 2);
        ironStick.madeIn = new double[]{am1, am2, am3};
        ironStick.components = new Object[][]{{"ironPlate", 1}};
        productList.add(ironStick);

        Products ironGear = new Products(134, "Iron gear wheel", 0.5, 1);
        ironGear.madeIn = new double[]{am1, am2, am3};
        ironGear.components = new Object[][]{{"ironPlate", 2}};
        productList.add(ironGear);

        //id:135, empty barrel

        Products grnCircuit = new Products(136, "Electronic circuit", 0.5, 1);
        grnCircuit.madeIn = new double[]{am1, am2, am3};
        grnCircuit.components = new Object[][]{{"copCable", 3}, {"ironPlate", 1}};
        productList.add(grnCircuit);
        
        Products redCircuit = new Products(137, "Advanced circuit", 6.0, 1);
        redCircuit.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        redCircuit.components = new Object[][]{{"copCable", 4}, {"grnCircuit", 2}, {"plastic", 2}};
        productList.add(redCircuit);

        Products bluCircuit = new Products(138, "Processing unit", 10.0, 1);
        bluCircuit.madeIn = new double[]{Modifiers.getAm2(), Modifiers.getAm3()};
        bluCircuit.components = new Object[][]{{"redCircuit", 2}, {"grnCircuit", 20}, {"sulAcid", 5}};
        productList.add(bluCircuit);

        Products engineUnit = new Products(139, "Engine unit", 10.0, 1);
        engineUnit.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        engineUnit.components = new Object[][]{{"ironGear", 1}, {"pipe", 2}, {"steelPlate", 1}};
        productList.add(engineUnit);

        Products elecEngine = new Products(140, "Electric engine unit", 10.0, 1);
        elecEngine.madeIn = new double[]{Modifiers.getAm2(), Modifiers.getAm3()};
        elecEngine.components = new Object[][]{{"grnCircuit", 2}, {"engineUnit", 1}, {"lube", 15}};
        productList.add(elecEngine);

        Products flyingRobot = new Products(141, "Flying robot frame", 20.0, 1);
        flyingRobot.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        flyingRobot.components = new Object[][]{{"grnCircuit", 3}, {"battery", 2}, {"elecEngine", 1}};
        productList.add(flyingRobot);

        //id:142, rocket part -- dependant on rocket silo

        Products rcu = new Products(143, "Rocket control unit", 30.0, 1);
        rcu.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        rcu.components = new Object[][]{{"bluCircuit", 1}, {"speed1", 1}};
        productList.add(rcu);

        Products ldStruct = new Products(144, "Low density structure", 20.0, 1);
        ldStruct.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        ldStruct.components = new Object[][]{{"Copper plate", 20}, {"steelPlate", 2}, {"plastic", 5}};
        productList.add(ldStruct);

        Products rocketFuel = new Products(145, "Rocket fuel", 30.0, 1);
        rocketFuel.madeIn = new double[]{Modifiers.getAm2(), Modifiers.getAm3()};
        rocketFuel.components = new Object[][]{{"lightOil", 10}, {"solidFuel", 10}};
        productList.add(rocketFuel);

        //id:146-152, nuclear tech

        //      INTERMEDIATE/SCIENCE PACKS
        Products redSci = new Products(153, "Automation science pack", 5.0, 1);
        redSci.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        redSci.components = new Object[][]{{"Copper plate", 1}, {"ironGear", 1}};
        productList.add(redSci);

        Products grnSci = new Products(154, "Logistic science pack", 6.0, 1);
        grnSci.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        grnSci.components = new Object[][]{{"inserter", 1}, {"yBelt", 1}};
        productList.add(grnSci);

        //id:155, black science pack

        Products bluSci = new Products(156, "Chemical science pack", 24.0, 2);
        bluSci.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        bluSci.components = new Object[][]{{"redCircuit", 3}, {"engineUnit", 2}, {"sulphur", 1}};
        productList.add(bluSci);

        Products prpSci = new Products(157, "Production science pack", 21.0, 3);
        prpSci.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        prpSci.components = new Object[][]{{"elecFur", 1}, {"prod1", 1}, {"rail", 30}};
        productList.add(prpSci);

        Products yelSci = new Products(158, "Utility science pack", 21.0, 3);
        yelSci.madeIn = new double[]{Modifiers.getAm1(), Modifiers.getAm2(), Modifiers.getAm3()};
        yelSci.components = new Object[][]{{"flyingRobot", 1}, {"ldStruct", 3}, {"bluCircuit", 2}};
        productList.add(yelSci);
        //id:159, space science -- requires rocket silo
        //MILITARY PRODUCTS TAB (id:160-214) excluded from build

        return productList;
    }
}