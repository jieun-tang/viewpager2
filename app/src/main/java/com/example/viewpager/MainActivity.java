package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager2 viewPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this,NUM_PAGES);
        viewPager.setAdapter(pagerAdapter);

        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }
    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        public int mCount;

        public ScreenSlidePagerAdapter(FragmentActivity fa, int count) {
            super(fa);
            mCount = count;
        }

        @Override
        public Fragment createFragment(int position) {
            int index = getRealPosition(position);

            if(index==0) return new ScreenSlidePageFragment();
            else if(index==1) return new ScreenSlidePageFragment2();
            else return new ScreenSlidePageFragment3();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }

        public int getRealPosition(int position) { return position % mCount; }
    }

}
