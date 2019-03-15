package com.example.user.tabview;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewpager;
    TabLayout tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager=(ViewPager)findViewById(R.id.pager);
       tb=(TabLayout)findViewById(R.id.tab);
        viewpager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        tb.setupWithViewPager(viewpager);
    }
    class TabAdapter extends FragmentPagerAdapter {

        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Chats();
                case 1:
                    return new Calls();
                case 2:
                    return new Status();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Chats";
                case 1:
                    return "Calls";
                case 2:
                    return "Status";
            }
            return super.getPageTitle(position);
        }
    }
}
