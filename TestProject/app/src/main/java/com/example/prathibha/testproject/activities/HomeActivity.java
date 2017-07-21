package com.example.prathibha.testproject.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.prathibha.testproject.R;
import com.example.prathibha.testproject.adapters.CustomPagerAdapter;
import com.example.prathibha.testproject.adapters.TabViewPagerAdapter;
import com.example.prathibha.testproject.fragments.ImagesFragment;
import com.example.prathibha.testproject.fragments.MileStonesFragment;
import com.example.prathibha.testproject.fragments.VideosFragment;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager imageViewPager, tabViewPager;
    private TabLayout tabLayout;
    private int dotsCount;
    private ImageView[] dots;
    private String tabTitles[] = new String[] { "VIDEOS", "IMAGES", "MILESTONE" };
    private int[] imageResId = { R.drawable.select_video, R.drawable.image, R.drawable.milestone};
    private LinearLayout pagerIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        imageViewPager = (ViewPager) findViewById(R.id.image_view_pager);
        tabViewPager = (ViewPager) findViewById(R.id.tab_view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        pagerIndicator = (LinearLayout) findViewById(R.id.viewPagerIndicator);

        mCustomPagerAdapter = new CustomPagerAdapter(this);
        imageViewPager.setAdapter(mCustomPagerAdapter);
        setupViewPager(tabViewPager);

        tabLayout.setupWithViewPager(tabViewPager);
        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(getTabView(i));
        }

        dotsCount = mCustomPagerAdapter.getCount();
        dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.un_selected_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(5, 0, 5, 0);

            pagerIndicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selected_dot));

        imageViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(getResources().getDrawable(R.drawable.un_selected_dot));
                }

                dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selected_dot));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(tabViewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        int tabTextColor = ContextCompat.getColor(HomeActivity.this, R.color.toolBarColor);
                        int position =  tab.getPosition();
                        if(position == 0)
                        ((ImageView)tab.getCustomView().findViewById(R.id.image_view)).setImageResource(R.drawable.select_video);
                        if(position == 1)
                            ((ImageView)tab.getCustomView().findViewById(R.id.image_view)).setImageResource(R.drawable.select_image);
                        if(position == 2)
                            ((ImageView)tab.getCustomView().findViewById(R.id.image_view)).setImageResource(R.drawable.select_milestone);

                        ((TextView)tab.getCustomView().findViewById(R.id.tab)).setTextColor(tabTextColor);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        int tabTextColor = ContextCompat.getColor(HomeActivity.this, android.R.color.darker_gray);
                        int position =  tab.getPosition();
                        if(position == 0)
                            ((ImageView)tab.getCustomView().findViewById(R.id.image_view)).setImageResource(R.drawable.video);
                        if(position == 1)
                            ((ImageView)tab.getCustomView().findViewById(R.id.image_view)).setImageResource(R.drawable.image);
                        if(position == 2)
                            ((ImageView)tab.getCustomView().findViewById(R.id.image_view)).setImageResource(R.drawable.milestone);

                        ((TextView)tab.getCustomView().findViewById(R.id.tab)).setTextColor(tabTextColor);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );

    }

    private void setupViewPager(ViewPager viewPager) {
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VideosFragment(), "VIDEOS");
        adapter.addFragment(new ImagesFragment(), "IMAGES");
        adapter.addFragment(new VideosFragment(), "MILESTONE");
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(HomeActivity.this).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.tab);
        tv.setText(tabTitles[position]);
        if(position == 0){
            tv.setTextColor(getResources().getColor(R.color.toolBarColor));
        }else{
            tv.setTextColor(getResources().getColor(android.R.color.darker_gray));
        }
        ImageView img = (ImageView) v.findViewById(R.id.image_view);
        img.setImageResource(imageResId[position]);
        return v;
    }

}
