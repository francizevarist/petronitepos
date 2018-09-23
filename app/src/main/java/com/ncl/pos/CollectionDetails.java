package com.ncl.pos;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cloudpos.DeviceException;
import com.cloudpos.POSTerminal;
import com.cloudpos.printer.Format;
import com.cloudpos.printer.PrinterDevice;
import com.ncl.fragment.Collections;
import com.ncl.fragment.CreditSales;
import com.ncl.fragment.FragmentDrawer;
import com.ncl.fragment.Provisions;

import java.util.ArrayList;
import java.util.List;

public class CollectionDetails extends AppCompatActivity {

    private static String TAG = Main.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    private TabLayout tabLayout;
    private ViewPager viewPager;


    /**
     *
     * @param savedInstanceState : printer
     */
    private PrinterDevice printerDevice;
    private Format format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        printerDevice = (PrinterDevice) POSTerminal.getInstance(getApplicationContext()).getDevice(
                "cloudpos.device.printer");

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Collections(getApplicationContext(),CollectionDetails.this), "COLLECTION");
        adapter.addFragment(new CreditSales(getApplicationContext(),CollectionDetails.this), "CREDIT SALES");
        adapter.addFragment(new Provisions(getApplicationContext(),CollectionDetails.this), "PROVISION");
        viewPager.setAdapter(adapter);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_collectiondetails, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_print:

                //close : printer
                for(int i=0; i<3; i++){
                    // TODO Auto-generated method stub
                    try {
                        printerDevice.close();
                    } catch (DeviceException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                printReceipt();
                break;
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * *******************************************************************************************
     * connect to pos printer  : date implemented 07-sep-2018  - Francis Ng'wandu
     * *******************************************************************************************
    **/

    private void printReceipt(){
        try {
            printerDevice.open();
            format = new Format();
            try {
                if (printerDevice.queryStatus() == printerDevice.STATUS_OUT_OF_PAPER) {
                } else if (printerDevice.queryStatus() == printerDevice.STATUS_PAPER_EXIST) {

                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try {

                                format.setParameter("align", "left");
                                format.setParameter("size", "extra-small");
                                printerDevice.printText(format, "extra-small，POS sign purchase order\n");
                                format.setParameter("size", "small");
                                printerDevice.printText(format, "small，POS sign purchase order\n");
                                format.setParameter("size", "medium");
                                printerDevice.printText(format, "medium，POS sign purchase order\n");
                                format.setParameter("size", "large");
                                printerDevice.printText(format, "large，POS sign purchase order\n");
                                format.setParameter("size", "extra-large");
                                printerDevice.printText(format, "extra-large，POS sign purchase order\n");

                                format = new Format();

                                printerDevice.printText(format, "<BARCODE_CODABAR >\n");
                                format.setParameter("HRI-location", "up-down");
                                printerDevice.printBarcode(format, printerDevice.BARCODE_UPC_A, "123456789012");

                                format = new Format();
                                printerDevice.printText("\n");
                                printerDevice.printText("\n");
                                format.setParameter("align", "center");
                                format.setParameter("bold", "true");
                                format.setParameter("size", "large");
                                printerDevice.printText(format, "POS sign purchase order");
                                printerDevice.printText("\n");
                                printerDevice.printText("\n");
                                format.clear();
                                format.setParameter("align", "left");
                                format.setParameter("size", "medium");
                                printerDevice.printText(format, "MERCHANT COPY:\n" +
                                        "--------------------------------");
                                printerDevice.printText(format, "MERCHANT NAME:\n" +
                                        "XXX XXXX XXXX CO.LTO\n" +
                                        "MER:10237135411994\n" +
                                        "TER:52878059\n" +
                                        "--------------------------------");
                                printerDevice.printText(format, "ISSUER:XXXXBank\n" +
                                        "CARD NO.:\n" +
                                        "6228 45** **** ***0614/S\n" +
                                        "EXP DATE:XXXX/XX\n" +
                                        "TXN TYPE:\n" +
                                        "SALE:\n" +
                                        "BATCH NO: 100687\n" +
                                        "INVOICE NO :002500\n" +
                                        "TRACE NO :009404\n" +
                                        "DATE:xxxx/xx/xx\n" +
                                        "TIME:xx:xx:xx\n" +
                                        "REFER NO :648965012342\n" +
                                        "AMOUNT: \n" +
                                        "\t$ 0.00\n" +
                                        "OPERATOR NO :001\n" +
                                        "Taxpayer code:371326198402097610\n" +
                                        "Tax certificate number:320160607000243893\n" +
                                        "Accounting organization code:13713260000\n\n" +
                                        "REFERENCE:\n" +
                                        "CARDHOLDER\n" +
                                        "SIGNATURE:\n\n" +
                                        "Please do not sign this test operation!\n");
                                printerDevice.printText(format, "--------------------------------\n" +
                                        "I CONFIRM THAT THE ABOVE TRANSACTION AGREED TO BE CREDITED TO THE CREDIT CARD ACCOUNT.\n" +
                                        "--------------------------------");
                                printerDevice.printlnText(format, "\n");
                                printerDevice.printlnText(format, "\n");
                                printerDevice.printlnText(format, "\n");
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();

                            }
                        }
                    });
                    thread.start();
                }
            } catch (DeviceException de) {
                de.printStackTrace();
            }
        } catch (DeviceException de) {
            de.printStackTrace();
        }
    }

}
