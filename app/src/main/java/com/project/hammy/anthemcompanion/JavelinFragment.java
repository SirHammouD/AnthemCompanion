package com.project.hammy.anthemcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class JavelinFragment extends Fragment {
    private Button Btn1;
    private Button Btn2;
    private Button Btn3;
    private Button Btn4;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.javelin_fragment, container, false);

        Btn1 = (Button) view.findViewById(R.id.button1);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RangerActivity.class);
                startActivity(intent);

            }
        });

        Btn2 = (Button) view.findViewById(R.id.button2);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StormActivity.class);
                startActivity(intent);

            }
        });

        Btn3 = (Button) view.findViewById(R.id.button3);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InterceptorActivity.class);
                startActivity(intent);

            }
        });

        Btn4 = (Button) view.findViewById(R.id.button4);
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ColossusActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}
