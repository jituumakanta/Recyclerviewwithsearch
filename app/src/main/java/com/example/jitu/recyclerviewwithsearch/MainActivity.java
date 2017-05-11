package com.example.jitu.recyclerviewwithsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    public SearchView search;
    private List<String> list = new ArrayList<String>();
    Adapter mAdapter;
    protected Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        createlist();  // in this method, Create a list of items.
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new Adapter(list, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        handler = new Handler();

        mAdapter.setOnLoadMoreListener(new Adapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                //add progress item
                list.add(null);
                mAdapter.notifyItemInserted(list.size() - 1);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //remove progress item
                        list.remove(list.size() - 1);
                        mAdapter.notifyItemRemoved(list.size());
                        //add items one by one
                        for (int i = 0; i < 15; i++) {
                            list.add("Item " + (list.size() + 1));
                            mAdapter.notifyItemInserted(list.size());
                        }
                        mAdapter.setLoaded();
                        //or you can add all at once but do not forget to call mAdapter.notifyDataSetChanged();
                    }
                }, 2000);
                System.out.println("load");
            }
        });


    }

    // this method is used to create list of items.
    public void createlist(){
        for(int i=1; i<=12;i++) {
            list.add("Item "+i);
        }
    }
















}
