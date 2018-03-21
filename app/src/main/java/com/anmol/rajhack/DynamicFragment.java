package com.anmol.rajhack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DynamicFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        Intent in = getIntent();
        int extra1=in.getIntExtra("id",0);
        String  extra2=in.getStringExtra("title");

        final ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(this);
        mViewPager.setAdapter(adapterView);
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            int currentPage=0;
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage == 3) {
                            currentPage = 0;
                        }
                        mViewPager.setCurrentItem(currentPage++, true);
                    }
                });
            }
        }, 1000, 1500);

        RatingBar rt=(RatingBar)findViewById(R.id.ratingBar);
        rt.setRating(Float.parseFloat("2.0"));
        TextView tv2=(TextView) findViewById(R.id.textView2);
        tv2.setText(extra2);

    }

}
