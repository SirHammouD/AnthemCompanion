package com.project.hammy.anthemcompanion;


import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import dmax.dialog.SpotsDialog;

import com.squareup.picasso.Downloader;

import com.squareup.picasso.Picasso;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;



public class WallpapersFragment extends Fragment {

    private static final int PERMISSION_REQUEST_CODE = 1000;


    ImageButton imageButton;
    ImageView imageView;
    String URL = "https://images8.alphacoders.com/855/855793.jpg";

    ImageButton imageButton1;
    ImageView imageView1;
    String URL1 = "https://images8.alphacoders.com/926/926641.jpg";

    ImageButton imageButton2;
    ImageView imageView2;
    String URL2 = "https://images7.alphacoders.com/926/926640.jpg";

    ImageButton imageButton3;
    ImageView imageView3;
    String URL3 = "https://images6.alphacoders.com/848/848266.jpg";

    ImageButton imageButton4;
    ImageView imageView4;
    String URL4 = "https://images3.alphacoders.com/843/843437.jpg";

    ImageButton imageButton5;
    ImageView imageView5;
    String URL5 = "https://images6.alphacoders.com/926/926450.png";

    ProgressDialog mProgressDialog;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)

                    Toast.makeText(getActivity(), "Permission Granted", Toast.LENGTH_SHORT).show();
                else

                    Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.wallpapers_fragment, container,false);



        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, PERMISSION_REQUEST_CODE);
        }




        imageView = (ImageView) view.findViewById(R.id.imageView);
        Picasso.with(getContext()).load(URL).into(imageView);
        imageButton = (ImageButton) view.findViewById(R.id.imageBtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getActivity(), "Please grant permission", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, PERMISSION_REQUEST_CODE);
                    return;
                }
                else {

                    AlertDialog dialog = new SpotsDialog(getActivity());
                    dialog.getContext().setTheme(R.style.Dialog);
                    dialog.show();
                    dialog.setMessage("Downloading...");

                    String fileName = UUID.randomUUID().toString()+".jpg";
                    Picasso.with(getContext()).load(URL).into(new SaveImageHelper(getContext(), dialog, getActivity().getApplicationContext().getContentResolver(), fileName, "Image description" ));

                }


               // new DownloadImage().execute(URL);
                
            }
        });


        imageView1 = (ImageView) view.findViewById(R.id.imageView1);
        Picasso.with(getContext()).load(URL1).into(imageView1);
        imageButton1 = (ImageButton) view.findViewById(R.id.imageBtn1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getActivity(), "Please grant permission", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, PERMISSION_REQUEST_CODE);
                    return;
                }
                else {

                    AlertDialog dialog = new SpotsDialog(getActivity());
                    dialog.getContext().setTheme(R.style.Dialog);
                    dialog.show();
                    dialog.setMessage("Downloading...");

                    String fileName = UUID.randomUUID().toString()+".jpg";
                    Picasso.with(getContext()).load(URL1).into(new SaveImageHelper(getContext(), dialog, getActivity().getApplicationContext().getContentResolver(), fileName, "Image description" ));

                }

                // new DownloadImage().execute(URL);

            }
        });


        imageView2 = (ImageView) view.findViewById(R.id.imageView2);
        Picasso.with(getContext()).load(URL2).into(imageView2);
        imageButton2 = (ImageButton) view.findViewById(R.id.imageBtn2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getActivity(), "Please grant permission", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, PERMISSION_REQUEST_CODE);
                    return;
                }
                else {

                    AlertDialog dialog = new SpotsDialog(getActivity());
                    dialog.getContext().setTheme(R.style.Dialog);
                    dialog.show();
                    dialog.setMessage("Downloading...");

                    String fileName = UUID.randomUUID().toString()+".jpg";
                    Picasso.with(getContext()).load(URL2).into(new SaveImageHelper(getContext(), dialog, getActivity().getApplicationContext().getContentResolver(), fileName, "Image description" ));

                }

                // new DownloadImage().execute(URL);

            }
        });



        imageView3 = (ImageView) view.findViewById(R.id.imageView3);
        Picasso.with(getContext()).load(URL3).into(imageView3);
        imageButton3 = (ImageButton) view.findViewById(R.id.imageBtn3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getActivity(), "Please grant permission", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, PERMISSION_REQUEST_CODE);
                    return;
                }
                else {

                    AlertDialog dialog = new SpotsDialog(getActivity());
                    dialog.getContext().setTheme(R.style.Dialog);
                    dialog.show();
                    dialog.setMessage("Downloading...");

                    String fileName = UUID.randomUUID().toString()+".jpg";
                    Picasso.with(getContext()).load(URL3).into(new SaveImageHelper(getContext(), dialog, getActivity().getApplicationContext().getContentResolver(), fileName, "Image description" ));

                }

                // new DownloadImage().execute(URL);

            }
        });



        imageView4 = (ImageView) view.findViewById(R.id.imageView4);
        Picasso.with(getContext()).load(URL4).into(imageView4);
        imageButton4 = (ImageButton) view.findViewById(R.id.imageBtn4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getActivity(), "Please grant permission", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, PERMISSION_REQUEST_CODE);
                    return;
                }
                else {

                    AlertDialog dialog = new SpotsDialog(getActivity());
                    dialog.getContext().setTheme(R.style.Dialog);
                    dialog.show();
                    dialog.setMessage("Downloading...");

                    String fileName = UUID.randomUUID().toString()+".jpg";
                    Picasso.with(getContext()).load(URL4).into(new SaveImageHelper(getContext(), dialog, getActivity().getApplicationContext().getContentResolver(), fileName, "Image description" ));

                }

                // new DownloadImage().execute(URL);

            }
        });



        imageView5 = (ImageView) view.findViewById(R.id.imageView5);
        Picasso.with(getContext()).load(URL5).into(imageView5);
        imageButton5 = (ImageButton) view.findViewById(R.id.imageBtn5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getActivity(), "Please grant permission", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, PERMISSION_REQUEST_CODE);
                    return;
                }
                else {

                    AlertDialog dialog = new SpotsDialog(getActivity());
                    dialog.getContext().setTheme(R.style.Dialog);
                    dialog.show();
                    dialog.setMessage("Downloading...");

                    String fileName = UUID.randomUUID().toString()+".jpg";
                    Picasso.with(getContext()).load(URL5).into(new SaveImageHelper(getContext(), dialog, getActivity().getApplicationContext().getContentResolver(), fileName, "Image description" ));

                }

                // new DownloadImage().execute(URL);

            }
        });

       /* RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecycleViewAdapter());*/


         return view;
    }

   /* private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(getActivity());
            // Set progressdialog title
            mProgressDialog.setTitle("Downloading Wallpaper");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Close progressdialog
            mProgressDialog.dismiss();
            Toast.makeText(getActivity(),"Wallpaper Downloaded",Toast.LENGTH_SHORT).show();
        }

    }*/


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


   /* private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private ImageView mImageView;
        private ImageButton mImageButton;

        public RecyclerViewHolder(View itemView){
            super(itemView);
        }

        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.card_view, container, false));

            mCardView = itemView.findViewById(R.id.card_view);
            mImageButton = itemView.findViewById(R.id.imageBtn);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }

    private class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());


            return new RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }*/





}
