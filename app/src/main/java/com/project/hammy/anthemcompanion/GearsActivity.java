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


public class GearsActivity extends AppCompatActivity  {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    NavigationView navigationView;
    private AdView mAdView;


    private int[] images = {R.drawable.weapon1};
    private String[] titles = {"weapon", "sigil"};
    private String[] desc = {"1","2"};

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
        mToolbar.setTitle("Gears List");
        setSupportActionBar(mToolbar);




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }

    private void setData(){


        for (int i=0; i<2;i++)
        {
            //Weapons item = new Weapons(titles[i], desc[i],images[i],true);
           // items.add(item);
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
