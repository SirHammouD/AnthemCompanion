package com.project.hammy.anthemcompanion;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;


public class ComponentsActivity extends AppCompatActivity{


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    NavigationView navigationView;
    private AdView mAdView;
    private SearchView searchView;
    private RecyclerAdapter adapter;

    private int[] images = {R.drawable.comp1,R.drawable.comp2,R.drawable.comp3,R.drawable.comp4,R.drawable.comp5,R.drawable.comp6,R.drawable.comp7,R.drawable.comp8,
            R.drawable.comp9,R.drawable.comp10,R.drawable.comp11,R.drawable.comp12,R.drawable.comp13,R.drawable.comp14,R.drawable.comp16,R.drawable.comp17,R.drawable.comp18,R.drawable.comp19,
            R.drawable.comp20,R.drawable.comp21,R.drawable.comp22,R.drawable.comp23,R.drawable.comp24,R.drawable.comp25,R.drawable.comp16,R.drawable.comp27,R.drawable.comp28,R.drawable.comp29,
            R.drawable.comp30,R.drawable.comp31,R.drawable.comp32,R.drawable.comp33,R.drawable.comp34,R.drawable.comp35,R.drawable.comp36,R.drawable.comp37,R.drawable.comp38,R.drawable.comp39,
            R.drawable.comp40,R.drawable.comp41,R.drawable.comp42,R.drawable.comp43,R.drawable.comp44,R.drawable.comp45,R.drawable.comp46,R.drawable.comp47,R.drawable.comp48,R.drawable.comp49,
            R.drawable.comp50,R.drawable.comp51,R.drawable.comp52,R.drawable.comp53,R.drawable.comp54,R.drawable.comp55,R.drawable.comp56,R.drawable.comp57,R.drawable.comp58,R.drawable.comp59,
            R.drawable.comp60,R.drawable.comp61};


    private String[] titles = {"Ranger Combo Augment","Advanced Circuitry","Assault Augment","Convergence Core","Crossed Arms","Firearm Calibration Core","Grenade Augment",
    "Grenadier Inscription","Thermal Regulator","Vented Thrusters","Airborne Advantage","Colossus Combo Augment","Autocannon Ammo","Colossal Stock Augment","Colossal Storage Augment",
    "Explosives Expert","Guardian Insignia","Heavy Assault Augment","Heavy Shield Reinforcement","Ordnance Augment","Overclocked Regulator","Structural Reinforcement","Interceptor Combo Augment",
    "Way of the Bold","Amphibious Augment","Assault System Augment","Battle Inscription","Blade Inscription","Conductivity Augment","Diverted Energy Circuit","Survival Algorithm",
    "Double-Edged Inscription","Vengeance Matrix","Gunner's Inscription","Way of Salvage","Strike System Augment","Way of the Swift","Storm Combo Augment","Chaos Core","Elemental Attunement",
    "Elemental Conduit","Elemental Empowerment","Elemental Synergy","Fire Inscription","Ice Inscription","Integrity Augment","Lightning Inscription","Ammo Compartment","Armor Reinforcement",
    "Assault Rifle Ammo","Heat Sink","Light Machine Gun Ammo","Machine Pistol Ammo","Marksman Rifle Ammo","Melee Inscription","Shield Reinforcement","Shotgun Ammo","Sniper Rifle Ammo","Special Arms Ammo","Ultimate Inscription"};


    private String[] desc = {"Increases combo damage by 50% of base damage.",
            "Increases melee damage by 30% of base and electric effect by 30% of base.",
            "Enhances the assault launcher to increase damage by 5% of base damage.",
            "Increases impact damage by 35% of base and decreases blast damage by -35% of base.",
            "Increases blast damage by 50% of base and lowers impact damage by -20% of base.",
            "Increases damage with all guns by 25% of base damage.",
            "Increases grenade damage by 5% of base damage.",
            "Increases grenade recharge rate by 35% of base speed.",
            "Increases fire damage max heat capacity by 20% of base values, and fire resistance by 20%.",
            "Increases the threshold before overheating occurs by 35% of the base threshold.",
            "Increases impact damage by 50% and decreases blast damage by -20%. Hovering increases all resistances by 10%.",

    "Increases combo damage by 50% of base damage.",
            "Adds specialized storage for enhanced autocannon ammunition to increase damage by 5% of base damage.",
            "Increases maximum magazine size of all guns by 35% of base value.",
            "Increases maximum ammo capacity by 35% of base capacity.",
            "All blast damage is increased by 15% of base damge.",
            "Increase duration of support abilities by 50% of base value.",
            "Enhances the heavy-assault launcher to increase damage by 5% of base damage.",
            "Increases damage of Colossus shield damage while sprinting by 300% of base damage.",
            "Enhances the ordnance launcher to increase damage by 5% of base damage.",
            "Increases lightning and fire damage by 35% of base damage.",
            "Heavily reinforces the Colossus armor and shields.",

    "Increases aura combo pulse frequency by 40% of base.",
            "Increases aura combo pulse strength by 40% of base. Defeating an enemy with a melee restores 20% armor.",
            "Increases acid damage and oxygen capacity by 20% of base values and acid resistance by 20%.",
            "Enhances the assault system to increase damage by 5% of base.",
            "Increases weapon damage by 25% of base damage.",
            "An inscribed component that enhances Interceptor melee strikes to increase damage by 10% of base damage.",
            "Increases electricity damage, electricity resistance, and gear cooldown speed by 20% of base value.",
            "Increases maximum shields by 35% of base and decreases armor by -35% of base.",
            "Increases maximum shields by 35% of base and decreases armor by -35% of base. Clearing a negative status recharges shields by 20%. Can occur once every 10 seconds.",
            "Increases all damage dealt by 35% of base damage and damage taken by -35% of base.",
            "Increases all damage dealt by 50% of base damage and damage taken by -25% of base. On low health, all damage is increased by 25% for 5 seconds.",
            "Increases weapon magazine size by 30% of base and ammo drop rate by 50% of base.",
            "Increases weapon magazine size by 30% of base and ammo drop rate by 50% of base. Collecting ammo increases weapon damage by 40% for 5 seconds",
            "Enhances the strike system to increase damage by 5% of base damage.",
            "Enhances the assault system to increase damage by 5%. Any Assault System hit increases Strike System Damage by 50% for 5 seconds.",

    "Increases the number of combo chains by 2.",
            "Increases blast damage by 35% of base value.",
            "Increases elemental damage resistance by 35%.",
            "Increases elemental damage by 35% of base and decreases physical damage by -35% of base.",
            "Increases gear recharge rate by 50% of base and lowers gear damage by -20% of base.",
            "Increases gear damage by 50% of base and lowers gear recharge rate by -20% of base.",
            "An inscribed component that increases fire damage by 5% of base damage and effect buildup by 5% of base buildup.",
            "An inscribed component that increases ice damage by 5% of base damage and effect buildup by 5% of base buildup.",
            "Increases armor by 25% of base.",
            "An inscribed component that increases lightning damage by 5% of base damage and effect buildup by 5% of base buildup.",

    "Increases reserve ammo for all equipped guns by 5% of base capacity.",
            "Increases javelin armor by a large amount.",
            "Adds specializes storage for enhanced assault rifle ammunition to increase damage by 5% of base damage.",
            "Increases the javelin's heat capacity by 10% of the base capacity to allow the javelin to fly more effectively.",
            "Adds specialized storage for enhanced light machine gun ammunition to increase damage by 5% of base damage.",
            "Adds specialized storage for enhanced machine pistol ammunition to increase damage by 5% of base damage.",
            "Adds specialized storage for enhanced marksman rifle ammunition to increase damage by 5% of base damage.",
            "An inscribed component that increases melee weapon damage by 5% of base damage.",
            "Increases javelin shields by a large amount.",
            "Adds specialized storage for enhanced shotgun ammunition that increases damage by 5% of base damage.",
            "Adds specialized storage for enhanced sniper rifle ammunition to increase damage by 5% of base damage.",
            "Adds specialized ammo storage for heavy pistols, autocannons, and grenade launchers. Increases damage by 30%.",
            "An inscribed component that augments javelin ultimate gear and increases damage by 5% of base damage."};

    RecyclerView list;
    RecyclerView.LayoutManager layoutManager;
    List<Weapons> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons);

        list = (RecyclerView) findViewById(R.id.rc);
        list.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        setData();


        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mToolbar = (Toolbar) findViewById(R.id.custom_bar);
        mToolbar.setTitle("Components List");
        setSupportActionBar(mToolbar);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }

    private void setData(){


        for (int i=0; i<60;i++)
        {
            Weapons item = new Weapons(titles[i], desc[i],images[i],true);
            items.add(item);
            //  Weapons item1 = new Weapons("test!?", "this is child",images[1],true);
            //  items.add(item1);
        }

        RecyclerAdapter adapter = new RecyclerAdapter(items);
        list.setAdapter(adapter);
    }



    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);


    }



}
