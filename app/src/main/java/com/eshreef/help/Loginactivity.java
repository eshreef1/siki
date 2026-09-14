package com.eshreef.help;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Loginactivity extends AppCompatActivity {
    Button singup,singin;
    TextView logtext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        singup =findViewById(R.id.singup);
        singin = findViewById(R.id.singin);
        logtext =findViewById(R.id.log_text);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loginactivity.this, SiginActivity.class);
                startActivity(intent);


            }
        });
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loginactivity.this,SingupActivity.class );
                startActivity(intent);
            }
        });

    }
}
