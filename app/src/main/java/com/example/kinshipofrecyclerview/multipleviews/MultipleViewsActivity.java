package com.example.kinshipofrecyclerview.multipleviews;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinshipofrecyclerview.R;
import com.example.kinshipofrecyclerview.model.MultiEmployee;

import java.util.ArrayList;

public class MultipleViewsActivity extends AppCompatActivity {

    private ArrayList<MultiEmployee> employees;
    private RecyclerView recyclerView;
    private MulitpleViewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multiple_views);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recycleView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        insertData();
    }

    private void insertData() {
        employees = new ArrayList<>();
        MultiEmployee emp= new MultiEmployee();
        emp.setName("Ray");
        emp.setAdd("Bangalore");
        emp.setPhone("+917892343574");
        employees.add(emp);

        MultiEmployee emp1= new MultiEmployee();
        emp1.setName("Ray1");
        emp1.setAdd("Hyderabad");
        emp1.setEmail("ray@gmail.com");
        employees.add(emp1);

        MultiEmployee emp2= new MultiEmployee();
        emp2.setName("Roy");
        emp2.setAdd("Mumbai");
        emp2.setPhone("+91678437964");
        employees.add(emp2);

        MultiEmployee emp3= new MultiEmployee();
        emp3.setName("Banerjee");
        emp3.setAdd("Calcutta");
        emp3.setEmail("banerjee@gmail.com");
        employees.add(emp3);

        adapter = new MulitpleViewsAdapter(this, employees);
        recyclerView.setAdapter(adapter);
    }
}