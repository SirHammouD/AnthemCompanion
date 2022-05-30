package com.project.hammy.anthemcompanion;

import android.media.Image;
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
import com.google.android.gms.common.util.ArrayUtils;


import java.util.ArrayList;
import java.util.List;


public class WeaponsActivity extends AppCompatActivity  {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    NavigationView navigationView;
    private AdView mAdView;


    private int[] images = {R.drawable.weapon1,R.drawable.weapon2,R.drawable.weapon3,R.drawable.weapon4,
            R.drawable.weapon5,R.drawable.weapon6,R.drawable.weapon7,R.drawable.weapon8,R.drawable.weapon9,R.drawable.weapon10,R.drawable.weapon11
            ,R.drawable.weapon12,R.drawable.weapon13,R.drawable.weapon14,R.drawable.weapon15,R.drawable.weapon16,R.drawable.weapon17,R.drawable.weapon18,
            R.drawable.weapon19,R.drawable.weapon20,R.drawable.weapon21,R.drawable.weapon22,
            R.drawable.weapon23,R.drawable.weapon24,R.drawable.weapon25,R.drawable.weapon26,R.drawable.weapon27,R.drawable.weapon28,R.drawable.weapon29
            ,R.drawable.weapon30,R.drawable.weapon31,R.drawable.weapon32,R.drawable.weapon33,R.drawable.weapon34,R.drawable.weapon35
            ,R.drawable.weapon36,R.drawable.weapon37,R.drawable.weapon38,R.drawable.weapon39};


    private String[] titles = {"Defender", "Elemental Rage","Warden","Hammerhead","Ralner's Blaze",
    "Scout","Guardian","Death From Above","Anvil","Thunderbolt Of Yvenia","Deadeye","Whirlwind",
    "Devastator","Wyvern Blitz","Truth of Tarsis","Barrage","Resolution","Blastback","Glorious Result",
    "Avenging Herald","Fulcrum","Hailstorm","Trajector","Relentless","Artinia's Gambit","Havoc",
    "Sledgehammer","Cycle Of Pain","Scattershot","Vengeance","Constrictor","Papa Pump","Rolling Carnage",
    "Cloudburst","Mauler","Torrent","Aftershock","Bombardier","Lurker"};


    private String[] desc = {"Standard-issue Freelancer assault rifle. Effective at mid-range combat situations due to its great rate of fire, and high ammo capacity.",
    "The Elemental Rage is an upgraded Defender with Veteran's Furor which increases all elemental damage by 5% for 10 seconds when you hit Elite enemies. Effect stacks up to 20.",
    "Burst-fire assault rifle great for engaging enemies at long distance. Due to its burst-fire qualities, it has a relatively low fire rate, but provides better accuracy.",
    "Greatest striking power in relation to other Assault Rifles. Great for finishing off enemies, but suffers from low fire rate, and small ammo capacity.",
    "Ralner's Blaze is an upgraded Hammerhead that ignites the target while on a hit-streak (5)",
    "The Scout is a powerful Marksman Rifle when used at a distance. It has a decent fire rate, and ammo capacity to weaken enemies before finishing them off.", "Fires 3 round bursts, and has a bit of a learning curve to achieve its maximum potential. The Guardian is a solid rifle for mid to long range combat.",
    "Death From Above is an upgraded Guardian with Raptor's Sense that increases weak point damage by 65% while hovering.",
    "A hard-hitting Marksman Rifle with a high rate of fire. Despite this, it has noticeable recoil, and a low ammo capacity.",
    "The Thunderbolt Of Yvenia is an upgraded Scout that has a chance to deal large electric damage when fired at enemies. Best used to decimate enemy shields.",
    "Despite having a high strike force at a distance, the Deadeye is not a rapid fire weapon. Take time to aim at your target to maximize this weapon's abilities.",
    "Despite lacking firepower compared to other weapons in its class, the Whirlwind boasts a fire rate close to resembling Assault Rifles. Can be used to unload bullets on enemies at range.",
    "After charging, the Rifle can deliver tremendous knockdown force at a distance. To add to this, its ammunition can also explode on contact, making it a deadly weapon in long range.",
    "The Wyvern Blitz is an upgraded Deadeye that increases weak point damage by 40% when hovering.",
    "The Truth of Tarsis is an upgraded Devastator that can set off a chain combo when hitting weak points of enemies under a status effect.",
    "The Barrage is a heavy pistol that has a tremendous rate of fire, letting you shoot first, then loot later.",
    "The Resolution has a high rate of fire, paired with high damage. A good weapon to have due to its traits.",
    "The Blastback has a high damage value, making it ideal for close-quarters combat.",
    "Upgraded Resolution with Gunslinger's Fury. Hitting 2 enemy weak points quickly increases all weapon damage by 150% for 5 seconds.",
    "Upgraded Blastback with Raptor's Deadeye. Hovering increases weapon damage by 200%.",
    "The Fulcrum is the most balanced weapon in the Machine Pistol category, with its decent damage, and high fire rate.",
    "The Hailstorm is the fastest-firing weapon in its class. Due to its low accuracy, it is best used against enemies in very short range.",
    "The Trajector is a weapon that has longer range than other Machine Pistols, but a lower rate of fire. It can be great for enemies at a longer range.",
    "A well balanced Light Machine Gun, the Relentless is a superb weapon to use in several combat situations.",
    "The Artinia's Gambit is an upgraded Relentless that detonates a Combo explosion in the immediate area when reloading.",
    "Despite boasting the fastest fire rate in the Light Machine Gun class, the Havoc suffers in the damage and accuracy department. Best used for taking out waves of weak enemies.",
    "The heaviest hitter in its class, the Sledgehammer suffers from the lowest ammo capacity, and fire rate. Best used when fighting against heavy targets.",
    "Cycle of Pain is an upgraded Sledge Hammer with Marksman's Swiftness: Weak point hits increase weapon rate of fire by 10% for 10 seconds. Stacks to 10.",
    "Standard issue Freelancer Shotgun. Well balanced in power and ammo capacity, making it ideal to use in tight spaces.",
    "Fires two successive shells at a time, and excels in fire rate, the Vengeance is a deadly weapon in close range.",
    "Shotgun which becomes more accurate, the more it fires. Can be used to go toe-to-toe with strong targets.",
    "Upgraded Scattershot with special traits. Reloading will increase damage by 100% for 15 seconds. The buff can be stacked twice, making you deadlier with every manual reload after two shots.",
    "Upgraded Vengeance with Scout's Advantage. Dashing will increase the weapon damage by 50% for 20 seconds, which stacks up to 3.",
    "Heavy weapon with an impressive rate of fire. Best for cutting down waves of enemies due to how fast it can unload its magazine.",
    "Autocannon which boasts the best firepower in its class, but suffers from a low rate of fire. Despite its low fire rate, it has no spin up time, meaning you can quickly fire at enemies to bring them down.",
    "Autocannon which gets more accurate the longer the trigger is held. Despite a long spin up time, the Torrent also boasts the best fire rate in its class, making it ideal to use against tanky targets.",
    "When shot, the Aftershock's ammo sticks to targets or surfaces. These bullets then explode after a short period of time.",
    "The Bombardier's grenades bounce around the area as they are fired. The range is increased due to bouncing grenades, making it a joy to use against crowds.",
    "The Lurker's grenades do not detonate until you trigger them, making them traps that you can lay for unsuspecting enemies in battle."};

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
        setSupportActionBar(mToolbar);




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }



    private void setData(){


      for (int i=0; i<39;i++)
      {
         // Weapons item = new Weapons(titles[i], desc[i], images[i],true);
           // items.add(item);

          Weapons item = new Weapons(titles[i], desc[i], images[i],true);
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
