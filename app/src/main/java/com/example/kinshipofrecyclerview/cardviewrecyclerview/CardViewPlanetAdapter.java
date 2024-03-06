package com.example.kinshipofrecyclerview.cardviewrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinshipofrecyclerview.R;
import com.example.kinshipofrecyclerview.model.Planet;

import java.util.ArrayList;
import java.util.Locale;

public class CardViewPlanetAdapter extends RecyclerView.Adapter<CardViewPlanetAdapter.CardHolder> {
    private Context context;
    private ArrayList<Planet> planets;

    public CardViewPlanetAdapter(Context context, ArrayList<Planet> planetArrayList) {
        this.context = context;
        this.planets = planetArrayList;
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(
                        R.layout.card_recyclerview,
                        parent,
                        false
                );
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        Planet planet = planets.get(position);
        holder.setDetails(planet);
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView planetName, planetDistance, planetGravity, planetDiameter;
        public CardHolder(@NonNull View itemView) {
            super(itemView);
            planetName = itemView.findViewById(R.id.cardPlanetName);
            planetDistance = itemView.findViewById(R.id.cardPlanetDistance);
            planetGravity = itemView.findViewById(R.id.cardPlanetGravity);
            planetDiameter = itemView.findViewById(R.id.cardPlanetDiameter);
            itemView.setOnClickListener(this);
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

        @Override
        public void onClick(View v) {
            Toast.makeText(context, ""+planets.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}

