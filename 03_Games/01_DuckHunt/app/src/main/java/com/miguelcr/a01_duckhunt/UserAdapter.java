package com.miguelcr.a01_duckhunt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    Context ctx;
    int template;
    List<User> userList;
    int[] icons = {
            R.drawable.ic_one,
            R.drawable.ic_two,
            R.drawable.ic_three,
            R.drawable.ic_four,
            R.drawable.ic_five,
            R.drawable.ic_six,
            R.drawable.ic_seven,
            R.drawable.ic_eight,
            R.drawable.ic_nine
    };

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.template = resource;
        this.userList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template, parent, false);

        User current = userList.get(position);
        String nick = current.getNick();
        int ducks = current.getDucks();

        ImageView ivPosition = v.findViewById(R.id.imageViewPosition);
        TextView tvNick = v.findViewById(R.id.textViewNick);
        TextView tvDucks = v.findViewById(R.id.textViewDucks);

        tvNick.setText(nick);
        tvDucks.setText(ducks + " ducks");
        ivPosition.setImageResource(icons[position]);

        return v;
    }
}
