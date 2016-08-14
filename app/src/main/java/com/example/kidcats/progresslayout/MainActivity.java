package com.example.kidcats.progresslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private RecyclerView recyclerView;
    private List<String> datas;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas=new ArrayList<>();
        datas.add("hello world");
        datas.add("hello wrld");
        datas.add("hello wod");
        datas.add("hlo world");
        datas.add("world");
        datas.add("hello world");
        datas.add("hello wrld");
        datas.add("hello wod");
        datas.add("hlo world");
        datas.add("world");
        datas.add("hello wod");
        datas.add("hlo world");
        datas.add("world");
        datas.add("hello world");
        datas.add("hello wrld");
        adapter=new MyAdapter(datas,this);
        recyclerView= (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClickListener(View view, int position) {
                Log.i(TAG,"click");
            }
        });
    }
}
