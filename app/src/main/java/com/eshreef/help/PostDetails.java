package com.eshreef.help;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class PostDetails extends AppCompatActivity {
    TextView med_name,med_details;
    ImageView med_images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("تفاصيل الدواء");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        med_name = findViewById(R.id.med_post_name);
        med_details = findViewById(R.id.med_post_detils);
        med_images = findViewById(R.id.image_post);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
