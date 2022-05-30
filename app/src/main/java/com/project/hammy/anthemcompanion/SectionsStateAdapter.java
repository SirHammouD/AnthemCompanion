package com.project.hammy.anthemcompanion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsStateAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mfragmentList = new ArrayList<>();
    private final List<String> mfragmentListTitleList = new ArrayList<>();


    public SectionsStateAdapter(FragmentManager fm) {
        super(fm);
    }



    public void addFragment(Fragment fragment, String title){

        mfragmentList.add(fragment);
        mfragmentListTitleList.add(title);

    }



    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }


    @Override
    public int getCount() {
        return mfragmentList.size();
    }
}
