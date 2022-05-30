package com.project.hammy.anthemcompanion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    private Button Btn1;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.home_fragment, container,false);

        Btn1 = (Button) view.findViewById(R.id.btn1);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Coming Soon",Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
   // public void onViewCreated(View view,  Bundle savedInstanceState) {
       // super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
       // getActivity().setTitle("Home");
   // }





    }

