package com.example.lifemanager.VIEW;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lifemanager.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class Logview extends AppCompatActivity {
    TextInputEditText emailinput, senhainput;
    Button cadbtn, logbtn;
    private FirebaseAuth FBA = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logview);
        emailinput = findViewById(R.id.emailinp2);
        senhainput = findViewById(R.id.senhainp2);
        cadbtn = findViewById(R.id.cadastrobtn2);
        logbtn = findViewById(R.id.loginbtn2);


        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailinput.getText().toString();
                String senha = senhainput.getText().toString();
                if (email.isEmpty() || senha.isEmpty()){
                    Snackbar sna = Snackbar.make(findViewById(R.id.cadastrobtn2),"por favor preencha todos os campos!",Snackbar.LENGTH_SHORT);
                    sna.setBackgroundTint(Color.RED);
                    sna.setTextColor(Color.WHITE);
                    sna.show();
                }else{
                    FBA.signInWithEmailAndPassword(email,senha).addOnCompleteListener(task -> {
                       if (task.isSuccessful()){
                           Snackbar sna = Snackbar.make(findViewById(R.id.cadastrobtn2),"Seja bem vindo!" + email,Snackbar.LENGTH_SHORT);
                           sna.setBackgroundTint(Color.GREEN);
                           sna.setTextColor(Color.WHITE);
                           sna.show();
                       }
                    });
                }
            }
        });

        cadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(),Cadview.class);
                startActivity(it);
                finish();
            }
        });
    }
}