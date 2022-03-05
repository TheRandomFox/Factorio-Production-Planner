package com.example.factorio_production_planner;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.*;

/*
Desc:
Opens list of all available recipes. Each item on the list is a button.
Clicking a recipe on the list will open an instance of CreateNewProductionActivity for that particular recipe.
Back button returns user to MainActivity.
Methods: onCreate, onBackButtonClick, onRecipeButtonClick
 */
public class BrowseRecipesActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_recipes);

        //initialise and connect buttons with layout
        //interface:
        Button backButton = findViewById(R.id.backButton);

        //get intent
        Intent fromMainActivity = getIntent();
        //List productList = (List<Products>) fromMainActivity.getSerializableExtra("PRODUCT LIST");

        //dynamic button generator?

        //recipe buttons:
        //  excludes items without recipes (i.e. raw materials, fluids)
        //logistics items
        Button ybelt = findViewById(R.id.ybeltButton);
        Button inserter = findViewById(R.id.inserterButton);
        Button pipe = findViewById(R.id.pipeButton);
        Button rail = findViewById(R.id.railButton);

        //production items
        Button prod1 = findViewById(R.id.prod1Button);

        //intermediate items
        Button ironplate = findViewById(R.id.ironplateButton);
        Button copplate = findViewById(R.id.copplateButton);
        Button solidfuel = findViewById(R.id.solidfuelButton);
        Button steelplate = findViewById(R.id.steelplateButton);
        Button plastic = findViewById(R.id.plasticButton);
        Button sulphur = findViewById(R.id.sulphurButton);
        Button battery = findViewById(R.id.batteryButton);
        Button explosive = findViewById(R.id.explosivesButton);
        Button copcable = findViewById(R.id.copcableButton);
        Button ironstick = findViewById(R.id.ironstickButton);
        Button irongear = findViewById(R.id.irongearButton);
        Button grncircuit = findViewById(R.id.grncircuitButton);
        Button redcircuit = findViewById(R.id.redcircuitButton);
        Button bluecircuit = findViewById(R.id.bluecircuitButton);
        Button engineunit = findViewById(R.id.engineunitButton);
        Button elecengine = findViewById(R.id.elecengineButton);
        Button flyingrobot = findViewById(R.id.flyingrobotButton);
        Button rcu = findViewById(R.id.rcuButton);
        Button ldstruct = findViewById(R.id.ldstructButton);
        Button rocketfuel = findViewById(R.id.rocketfuelButton);
        Button redsci = findViewById(R.id.redsciButton);
        Button grnsci = findViewById(R.id.grnsciButton);
        Button blusci = findViewById(R.id.blusciButton);
        Button prpsci = findViewById(R.id.prpsciButton);
        Button yelsci = findViewById(R.id.yelsciButton);
    }

    //Back button behaviour
    public void onBackButtonClick(View view) { finish(); }

    //Recipe buttons behaviour
    public void onRecipeButtonClick(View view)
    {
        Intent newProductionIntent = new Intent(this, ViewRecipeDetailsActivity.class);
        switch(view.getId())
        {
            case R.id.ybeltButton:
                newProductionIntent.putExtra("id", 4);
                break;
            case R.id.inserterButton:
                newProductionIntent.putExtra("id", 14);
                break;
            case R.id.pipeButton:
                newProductionIntent.putExtra("id", 24);
                break;
            case R.id.railButton:
                newProductionIntent.putExtra("id", 27);
                break;
            case R.id.prod1Button:
                newProductionIntent.putExtra("id", 96);
                break;
            case R.id.ironplateButton:
                newProductionIntent.putExtra("id", 116);
                break;
            case R.id.copplateButton:
                newProductionIntent.putExtra("id", 117);
                break;
            case R.id.solidfuelButton:
                newProductionIntent.putExtra("id", 118);
                break;
            case R.id.steelplateButton:
                newProductionIntent.putExtra("id", 119);
                break;
            case R.id.plasticButton:
                newProductionIntent.putExtra("id", 120);
                break;
            case R.id.sulphurButton:
                newProductionIntent.putExtra("id", 121);
                break;
            case R.id.batteryButton:
                newProductionIntent.putExtra("id", 122);
                break;
            case R.id.explosivesButton:
                newProductionIntent.putExtra("id", 123);
                break;
            case R.id.copcableButton:
                newProductionIntent.putExtra("id", 132);
                break;
            case R.id.ironstickButton:
                newProductionIntent.putExtra("id", 133);
                break;
            case R.id.irongearButton:
                newProductionIntent.putExtra("id", 134);
                break;
            case R.id.grncircuitButton:
                newProductionIntent.putExtra("id", 136);
                break;
            case R.id.redcircuitButton:
                newProductionIntent.putExtra("id", 137);
                break;
            case R.id.bluecircuitButton:
                newProductionIntent.putExtra("id", 138);
                break;
            case R.id.engineunitButton:
                newProductionIntent.putExtra("id", 139);
                break;
            case R.id.elecengineButton:
                newProductionIntent.putExtra("id", 140);
                break;
            case R.id.flyingrobotButton:
                newProductionIntent.putExtra("id", 141);
                break;
            case R.id.rcuButton:
                newProductionIntent.putExtra("id", 143);
                break;
            case R.id.ldstructButton:
                newProductionIntent.putExtra("id", 144);
                break;
            case R.id.rocketfuelButton:
                newProductionIntent.putExtra("id", 145);
                break;
            case R.id.redsciButton:
                newProductionIntent.putExtra("id", 153);
                break;
            case R.id.grnsciButton:
                newProductionIntent.putExtra("id", 154);
                break;
            case R.id.blusciButton:
                newProductionIntent.putExtra("id", 156);
                break;
            case R.id.prpsciButton:
                newProductionIntent.putExtra("id", 157);
                break;
            case R.id.yelsciButton:
                newProductionIntent.putExtra("id", 158);
                break;
        }
        startActivity(newProductionIntent);
    }
}