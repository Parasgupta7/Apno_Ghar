package com.anmol.rajhack;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;


public class homeFragment extends Fragment {
    Timer swipeTimer;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        Button b = getView().findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new com.anmol.rajhack.register();
                FragmentManager fm3 = getFragmentManager();
                FragmentTransaction ft3 = fm3.beginTransaction();

                ft3.replace(R.id.fm,fragment);
                ft3.commit();

            }
        });

       final ViewPager mViewPager1 = (ViewPager) getView().findViewById(R.id.viewPageAndroid1);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(getActivity());
        mViewPager1.setAdapter(adapterView);


         swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            int currentPage=0;
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage == 3) {
                            currentPage = 0;
                        }
                        mViewPager1.setCurrentItem(currentPage++, true);
                    }
                });
            }
        }, 500, 1000);




    }

    @Override
    public void onPause() {
        super.onPause();
        swipeTimer.cancel();

    }

    @Override
    public void onStop() {
        super.onStop();
        swipeTimer.cancel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
