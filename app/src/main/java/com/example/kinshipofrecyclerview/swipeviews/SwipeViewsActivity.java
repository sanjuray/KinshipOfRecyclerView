package com.example.kinshipofrecyclerview.swipeviews;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinshipofrecyclerview.R;
import com.example.kinshipofrecyclerview.model.Employee;
import com.example.kinshipofrecyclerview.multiselection.MultiAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class SwipeViewsActivity extends AppCompatActivity {

    ArrayList<Employee> employees;
    RecyclerView recyclerView;
    Button swipeGetSelected;
    MultiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_swipe_views);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView  = findViewById(R.id.recyclerView5);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        employees = new ArrayList<>();
        adapter = new MultiAdapter(this,employees);

        recyclerView.setAdapter(adapter);

        createData();

        swipeGetSelected = findViewById(R.id.swipeGetSelected);
        swipeGetSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Employee> ans = adapter.getSelected();
                String msg = "";
                if(ans.size() == 0) msg = "No Selection";
                else{
                    for(Employee e: ans) msg += e.getName()+"\n";
                }
                Toast.makeText(SwipeViewsActivity.this, msg.trim(), Toast.LENGTH_SHORT).show();
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.LEFT:
                    Employee e = adapter.removeSelection(position);
//                    final boolean[] flag = {false};
                    Snackbar.make(recyclerView,e.getName(),Snackbar.LENGTH_SHORT)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                                    flag[0] = true;
                                    adapter.retrievePrevVer();
                                }
                            }).show();
//                    adapter.cancelRetrievePrevVer();
                    break;
                case ItemTouchHelper.RIGHT:
                    adapter.changeSelection(viewHolder,position);
                    break;
            }
        }
    };

    private void createData() {
        for(int i=1;i<20;i++) employees.add(new Employee("Employee"+i));
//        for(Employee e: employees) Log.v("emp",e.getName());
        adapter.setEmployees(employees);
    }
}