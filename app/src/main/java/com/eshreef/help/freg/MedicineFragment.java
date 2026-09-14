package com.eshreef.help.freg;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.eshreef.help.Interface.ItemclickLisnter;
import com.eshreef.help.Medison_list;
import com.eshreef.help.R;
import com.eshreef.help.Viewholder.Viewholder;
import com.eshreef.help.model.Medson;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MedicineFragment extends Fragment {
    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseRecyclerOptions<Medson> options;
    FirebaseRecyclerAdapter<Medson, Viewholder> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


    return inflater.inflate(R.layout.fragment_medison,container,false);

            // Populate view as needed
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.MrecylyView);
        database = FirebaseDatabase.getInstance();
        reference =database.getReference().child("medicament");
        options = new FirebaseRecyclerOptions.Builder<Medson>().setQuery(reference,Medson.class).build();
        adapter = new FirebaseRecyclerAdapter<Medson, Viewholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Viewholder viewholder, int i, @NonNull final Medson medson) {

                Picasso.get().load(medson.getImage()).into(viewholder.images);
                viewholder.name.setText(medson.getName());
                final Medson clickitem = medson;
                viewholder.setItemclickLisnter(new ItemclickLisnter() {
                    @Override
                    public void onClick(View view, int postion, boolean islongClick) {
                        Intent intent = new Intent(getActivity().getApplicationContext() , Medison_list.class);
                      intent.putExtra("medisonid",adapter.getRef(postion).getKey());

                      startActivity(intent);
                    //   Toast.makeText(getActivity().getApplicationContext(), ""+clickitem.getName(), Toast.LENGTH_SHORT).show();
                    }
                });


            }

            @NonNull
            @Override
            public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);

                return new Viewholder(view);
            }
        };

       GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
      //  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        adapter.startListening();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        if(adapter!= null)
            adapter.startListening();
    }

    public MedicineFragment() {
        // Required empty public constructor
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
    // TODO: Rename method, update argument and hook method into UI event

    }



