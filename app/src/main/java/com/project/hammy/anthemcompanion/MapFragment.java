package com.project.hammy.anthemcompanion;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.github.chrisbanes.photoview.PhotoView;


public class MapFragment extends Fragment {
    private Button Btn1;

    ImageView imageview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.map_fragment, container,false);


        PhotoView photoView = (PhotoView) view.findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.map_soon);

        return view;
    }


}
