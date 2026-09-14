package com.eshreef.help;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eshreef.help.Interface.ItemclickLisnter;
import com.eshreef.help.Viewholder.MedsioViewholder;
import com.eshreef.help.model.Medion_description;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Medison_list extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager LinearLayoutManager;
    FirebaseRecyclerOptions<Medion_description> options;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseRecyclerAdapter<Medion_description, MedsioViewholder> adapter;
    String medisonid = "";
    private static final String TAG = "Medison_list";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medison_list);
        database = FirebaseDatabase.getInstance();
        reference  = database.getReference("med_description");
        recyclerView = findViewById(R.id.med_list);
     //   recyclerView.setHasFixedSize(true);
        LinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LinearLayoutManager);


        if(getIntent() != null)
           medisonid = getIntent().getStringExtra("medisonid");

        if(!medisonid.isEmpty() && medisonid != null)
        {


        loaddata(medisonid);

        }

    }

    private void loaddata(String medisonid) {
        options = new FirebaseRecyclerOptions.Builder<Medion_description>().setQuery(reference.orderByChild("menuId").equalTo(medisonid),Medion_description.class).build();

        adapter = new FirebaseRecyclerAdapter<Medion_description, MedsioViewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MedsioViewholder medsioViewholder, int i, @NonNull Medion_description medion_description) {
                Picasso.get().load(medion_description.getImage()).into(medsioViewholder.medison_image);
                medsioViewholder.medison_name.setText(medion_description.getName());
                final Medion_description med = medion_description;
                medsioViewholder.setItemclickLisnter(new ItemclickLisnter() {
                    @Override
                    public void onClick(View view, int postion, boolean islongClick) {
                        Intent intent = new Intent(Medison_list.this,Medson_details.class);
                        intent.putExtra("medsonid" ,adapter.getRef(postion).getKey());
                        startActivity(intent);
                      //  Toast.makeText(Medison_list.this, ""+med.getName(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @NonNull
            @Override
            public MedsioViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.med_list,parent,false);

                return new MedsioViewholder(view);            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onStart() {
        super.onStart();
        if(adapter!= null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter!=null)
            adapter.stopListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter!= null)
            adapter.startListening();
    }
}

