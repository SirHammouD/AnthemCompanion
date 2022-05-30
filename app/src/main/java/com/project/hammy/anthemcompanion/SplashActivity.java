package com.project.hammy.anthemcompanion;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent splashIndent = new Intent(SplashActivity.this,MainActivity.class);
                                          startActivity(splashIndent);
                                          overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                                          finish();

                                      }
                                  },
                SPLASH_TIME_OUT
        );
    }

}
