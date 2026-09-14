package com.eshreef.help;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.eshreef.help.model.Desies;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Desis_detils extends AppCompatActivity {
    TextView de_name,de_discraption;
    ImageView de_image;
    FirebaseDatabase database;
    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desis_detils);
        de_name = findViewById(R.id.de_name);
        de_discraption = findViewById(R.id.de_Descraption);
        de_image = findViewById(R.id.des_image);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Desies");
        Intent intent=this.getIntent();
        String name = intent.getStringExtra("name");
        String discatpions = intent.getStringExtra("discatpions");
        String image = intent.getStringExtra("image");


        if(getIntent() != null){
            de_name.setText(name);
            de_discraption.setText(discatpions);
            Picasso.get().load(image).into(de_image);
        }



    }

  /*  private void loaddata() {
        reference.child(desisid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Desies desies = dataSnapshot.getValue(Desies.class);

                    Picasso.get().load(image).into(de_image);
                    de_name.setText(name);
                    de_discraption.setText(discatpion);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */

    }



