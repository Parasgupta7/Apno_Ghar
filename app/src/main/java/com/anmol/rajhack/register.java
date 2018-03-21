package com.anmol.rajhack;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class register extends Fragment {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapter adapter;
    private List<MyData> data_list;
    RequestQueue requestQueue;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("products");

        recyclerView = view.findViewById(R.id.recycler_view);
        data_list = new ArrayList<>();
        load_data_from_server(0);

        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new CustomAdapter(getActivity(), data_list);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (gridLayoutManager.findLastCompletelyVisibleItemPosition() == data_list.size() - 1) {
                    load_data_from_server(data_list.get(data_list.size() - 1).getId());
                }

            }
        });
    }

    private void load_data_from_server(int id) {
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, "https://rajhack-92913.firebaseio.com/Data.json", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {


                            for (int i = 1; i < 10; i++) {
                                JSONObject ja = response.getJSONObject("Data" + i);

                                String im = ja.getString("Image");
                                String t = ja.getString("Title");
                                String id = ja.getString("id");

                                MyData data = new MyData(im, t, Integer.parseInt(id.trim()));
                                data_list.add(data);
                                adapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                            Toast.makeText(getActivity(),
                                    ("timeout"),
                                    Toast.LENGTH_LONG).show();
                            error.printStackTrace();
                            Log.e("Volley", "Error");
                        }
                    }
                }
        );

        requestQueue.add(jor);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);
        //return inflater.inflate(R.layout.fragment_products, container, false);
        return rootView;
    }
}