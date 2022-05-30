package com.project.hammy.anthemcompanion;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;


public class SigilsActivity extends AppCompatActivity  {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    NavigationView navigationView;
    private AdView mAdView;

    private int[] images = {R.drawable.sigil1,R.drawable.sigil2,R.drawable.sigil3,R.drawable.sigil4,R.drawable.sigil5,R.drawable.sigil6,R.drawable.sigil7,
            R.drawable.sigil8,R.drawable.sigil9,R.drawable.sigil10,R.drawable.sigil11,R.drawable.sigil12,R.drawable.sigil13,
            R.drawable.sigil14,R.drawable.sigil15,R.drawable.sigil16,R.drawable.sigil17,R.drawable.sigil18,R.drawable.sigil19,R.drawable.sigil20};


    private String[] titles = {"Acid Sigil", "Fire Sigil","Ice Sigil","Lightning Sigil","Armor Sigil",
    "Combo Sigil","Gear Sigil","Heat Sigil","Melee Sigil","Shield Sigil","Ultimate Sigil","Assault Rifle Sigil",
    "Autocannon Sigil","Grenade Launcher Sigil","Heavy Pistol Sigil","Light Machine Gun Sigil","Machine Pistol Sigil",
    "Marksman Rifle Sigil","Shotgun Sigil","Sniper Rifle Sigil"};


    private String[] desc = {
            "1 Uncommon Ember:\n\n" +
            "Increases acid damage by 10%, acid stacks applied to enemies by 3%, and acid resistance by 10%.\n\n" +
            "2 Rare Embers:\n\n" +
            "Increases acid damage by 20%, acid stacks applied to enemies by 6%, and acid resistance by 20%.\n\n" +
            "5 Epic Embers:\n\n"+
            "Increases acid damage by 30%, acid stacks applied to enemies by 10%, and acid resistance by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases fire damage by 10%, fire stacks applied to enemies by 3%, and fire resistance by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases fire damage by 20%, fire stacks applied to enemies by 6%, and fire resistance by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases fire damage by 30%, fire stacks applied to enemies by 10%, and fire resistance by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases ice damage by 10%, ice stacks applied to enemies by 3%, and ice resistance by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases ice damage by 20%, ice stacks applied to enemies by 6%, and ice resistance by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases ice damage by 30%, ice stacks applied to enemies by 10%, and ice resistance by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases lightning damage by 10%, lightning stacks applied to enemies by 3%, and lightning resistance by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases lightning damage by 20%, lightning stacks applied to enemies by 6%, and lightning resistance by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases lightning damage by 30%, lightning stacks applied to enemies by 10%, and lightning resistance by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Improves javelin armor by 10% and physical resistance by 3%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Improves javelin armor by 20% and physical resistance by 6%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Improves javelin armor by 30% and physical resistance by 10%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases the damage of combo reactions by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases the damage of combo reactions by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases the damage of combo reactions by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases the recharge speed of equipped gear by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases the recharge speed of equipped gear by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases the recharge speed of equipped gear by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases heat capacity by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases heat capacity by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases heat capacity by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases the damage of melee abilities by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases the damage of melee abilities by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases the damage of melee abilities by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases maximum shield strength & regen by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases maximum shield strength & regen by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases maximum shield strength & regen by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases the damage of ultimate abilities by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases the damage of ultimate abilities by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases the damage of ultimate abilities by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases assault rifle damage and reserve ammo by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases assault rifle damage and reserve ammo by by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases assault rifle damage and reserve ammo by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases autocannon damage and reserve ammo by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases autocannon damage and reserve ammo by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases autocannon damage and reserve ammo by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases grenade launcher damage and reserve ammo by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases grenade launcher damage and reserve ammo by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases grenade launcher damage and reserve ammo by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases heavy pistol damage and reserve ammo by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases heavy pistol damage and reserve ammo by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases heavy pistol damage and reserve ammo by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases light machine gun damage and reserve ammo by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases light machine gun damage and reserve ammo by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases light machine gun damage and reserve ammo by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases machine pistol damage and reserve ammo by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases machine pistol damage and reserve ammo by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases machine pistol damage and reserve ammo by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases marksman rifle damage and reserve ammo by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "IIncreases marksman rifle damage and reserve ammo by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases marksman rifle damage and reserve ammo by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases shotgun damage and reserve ammo by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases shotgun damage and reserve ammo by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases shotgun damage and reserve ammo by 30%.",

            "1 Uncommon Ember:\n\n" +
                    "Increases sniper rifle damage and reserve ammo by 10%.\n\n" +
                    "2 Rare Embers:\n\n" +
                    "Increases sniper rifle damage and reserve ammo by 20%.\n\n" +
                    "5 Epic Embers:\n\n"+
                    "Increases sniper rifle damage and reserve ammo by 30%.",


    };

    RecyclerView list;
    RecyclerView.LayoutManager layoutManager;
    List<Weapons> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons);

        list= (RecyclerView) findViewById(R.id.rc);
        list.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        setData();


        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mToolbar = (Toolbar) findViewById(R.id.custom_bar);
        mToolbar.setTitle("Sigils List");
        setSupportActionBar(mToolbar);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }

    private void setData(){


        for (int i=0; i<20;i++)
        {
            Weapons item = new Weapons(titles[i], desc[i],images[i],true);
            items.add(item);

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
