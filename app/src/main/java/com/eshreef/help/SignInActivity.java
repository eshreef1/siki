package com.eshreef.help;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.eshreef.help.common.common;
import com.eshreef.help.model.USER;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.eshreef.help.databinding.ActivitySiginBinding;
import javax.inject.Inject;

public class SignInActivity extends AppCompatActivity {
    private ActivitySiginBinding binding;
    
    @Inject
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySiginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        ((SikiApplication) getApplication()).getAppComponent().inject(this);
        
        binding.singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.username.getText().toString();
                String pass = binding.password.getText().toString();
                
                if(email.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(SignInActivity.this, "يرجى ملء جميع الحقول", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(SignInActivity.this, task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignInActivity.this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(SignInActivity.this, "خطأ في تسجيل الدخول", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });

    }
}
