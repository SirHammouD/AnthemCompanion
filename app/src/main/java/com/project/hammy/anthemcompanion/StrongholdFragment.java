package com.project.hammy.anthemcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StrongholdFragment extends Fragment {
    private CardView tyrantMine;
    private CardView templeScar;
    private CardView heartRage;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String URL;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.stronghold_fragment, container,false);

        tyrantMine = (CardView) view.findViewById(R.id.card_view);
        tyrantMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // setURL("https://gamewith.net/anthem/article/show/8056");
                Intent intent = new Intent(getActivity(), TyrantMineActivity.class);
                startActivity(intent);

            }
        });


        templeScar = (CardView) view.findViewById(R.id.card_view1);
        templeScar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HeartRageActivity.class);
                startActivity(intent);

            }
        });

        heartRage = (CardView) view.findViewById(R.id.card_view2);
        heartRage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TempleScarActivity.class);
                startActivity(intent);

            }
        });

         return view;
    }
}
