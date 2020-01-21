package com.example.sectionedrecyclerview.DataLoader;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sectionedrecyclerview.ModelData.HomeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class HomeDataLoader {

    public static final String TAGHOME = "fh_data_l";

    public static ArrayList<HomeModel> getHomeDataSectionA(@NonNull final Context context, @NonNull final String url, @NonNull final SectionedRecyclerViewAdapter adapter) {

        final String userId = "userId";
        final String id = "id";
        final String title = "title";
        final String body = "body";

        final ArrayList<HomeModel> mData = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Runnable() {
            RequestQueue m = Volley.newRequestQueue(context);

            @Override
            public void run() {

                final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length()/5; i++) {
                                JSONObject post = response.getJSONObject(i);
                                String Uid = post.getString(userId);
                                String Pid = post.getString(id);
                                String Title = post.getString(title);
                                String Body = post.getString(body);

                                mData.add(new HomeModel(Uid, Pid, Title, Body));


                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Log.i(TAGHOME, "Error-" + e);
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAGHOME, "VolleyError-" + error);
                    }
                });

                m.add(request);

            }
        });
        return mData;
    }
}
