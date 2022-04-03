package com.vitvn183.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyAdapter recyAdapter;
    static List<Food> foods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        createFood();
        recyAdapter = new RecyAdapter(foods, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(recyAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

    }

    private void createFood() {
        foods.add(new Food(R.drawable.img1, "Hamburger 1", "Burger trắng", "100$"));
        foods.add(new Food(R.drawable.img2, "Hamburger 2", "Burger thịt thăn bò", "100$"));
        foods.add(new Food(R.drawable.img3, "Hamburger 3", "Minetta Burger", "100$"));
        foods.add(new Food(R.drawable.img1, "Hamburger 4", "Burger phô mai xanh", "100$"));
        foods.add(new Food(R.drawable.img5, "Hamburger 5", "Hamburger Chicken", "100$"));
        foods.add(new Food(R.drawable.img2, "Hamburger 6", "Burger cá hồi", "100$"));
        foods.add(new Food(R.drawable.img3, "Hamburger 7", "Burger nướng Hàn Quốc", "100$"));
        foods.add(new Food(R.drawable.img4, "Hamburger 8", "Burger Silton", "100$"));
        foods.add(new Food(R.drawable.img1, "Hamburger 9", "Burger thịt cừu với rau mùi Raita.", "100$"));
    }
}