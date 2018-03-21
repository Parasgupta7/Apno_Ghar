package com.anmol.rajhack;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class register1 extends Fragment {

    Button b1;
    EditText ed1,ed2;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_register1, container, false);
        //return inflater.inflate(R.layout.fragment_products, container, false);
        return rootView;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Enter details");

        b1 = getView().findViewById(R.id.button);
        ed1 = getView().findViewById(R.id.editText1);
        ed2 = getView().findViewById(R.id.editText2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ed1.setVisibility(View.INVISIBLE);
                ed2.setVisibility(View.INVISIBLE);

                b1.setVisibility(View.INVISIBLE);


                Fragment newFragment = new register2();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.ad, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        });

    }

}
