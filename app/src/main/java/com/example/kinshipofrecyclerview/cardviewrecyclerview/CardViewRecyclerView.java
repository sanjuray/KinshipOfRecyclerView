package com.example.kinshipofrecyclerview.cardviewrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinshipofrecyclerview.R;
import com.example.kinshipofrecyclerview.model.Planet;

import java.util.ArrayList;

public class CardViewRecyclerView extends AppCompatActivity {

    private ArrayList<Planet> planetArrayList;
    RecyclerView recyclerView;
    CardViewPlanetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_card_view_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.cardRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        planetArrayList = new ArrayList<>();
        adapter = new CardViewPlanetAdapter(this, planetArrayList);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this,
//                LinearLayoutManager.VERTICAL));

        createCardData();

        recyclerView.setAdapter(adapter);
    }

    private void createCardData() {
        Planet planet = new Planet("Mercury",58,4,4900);
        planetArrayList.add(planet);
        planet = new Planet("Venus",108,19,12750);
        planetArrayList.add(planet);
        planet = new Planet("Earth",150,10,12750);
        planetArrayList.add(planet);
        planet = new Planet("Mars",228,4,6800);
        planetArrayList.add(planet);
        planet = new Planet("Jupiter",778,26,143000);
        planetArrayList.add(planet);
        planet = new Planet("Saturn",1429,11,1200000);
        planetArrayList.add(planet);
        planet = new Planet("Neptune",4500,12,50500);
        planetArrayList.add(planet);
        planet = new Planet("Uranus",2870,9,52400);
        planetArrayList.add(planet);
        adapter.notifyDataSetChanged();
    }
}