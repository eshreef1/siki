package com.eshreef.help.freg;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eshreef.help.Desis_detils;
import com.eshreef.help.Interface.ItemclickLisnter;
import com.eshreef.help.R;
import com.eshreef.help.Viewholder.Desisviewhold;
import com.eshreef.help.model.Desies;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiseasesFragment extends Fragment {

    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseRecyclerOptions<Desies> options;
    FirebaseRecyclerAdapter<Desies, Desisviewhold> adapter;
    String desisid = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dises, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.deises_list);
        database = FirebaseDatabase.getInstance();
        reference =database.getReference().child("Desies");
        options = new FirebaseRecyclerOptions.Builder<Desies>().setQuery(reference,Desies.class).build();
        adapter = new FirebaseRecyclerAdapter<Desies, Desisviewhold>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Desisviewhold desisViewholder, int i, @NonNull Desies desies) {
                Picasso.get().load(desies.getImage()).into(desisViewholder.Desis_image);
                desisViewholder.Desis_name.setText(desies.getName());
                final Desies clickitem = desies;
                desisViewholder.setItemclickLisnter(new ItemclickLisnter() {
                    @Override
                    public void onClick(View view, int postion, boolean islongClick) {
                        Intent intent = new Intent(getContext() , Desis_detils.class);
                        Toast.makeText(getActivity().getApplicationContext(), clickitem.getDescatpion(), Toast.LENGTH_SHORT).show();
                        Bundle bundle = new Bundle();
                        bundle.putString("name",clickitem.getName());
                        bundle.putString("discatpions",clickitem.getDescatpion());
                        bundle.putString("image",clickitem.getImage());
                        intent.putExtras(bundle);


                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public Desisviewhold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.desis_item,parent,false);

                return new Desisviewhold(view);

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

    public DiseasesFragment() {
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
}
