package com.example.factorioproductionplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.*;

/*
Desc:
From ViewAllRecipesActivity, user clicks on a recipe button from the list of recipes.
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

public class CreateNewProductionActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_production);
        
        /*
        Receive getExtra String
        Retrieve object attributes
         */
        Intent intent = getIntent();
        String productName = intent.getStringExtra("productName");
        
        TextView productNameTextView = findViewById(R.id.recipeNameTextView);
        //productNameTextView.setText(.name);
        init();
    }
    
    public void init()
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
        //1st row: title text
        TableRow tbRow = new TableRow(this);    //new row
        
        TextView tv0 = new TextView(this);  //col 1
        tv0.setText("   PRODUCT NAME   ");
        tv0.setTextColor(Color.WHITE);
        tv0.setTypeface(null, Typeface.BOLD);
        tv0.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tbRow.addView(tv0);
        
        TextView tv1 = new TextView(this);  //col 2
        tv1.setText("   OUTPUT RATE   ");
        tv1.setTextColor(Color.WHITE);
        tv1.setTypeface(null, Typeface.BOLD);
        tv1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tbRow.addView(tv1);
        
        TextView tv2 = new TextView(this);  //col 3
        tv2.setText("  FACTORIES NEEDED  ");
        tv2.setTextColor(Color.WHITE);
        tv2.setTypeface(null, Typeface.BOLD);
        tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tbRow.addView(tv2);
        recipeTable.addView(tbRow);  //add row to table

        //2nd row: this item
        tbRow = new TableRow(this);    //new row
        
        tv0 = new TextView(this);  //col 1
    }
    
    //private List findByName()
    {
        //for(i=0; i<productList.length)
    }
}