package com.example.lifemanager.VIEW;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lifemanager.Areanotas;
import com.example.lifemanager.R;
import com.example.lifemanager.activity_calendario_view;
import com.google.firebase.auth.FirebaseAuth;

import DAO.UsuarioDAO;

public class PrincipalView extends AppCompatActivity {
    Button btnNotas;
    Button btnconfig;
    Button btncancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_view);
        btnNotas = findViewById(R.id.btn_nova_nota);
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
                Intent it = new Intent(getBaseContext(), Areanotas.class);
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