package com.example.kinshipofrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kinshipofrecyclerview.cardviewrecyclerview.CardViewRecyclerView;
import com.example.kinshipofrecyclerview.multipleviews.MultipleViewsActivity;
import com.example.kinshipofrecyclerview.multiselection.MultipleSelectionActivity;
import com.example.kinshipofrecyclerview.normalrecyclerview.NomralRecyclerViewA;
import com.example.kinshipofrecyclerview.singleitemselectionrecyclerview.SingleItemSelectionRecyclerView;
import com.example.kinshipofrecyclerview.swipeviews.SwipeViewsActivity;

public class MainActivity extends AppCompatActivity {

    Button normal,card,singleSelection,multipleViews,multipleSelection,swiper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        normal = findViewById(R.id.normal);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NomralRecyclerViewA.class));
            }
        });

        card = findViewById(R.id.card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardViewRecyclerView.class));
            }
        });

        singleSelection = findViewById(R.id.singleSelection);
        singleSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SingleItemSelectionRecyclerView.class));
            }
        });
//
        multipleViews = findViewById(R.id.multipleViews);
        multipleViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MultipleViewsActivity.class));
            }
        });

        multipleSelection = findViewById(R.id.multipleSelection);
        multipleSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MultipleSelectionActivity.class));
            }
        });

        swiper = findViewById(R.id.swiper);
        swiper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SwipeViewsActivity.class));
            }
        });
    }
}