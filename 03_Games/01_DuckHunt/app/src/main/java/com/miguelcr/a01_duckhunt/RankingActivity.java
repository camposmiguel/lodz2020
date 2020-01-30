package com.miguelcr.a01_duckhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {
    ListView lista;
    List<User> userList;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        lista = findViewById(R.id.listViewRanking);

        userList = new ArrayList<>();
        userList.add(new User("Tomek", 100));
        userList.add(new User("Lukasz", 80));
        userList.add(new User("Daniel", 55));
        userList.add(new User("Mateusz", 40));
        userList.add(new User("Borys", 20));

        adapter = new UserAdapter(
                this,
                R.layout.user_item,
                userList
        );

        lista.setAdapter(adapter);
    }
}
