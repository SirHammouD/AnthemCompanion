package com.project.hammy.anthemcompanion;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    NavigationView navigationView;
    private long backPressedTime;
    private Toast backToast;
    private AdView mAdView;
    private SectionsStateAdapter mSectionStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionStatePagerAdapter = new SectionsStateAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        MobileAds.initialize(this, "ca-app-pub-1272284068166713~7761017280");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mToolbar = (Toolbar) findViewById(R.id.title_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.nav_bar);
        navigationView.setNavigationItemSelectedListener(this);

        //mToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        //to hide keyboard when app opens
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //to fix the view focus when keyboard is on
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);






    }





    private void setupViewPager(ViewPager viewPager){
        SectionsStateAdapter adapter = new SectionsStateAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new NewsFragment(), "News");
        adapter.addFragment(new MapFragment(), "Map");
        adapter.addFragment(new JavelinFragment(), "Javelin");
        adapter.addFragment(new CraftingFragment(), "Crafting");
        adapter.addFragment(new StrongholdFragment(), "Strongholds");
        //adapter.addFragment(new CreaturesFragment(), "Creatures");
       // adapter.addFragment(new CortexFragment(), "Cortex");
        adapter.addFragment(new WallpapersFragment(), "Wallpapers");
        adapter.addFragment(new AboutFragment(), "About Us");
        viewPager.setAdapter(adapter);


    }

    public void setViewPager(int fragmentNumber){

        mViewPager.setCurrentItem(fragmentNumber);
    }



    public boolean onOptionsItemSelected(MenuItem item){

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);



    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
        {
            mDrawerLayout.closeDrawer(GravityCompat.START);

        }
       else if(!mDrawerLayout.isDrawerOpen(GravityCompat.START))

       {

            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                backToast.cancel();
                super.onBackPressed();
                return;
            }
            else {
                backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
                backToast.show();
            }

            backPressedTime = System.currentTimeMillis();

        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        switch (id){

            case R.id.nav_home:
                Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                setViewPager(0);
                break;

            case R.id.nav_news:
                Toast.makeText(getApplicationContext(),"News",Toast.LENGTH_SHORT).show();
                setViewPager(1);
                break;

            case R.id.nav_map:
                Toast.makeText(getApplicationContext(),"Map",Toast.LENGTH_SHORT).show();
                setViewPager(2);
                break;

            case R.id.nav_javelins:
                Toast.makeText(getApplicationContext(),"Javelins",Toast.LENGTH_SHORT).show();
                setViewPager(3);
                break;

            case R.id.nav_crafting:
                Toast.makeText(getApplicationContext(),"Crafting",Toast.LENGTH_SHORT).show();
                setViewPager(4);
                break;

            case R.id.nav_strongholds:
                Toast.makeText(getApplicationContext(),"Strongholds",Toast.LENGTH_SHORT).show();
                setViewPager(5);
                break;

           /* case R.id.nav_creatures:
                Toast.makeText(getApplicationContext(),"Creatures",Toast.LENGTH_SHORT).show();
                setViewPager(6);
                break;

            case R.id.nav_cortex:
                Toast.makeText(getApplicationContext(),"Cortex",Toast.LENGTH_SHORT).show();
                setViewPager(7);
                break; */

            case R.id.nav_wallpaper:
                Toast.makeText(getApplicationContext(),"Wallpapers",Toast.LENGTH_SHORT).show();
                setViewPager(6);
                break;

            case R.id.nav_about_us:
                Toast.makeText(getApplicationContext(),"About Us",Toast.LENGTH_SHORT).show();
                setViewPager(7);
                break;


        }
        mDrawerLayout.closeDrawer((GravityCompat.START));
        return true;
    }


}


