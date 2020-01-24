package com.miguelcr.customlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewStudents);

        students = new ArrayList<>();
        students.add(new Student("Tomek", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"));
        students.add(new Student("Kuba", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/chadengle/128.jpg"));
        students.add(new Student("Lukasz", 17, "https://api.adorable.io/avatars/285/jdhfgkjdfhgk@gmail.com.png"));
        students.add(new Student("Krystian", 17, "https://api.adorable.io/avatars/285/girl@gmail.com.png"));
        students.add(new Student("Borys", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"));
        students.add(new Student("Marcin", 17, "https://api.adorable.io/avatars/285/maria@gmail.com.png"));
        students.add(new Student("Roxi", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"));
        students.add(new Student("Michal", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"));
        students.add(new Student("Mateusz", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"));
        students.add(new Student("Daniel", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"));
        students.add(new Student("Mateusz", 17, "https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"));

        // Adapter
        StudentAdapter adapter = new StudentAdapter(
                this,
                R.layout.student_item,
                students
        );

        lista.setAdapter(adapter);
    }
}
