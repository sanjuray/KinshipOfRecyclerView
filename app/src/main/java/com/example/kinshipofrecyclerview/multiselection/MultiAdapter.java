package com.example.kinshipofrecyclerview.multiselection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinshipofrecyclerview.R;
import com.example.kinshipofrecyclerview.model.Employee;

import java.util.ArrayList;

public class MultiAdapter extends RecyclerView.Adapter<MultiAdapter.MultiHolder> {
    private Context context;
    private ArrayList<Employee> prevEmployees;
    private ArrayList<Employee> employees;

    public MultiAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
//        employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    public void changeSelection(RecyclerView.ViewHolder viewHolder,int p){
        Employee e = employees.get(p);
        Toast.makeText(context, e.getName()+" selected is toggled", Toast.LENGTH_SHORT).show();
        e.setChecked(!e.isChecked());
        ((MultiAdapter.MultiHolder)viewHolder).imageView.setVisibility(e.isChecked()? View.VISIBLE:View.GONE);
        notifyDataSetChanged();
    }

    public Employee removeSelection(int p){
        prevEmployees = new ArrayList<>(employees);
        Employee e = employees.remove(p);
        Toast.makeText(context, e.getName()+"is deleted", Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();
        return e;
    }

    public void retrievePrevVer(){
        employees = prevEmployees;
        cancelRetrievePrevVer();
    }

    public void cancelRetrievePrevVer(){
        prevEmployees = null;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MultiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(
                        R.layout.item_employee,
                        parent,
                        false
                );
        return new MultiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultiHolder holder, int position) {
        holder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public ArrayList<Employee> getAll(){return employees;}
    public ArrayList<Employee> getSelected(){
        ArrayList<Employee> selects = new ArrayList<>();
        for(Employee e: employees) if(e.isChecked()) selects.add(e);
        return selects;
    }

    class MultiHolder extends RecyclerView.ViewHolder{
        private TextView empName;
        private ImageView imageView;
        public MultiHolder(@NonNull View itemView) {
            super(itemView);
            empName = itemView.findViewById(R.id.empName);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(final Employee e){
            empName.setText(e.getName());
            imageView.setVisibility(e.isChecked()?View.VISIBLE:View.GONE);

            itemView.setOnClickListener(v->{
                e.setChecked(!e.isChecked());
                imageView.setVisibility(e.isChecked()?View.VISIBLE:View.GONE);
                notifyDataSetChanged();
            });
        }
    }
}
