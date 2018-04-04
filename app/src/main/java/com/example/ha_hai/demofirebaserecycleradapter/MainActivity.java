package com.example.ha_hai.demofirebaserecycleradapter;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.ha_hai.demofirebaserecycleradapter.ViewHolder.FoodViewHolder;
import com.example.ha_hai.demofirebaserecycleradapter.model.Foods;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity{

//    RecyclerView recyclerView;
//
//    FirebaseDatabase database;
//    DatabaseReference reference;
//
//    FirebaseRecyclerAdapter adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //init view
//        recyclerView = findViewById(R.id.recyclerview);
//
//
//        Query query = FirebaseDatabase.getInstance()
//                .getReference()
//                .child("Foods")
//                .limitToFirst(20);
//
//        FirebaseRecyclerOptions<Foods> options = new FirebaseRecyclerOptions.Builder<Foods>()
//                .setQuery(query, Foods.class)
//                .build();
//
//        adapter = new FirebaseRecyclerAdapter<Foods, FoodViewHolder>(options) {
//
//            @Override
//            public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View view = inflater.inflate(R.layout.item_row_food, parent, false);
//
//                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale_animation);
//                view.setAnimation(anim);
//
//                Log.d("View.getID", view.getId() + " ");
//
//
//                return new FoodViewHolder(view);
//            }
//
//            @Override
//            protected void onBindViewHolder(@NonNull FoodViewHolder holder, int position, @NonNull Foods model) {
//                holder.txtName.setText(model.getName());
//                holder.txtPrice.setText(model.getPrice());
//                Picasso.get().load(model.getImage()).into(holder.imgHinhAnh);
//            }
//        };
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(adapter);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        adapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }
    private Cursor employees;
    private SqlDatabase db;

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new SqlDatabase(MainActivity.this);

        listView = findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, db.getEmployees());
        listView.setAdapter(adapter);

//        employees = db.getEmployees(); // you would not typically call this on the main thread
//
//        ListAdapter adapter = new SimpleCursorAdapter(this,
//                android.R.layout.simple_list_item_1,
//                employees,
//                new String[]{"FirstName"},
//                new int[]{android.R.id.text1});
//
//
//        getListView().setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        employees.close();
        db.close();
    }
}
