package com.example.kinshipofrecyclerview.singleitemselectionrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.kinshipofrecyclerview.R;
import com.example.kinshipofrecyclerview.model.Employee;

import java.util.ArrayList;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.SingleViewHolder> {
    private Context context;
    private ArrayList<Employee> employees;
    private int checkedPosition = -1;

    public SingleAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SingleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(
                        R.layout.item_employee,
                        parent,
                        false
                );
        return new SingleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleViewHolder holder, int position) {
        holder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public Employee getSelected(){
        if(checkedPosition != -1) return employees.get(checkedPosition);
        return null;
    }

    class SingleViewHolder extends RecyclerView.ViewHolder{
        TextView empName;
        ImageView imageView;

        public SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            empName = itemView.findViewById(R.id.empName);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(final Employee employee){
            if(checkedPosition == -1){
                imageView.setVisibility(View.GONE);
            }else{
                if(checkedPosition == getAdapterPosition()){
                    imageView.setVisibility(View.VISIBLE);
                }
                else{
                    imageView.setVisibility(View.GONE);
                }
            }
            empName.setText(employee.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView.setVisibility(View.VISIBLE);
                    if(checkedPosition != getAdapterPosition()){
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }else{
                        notifyItemChanged(checkedPosition);
                        checkedPosition = -1;
                    }
                }
            });
        }
    }
}

