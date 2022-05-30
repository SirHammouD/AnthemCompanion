package com.project.hammy.anthemcompanion;


import android.media.Image;


public class Weapons {


    private String Name,Text;
    private boolean isExpandable;
    private int imageUrl;



    public Weapons(String name, String text, int imageUrl, boolean isExpandable) {
        this.Name = name;
        this.Text = text;
        this.imageUrl = imageUrl;
        this.isExpandable = isExpandable;
    }


    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }



    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
