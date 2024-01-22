package com.example.cloudtium.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cloudtium.Adapters.FutureAdapter;
import com.example.cloudtium.Domains.FutureDomain;
import com.example.cloudtium.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(view -> {
            startActivity(new Intent(FutureActivity.this,MainActivity.class));
        });
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items = new ArrayList<>();

        items.add(new FutureDomain("Tue","storm","Stormy",25,10));
        items.add(new FutureDomain("Wed","cloudy","Cloudy",24,16));
        items.add(new FutureDomain("Thu","windy","Windy",29,15));
        items.add(new FutureDomain("Fri","cloudy_sunny","Cloudy-Sunny",22,13));
        items.add(new FutureDomain("Sat","sunny","Sunny",28,11));
        items.add(new FutureDomain("Sun","rainy","Rainy",23,12));

        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTomorrow = new FutureAdapter(items,getApplicationContext());
        recyclerView.setAdapter(adapterTomorrow);

    }
}