package com.eshreef.help;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.eshreef.help.model.USER;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.eshreef.help.databinding.ActivitySingupBinding;
import javax.inject.Inject;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySingupBinding binding;
    
    @Inject
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        ((SikiApplication) getApplication()).getAppComponent().inject(this);
        
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference user_tab = database.getReference("user");
        binding.singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.username.getText().toString();
                String pass = binding.password.getText().toString();
                final String name = binding.nickname.getText().toString();
                
                if(email.isEmpty() || pass.isEmpty() || name.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "يرجى ملء جميع الحقول", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(SignUpActivity.this, task -> {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                String userId = mAuth.getCurrentUser().getUid();
                                USER user = new USER(name, ""); // Don't store password
                                user_tab.child(userId).setValue(user);
                                Toast.makeText(SignUpActivity.this, "تم إنشاء الحساب بنجاح", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignUpActivity.this, "فشل إنشاء الحساب: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
