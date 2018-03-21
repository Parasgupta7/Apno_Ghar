package com.anmol.rajhack;


        import android.os.Bundle;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;

        import java.util.Timer;
        import java.util.TimerTask;

public class Sliderdemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliderdemo);

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
        }, 500, 1000);
    }
}