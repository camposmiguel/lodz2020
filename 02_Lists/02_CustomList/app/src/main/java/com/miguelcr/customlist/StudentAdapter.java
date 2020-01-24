package com.miguelcr.customlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    Context ctx;
    List<Student> students;
    int template;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.students = objects;
        this.template = resource;
    }

    // Loop,

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template, parent, false);

        // Get the current student
        Student current = students.get(position);

        String name = current.getName();
        int age = current.getAge();
        String photoAddress = current.getPhotoAddress();

        // Get the View Components
        ImageView ivPhoto = v.findViewById(R.id.imageViewPhoto);
        TextView tvName = v.findViewById(R.id.textViewName);
        TextView tvAge = v.findViewById(R.id.textViewAge);

        // Set the information into the View Components
        tvName.setText(name);
        tvAge.setText("Age: " + age);

        Glide.with(ctx)
                .load(photoAddress)
                .into(ivPhoto);

        return v;
    }
}
