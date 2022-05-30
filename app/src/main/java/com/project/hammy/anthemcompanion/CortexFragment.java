package com.project.hammy.anthemcompanion;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CortexFragment extends Fragment {

    WebView webView;
    ProgressBar loader;
    private AdView mAdView;
    String url = "https://www.ign.com/wikis/anthem/Freeplay_Collectible_Locations_%28Cortex_Items%29";
    private String extra;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.cortex_fragment, container,false);


         return view;
    }


}
