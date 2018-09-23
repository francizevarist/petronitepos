package com.ncl.pos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;
import com.ncl.fragment.FragmentDrawer;
import com.ncl.fragment.Fuelcredits;
import com.ncl.fragment.LiquidfiedPetroleumGas;
import com.ncl.fragment.Lubricants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    private static String TAG = Main.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    DrawerLayout drawerLayout;


    //Time:Report
    private Calendar calendar;
    private int year, month, day;
    String zmonth;
    String zday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer,drawerLayout , mToolbar);
        drawerFragment.setDrawerListener(this);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Lubricants(getApplicationContext(),Main.this), "LUBRICANTS");
        adapter.addFragment(new LiquidfiedPetroleumGas(getApplicationContext(),Main.this), "LPG");
        adapter.addFragment(new Fuelcredits(getApplicationContext(),Main.this), "FUEL SALES");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        switch (position){
            case 0:
                break;
            case 1:
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                showDialog(999);
                break;
            case 2:
                Intent intent2 = new Intent(getApplicationContext(),Inventory.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(getApplicationContext(),Provision.class);
                startActivity(intent3);
                break;
            case 4:
                break;
            case 5:
                Intent intent5 = new Intent(getApplicationContext(),Logs.class);
                startActivity(intent5);
                break;
            case 6:
                break;
        }

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    //date dialog
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            DatePickerDialog pickerDialog = new DatePickerDialog(this,myDateListener, year, month, day);
            long now = System.currentTimeMillis()-1000;
            pickerDialog.getDatePicker().setMaxDate(now+(1000*60*60*24*1)); //after one day from now
            return pickerDialog;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {

        if(month/10 == 0){ zmonth = "0"+month; }else { zmonth=Integer.toString(month); }
        if(day/10 == 0){ zday = "0"+day; }else { zday=Integer.toString(day); }

        String getDate = new StringBuilder().append(year).append("-").append(zmonth).append("-").append(zday).toString();
        Toast.makeText(getApplicationContext(),getDate,Toast.LENGTH_LONG).show();
    }

}
