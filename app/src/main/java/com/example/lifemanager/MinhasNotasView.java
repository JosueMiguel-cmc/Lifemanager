package com.example.lifemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lifemanager.VIEW.activity_notas_view;

public class MinhasNotasView extends AppCompatActivity {
    ImageButton btncriarnota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_notas_view);

        btncriarnota = findViewById(R.id.btncriar);

        btncriarnota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), activity_notas_view.class);
                startActivity(it);
            }
        });

    }
}