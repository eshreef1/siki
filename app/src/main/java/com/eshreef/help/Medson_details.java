package com.eshreef.help;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.eshreef.help.model.Medion_description;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class Medson_details extends AppCompatActivity {
    TextView medson_name,medson_price,medson_discraption;
    ImageView med_image;
    CollapsingToolbarLayout collapsingToolbarLayout;

    FirebaseDatabase database;
    DatabaseReference reference;
    String medsonid = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medson_details);
        medson_name = findViewById(R.id.medson_de_name);
        medson_price = findViewById(R.id.medson_price);
        medson_discraption = findViewById(R.id.medson_descatpion);
        med_image = findViewById(R.id.medon_img);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("med_description");
        collapsingToolbarLayout = findViewById(R.id.collapseActionView);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.Collapsingexpand);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.Collapsing);

        if(getIntent() != null)
            medsonid =getIntent().getStringExtra("medsonid");
        if(!medsonid.isEmpty()){
    
        getdetails(medsonid);
        }
    }

    private void getdetails(String medsonid) {
        reference.child(medsonid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Medion_description medionDescription = dataSnapshot.getValue(Medion_description.class);
                Picasso.get().load(medionDescription.getImage()).into(med_image);
                collapsingToolbarLayout.setTitle(medionDescription.getName());
                medson_price.setText(medionDescription.getPrice());
                medson_name.setText(medionDescription.getName());
                medson_discraption.setText(medionDescription.getDescription());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
