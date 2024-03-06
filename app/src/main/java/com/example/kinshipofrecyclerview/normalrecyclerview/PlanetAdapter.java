package com.example.kinshipofrecyclerview.normalrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinshipofrecyclerview.R;
import com.example.kinshipofrecyclerview.model.Planet;

import java.util.ArrayList;
import java.util.Locale;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder>{

    private Context context;
    private ArrayList<Planet> planets;

    public PlanetAdapter(Context context, ArrayList<Planet> planetArrayList) {
        this.context = context;
        this.planets = planetArrayList;
    }

    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(
                        R.layout.normal_reyclerview_planet_layout,
                        parent,
                        false
                );
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {
        Planet planet= planets.get(position);
        holder.setDetails(planet);
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    class PlanetHolder extends RecyclerView.ViewHolder{
        TextView planetName, planetDistance, planetGravity, planetDiameter;
        public PlanetHolder(@NonNull View itemView) {
            super(itemView);
            planetName = itemView.findViewById(com.example.kinshipofrecyclerview.R.id.planetName);
            planetDistance = itemView.findViewById(R.id.planetDistance);
            planetGravity = itemView.findViewById(R.id.planetGravity);
            planetDiameter = itemView.findViewById(R.id.planetDiameter);
        }

        public void setDetails(Planet planet) {
            planetName.setText(planet.getName());
            planetDistance.setText(String.format(
                    Locale.US,
                    "Distance From Sun: %d MiilionKms",planet.getDistanceFromSun()
            ));
            planetGravity.setText(String.format(
                    Locale.US,
                    "SurfaceGravity: %dN/Kg",planet.getGravity()
            ));
            planetDiameter.setText(String.format(
                    Locale.US,
                    "Diameter: %dKm",planet.getDiameter()
            ));
        }
    }
}

