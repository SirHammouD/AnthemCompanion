package com.project.hammy.anthemcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CraftingFragment extends Fragment {
    private CardView weapons;
    private CardView sigils;
    private CardView gears;
    private CardView components;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.crafting_fragment, container,false);

        weapons = (CardView) view.findViewById(R.id.card_view);
        weapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WeaponsActivity.class);
                startActivity(intent);

            }
        });


        sigils = (CardView) view.findViewById(R.id.card_view1);
        sigils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SigilsActivity.class);
                startActivity(intent);

            }
        });

      /*  gears = (CardView) view.findViewById(R.id.card_view2);
        gears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GearsActivity.class);
                startActivity(intent);

            }
        });*/

        components = (CardView) view.findViewById(R.id.card_view3);
        components.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ComponentsActivity.class);
                startActivity(intent);

            }
        });

         return view;
    }
}
