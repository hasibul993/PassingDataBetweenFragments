package com.journaldev.passingdatabetweenfragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity11 extends AppCompatActivity implements Communicate {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    private static final String BLUE_TAG = "blue";
    private static final String GREEN_TAG = "green";

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        FragmentManager fragmentManager = getSupportFragmentManager();

        //fragmentOne = (FragmentOne) fragmentManager.findFragmentByTag(BLUE_TAG);
        if (fragmentOne == null) {
            fragmentOne = new FragmentOne();
            fragmentManager.beginTransaction().add(R.id.blue_fragment_container, fragmentOne, BLUE_TAG).commit();
        }

        //fragmentTwo = (FragmentTwo) fragmentManager.findFragmentByTag(GREEN_TAG);
        if (fragmentTwo == null) {
            fragmentTwo = new FragmentTwo();
            fragmentManager.beginTransaction().add(R.id.green_fragment_container, fragmentTwo, GREEN_TAG).commit();
        }

    }

    @Override
    public void passData(String message) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        FragmentTwo f = (FragmentTwo) getSupportFragmentManager().findFragmentByTag(tag);
        fragmentTwo.displayReceivedData(message);
    }
}