package com.example.factorioproductionplanner;

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
public class ViewAllRecipesActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_recipes);
    
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
        Intent newProductionIntent = new Intent(this, CreateNewProductionActivity.class);
        switch(view.getId())
        {
            case R.id.ybeltButton:
                newProductionIntent.putExtra("productName", "Transport belt");
                break;
            case R.id.inserterButton:
                newProductionIntent.putExtra("productName", "Inserter");
                break;
            case R.id.pipeButton:
                newProductionIntent.putExtra("productName", "Pipe");
                break;
            case R.id.railButton:
                newProductionIntent.putExtra("productName", "Rail");
                break;
            case R.id.prod1Button:
                newProductionIntent.putExtra("productName", "Productivity module 1");
                break;
            case R.id.ironplateButton:
                newProductionIntent.putExtra("productName", "Iron plate");
                break;
            case R.id.copplateButton:
                newProductionIntent.putExtra("productName", "Copper plate");
                break;
            case R.id.solidfuelButton:
                newProductionIntent.putExtra("productName", "Solid fuel");
                break;
            case R.id.steelplateButton:
                newProductionIntent.putExtra("productName", "Steel plate");
                break;
            case R.id.plasticButton:
                newProductionIntent.putExtra("productName", "Plastic bar");
                break;
            case R.id.sulphurButton:
                newProductionIntent.putExtra("productName", "Sulphur");
                break;
            case R.id.batteryButton:
                newProductionIntent.putExtra("productName", "Battery");
                break;
            case R.id.explosivesButton:
                newProductionIntent.putExtra("productName", "Explosives");
                break;
            case R.id.copcableButton:
                newProductionIntent.putExtra("productName", "Copper cable");
                break;
            case R.id.ironstickButton:
                newProductionIntent.putExtra("productName", "Iron stick");
                break;
            case R.id.irongearButton:
                newProductionIntent.putExtra("productName", "Iron gear wheel");
                break;
            case R.id.grncircuitButton:
                newProductionIntent.putExtra("productName", "Electronic circuit");
                break;
            case R.id.redcircuitButton:
                newProductionIntent.putExtra("productName", "Advanced circuit");
                break;
            case R.id.bluecircuitButton:
                newProductionIntent.putExtra("productName", "Processing unit");
                break;
            case R.id.engineunitButton:
                newProductionIntent.putExtra("productName", "Engine unit");
                break;
            case R.id.elecengineButton:
                newProductionIntent.putExtra("productName", "Electric engine unit");
                break;
            case R.id.flyingrobotButton:
                newProductionIntent.putExtra("productName", "Flying robot frame");
                break;
            case R.id.rcuButton:
                newProductionIntent.putExtra("productName", "Rocket control unit");
                break;
            case R.id.ldstructButton:
                newProductionIntent.putExtra("productName", "Low density structure");
                break;
            case R.id.rocketfuelButton:
                newProductionIntent.putExtra("productName", "Rocket fuel");
                break;
            case R.id.redsciButton:
                newProductionIntent.putExtra("productName", "Automation science pack");
                break;
            case R.id.grnsciButton:
                newProductionIntent.putExtra("productName", "Logistic science pack");
                break;
            case R.id.blusciButton:
                newProductionIntent.putExtra("productName", "Chemical science pack");
                break;
            case R.id.prpsciButton:
                newProductionIntent.putExtra("productName", "Production science pack");
                break;
            case R.id.yelsciButton:
                newProductionIntent.putExtra("productName", "Utility science pack");
                break;
        }
        startActivity(newProductionIntent);
    }
}