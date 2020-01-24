package com.miguelcr.a01_simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get a reference to the View Component
        lista = findViewById(R.id.listViewStudents);

        // 2. Create the list of students to show
        // in the ListView
        students = new ArrayList<>();

        // 3. Add elements to the list
        students.add("Tomek");
        students.add("Kuba");
        students.add("Lukasz I");
        students.add("Krystian");
        students.add("Borys");
        students.add("Marcin");
        students.add("Roxi");
        students.add("Michal");
        students.add("Mateusz I");
        students.add("Daniel");
        students.add("Mateusz II");
        students.add("Lukasz II");
        students.add("Kacper");
        students.add("Pawel");
        students.add("Julia");
        students.add("Sara");
        students.add("Lidka");

        // 4. We need now a component to connect the List of students
        // with the ListView component. The component name is
        // ArrayAdapter

        // Params
        // - Context: is a reference to the Activity
        // - Layout: the user interface for 1 list item.
        // - data: the list of students to show in the screen.

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        lista.setAdapter(adapter);

        // Manage the click on the list items.
        lista.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = students.get(position);

        Toast.makeText(this, "Student: " + name, Toast.LENGTH_SHORT).show();

        // Open the StudentDetailActivity (new page)
        Intent i = new Intent(this, StudentDetailActivity.class);

        // Send information to the StudentDetailActivity
        i.putExtra("studentName", name);

        startActivity(i);
    }
}
