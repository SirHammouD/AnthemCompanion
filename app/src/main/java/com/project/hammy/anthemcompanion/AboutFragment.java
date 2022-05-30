package com.project.hammy.anthemcompanion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class AboutFragment extends Fragment {

    private Button Btn1;
    private Button Btn2;
    private Button Btn3;
    private Button Btn4;

    Uri webpage = Uri.parse("https://twitter.com/RealPotatoSack");
    Uri webpage2 = Uri.parse("https://facebook.com/PotatoSackOfficial");

    Uri webpage3 = Uri.parse("https://reddit.com/user/PotatoSackOfficial");
    Uri webpage4 = Uri.parse("https://discord.gg/vFqTUW");




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.about_fragment, container,false);


        Btn1 = (Button) view.findViewById(R.id.Twitter);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);

            }
        });

        Btn2 = (Button) view.findViewById(R.id.Facebook);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage2);
                startActivity(webIntent);

            }
        });

        Btn3 = (Button) view.findViewById(R.id.Reddit);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage3);
                startActivity(webIntent);

            }
        });

        Btn4 = (Button) view.findViewById(R.id.Discord);
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage4);
                //startActivity(webIntent);
                Toast.makeText(getActivity(),"Coming Soon",Toast.LENGTH_SHORT).show();

            }
        });






        return view;
    }

}
