package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> tasks;
    RecyclerView recyclerView;
    EditText edNewTitle, edNewDescription;
    Button buttonAdd;
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating new adapter with list of tasks.
        tasks  = new ArrayList<>();
        adapter= new TaskAdapter();
        adapter.setTasks(tasks);

        //creating Recycling view which control our RV on activity_main.xml, using the adapter from above

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this.getApplicationContext());
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();// each time we change an element on the list, or the list itself
                                        // we need to call this function to rerender

        // getting from xml edittexts and button elements
        edNewDescription = findViewById(R.id.ed_description);
        edNewTitle = findViewById(R.id.ed_title);
        buttonAdd = findViewById(R.id.button_add);

        // setting the listener for the button. ( the actions to do when clicked on the button)
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add a new task

                String newTitle, newDescription;
                //get values from editTexts
                newTitle = edNewTitle.getText().toString();
                newDescription = edNewDescription.getText().toString();

                //clean old values
                edNewDescription.setText("");
                edNewTitle.setText("");

                //add new task, on top of the list.
                Task newTask = new Task(newTitle, newDescription);
                tasks.add(0,newTask);
                adapter.notifyDataSetChanged();// each time we change an element on the list, or the list itself
                                                // we need to call this function to rerender

            }
        });
    }
}
