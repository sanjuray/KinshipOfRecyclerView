package com.example.kinshipofrecyclerview.multipleviews;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinshipofrecyclerview.R;
import com.example.kinshipofrecyclerview.model.MultiEmployee;

import java.util.ArrayList;

public class MulitpleViewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static int TYPE_CALL = 1;
    private static int TYPE_EMAIL = 2;
    private Context context;
    private ArrayList<MultiEmployee> employees;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_CALL) {
            view = LayoutInflater.from(context)
                    .inflate(
                            R.layout.item_call,
                            parent,
                            false
                    );
            return new CallViewHolder(view);
        }
        else{
            view = LayoutInflater.from(context)
                    .inflate(
                            R.layout.item_email,
                            parent,
                            false
                    );
            return new MailViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(TextUtils.isEmpty(employees.get(position).getEmail())) return TYPE_CALL;
        return TYPE_EMAIL;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==TYPE_CALL) ((CallViewHolder)holder).setDetails(employees.get(position));
        else ((MailViewHolder)holder).setMailDetails(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public MulitpleViewsAdapter(Context context, ArrayList<MultiEmployee> employees) {
        this.context = context;
        this.employees = employees;
    }

    class CallViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView add;
        public CallViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cName);
            add = itemView.findViewById(R.id.cAdd);
        }
        void setDetails(MultiEmployee e){
            name.setText(e.getName());
            add.setText(e.getAdd());
        }
    }

    class MailViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView add;
        public MailViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            add = itemView.findViewById(R.id.add);
        }
        void setMailDetails(MultiEmployee e){
            name.setText(e.getName());
            add.setText(e.getAdd());
        }
    }

}

