package com.example.kinshipofrecyclerview.multiselection;

import android.os.Bundle;
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

public class MultipleSelectionActivity extends AppCompatActivity {
    private ArrayList<Employee> employees;
    RecyclerView recyclerView;
    private MultiAdapter adapter;
    Button getMultipleSelectedBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multiple_selection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView4);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        employees = new ArrayList<>();
        adapter = new MultiAdapter(this, employees);

        recyclerView.setAdapter(adapter);

        createEmployees();

        getMultipleSelectedBtn = findViewById(R.id.getMultiSelectedBtn);
        getMultipleSelectedBtn.setOnClickListener(view->{
            ArrayList<Employee> ans = adapter.getSelected();
            String msg = "";
            if(ans.size() == 0) msg = "No Selection";
            else{
                for(Employee e: ans) msg += e.getName()+"\n";
            }
            Toast.makeText(this, msg.trim(), Toast.LENGTH_SHORT).show();
        });
    }

    private void createEmployees() {
        for(int i=1;i<20;i++) employees.add(new Employee("Employee"+i));
//        for(Employee e: employees) Log.v("emp",e.getName());
        adapter.setEmployees(employees);
    }
}