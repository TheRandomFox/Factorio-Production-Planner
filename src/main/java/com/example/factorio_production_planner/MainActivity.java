package com.example.factorio_production_planner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.*;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //call method: savedProductions()

        //initialise buttons
        Button viewRecipesButton = findViewById(R.id.viewRecipesButton);
    }

    /*
    Method: 'View Recipe list' button
    From this activity, go to BrowseRecipesActivity.
    */
    public void onViewRecipesButtonClick(View view)
    {
        Intent viewRecipes = new Intent(this, BrowseRecipesActivity.class);
        //viewRecipes.putExtra("PRODUCT LIST", (Serializable) this.productList);
        startActivity(viewRecipes);
    }


    /*
    Method: generate saved productions list
    Check for saved data file. If not null, display contents in list.
    */
}