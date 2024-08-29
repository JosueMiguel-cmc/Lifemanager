package com.example.lifemanager.VIEW;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lifemanager.Areanotas;
import com.example.lifemanager.MinhasNotasView;
import com.example.lifemanager.R;
import com.example.lifemanager.activity_calendario_view;
import com.google.firebase.auth.FirebaseAuth;

public class PrincipalView extends AppCompatActivity {
    Button btnNotas;
    Button btnconfig;
    Button btncancelar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_view);
        btnNotas = findViewById(R.id.btn_minhas_notas);
        btncancelar = findViewById(R.id.btn_calendar);
        btnconfig = findViewById(R.id.btn_config);

        btnconfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth a = FirebaseAuth.getInstance();
                a.signOut();
                finish();
            }
        });
        btnNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), MinhasNotasView.class);
                startActivity(it);

            }
        });
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), activity_calendario_view.class);
                startActivity(it);
            }
        });
    }
}