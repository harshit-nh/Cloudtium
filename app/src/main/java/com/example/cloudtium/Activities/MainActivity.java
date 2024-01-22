package com.example.cloudtium.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cloudtium.Adapters.HourlyAdapter;
import com.example.cloudtium.Domains.Hourly;
import com.example.cloudtium.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        TextView next7DaysBtn = findViewById(R.id.nextBtn);
        next7DaysBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,FutureActivity.class));
        });
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();

        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",29,"sunny"));
        items.add(new Hourly("12 am",30,"wind"));
        items.add(new Hourly("1 am",29,"rainy"));
        items.add(new Hourly("2 am",27,"storm"));

        recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly = new HourlyAdapter(items,getApplicationContext());
        recyclerView.setAdapter(adapterHourly);
    }
}