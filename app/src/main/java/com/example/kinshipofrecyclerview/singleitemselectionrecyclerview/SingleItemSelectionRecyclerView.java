package com.example.kinshipofrecyclerview.singleitemselectionrecyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinshipofrecyclerview.R;
import com.example.kinshipofrecyclerview.model.Employee;

import java.util.ArrayList;

public class SingleItemSelectionRecyclerView extends AppCompatActivity {

    private ArrayList<Employee> employees;

    private Button getSelectedBtn;
    private RecyclerView recyclerView;
    private SingleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_single_item_selection_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        getSelectedBtn = findViewById(R.id.getSelectedBtn);
        getSelectedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee e = adapter.getSelected();
                if(e!=null)
                    Toast.makeText(SingleItemSelectionRecyclerView.this, "Selection: "+e.getName(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SingleItemSelectionRecyclerView.this, "No Selection", Toast.LENGTH_SHORT).show();
            }
        });

        employees = new ArrayList<>();
        adapter = new SingleAdapter(this, employees);

        recyclerView.setAdapter(adapter);

        createList();
    }

    private void createList() {
        for(int i = 1;i<20;i++) employees.add(new Employee("Employee "+i));
        adapter.setEmployees(employees);
    }
}