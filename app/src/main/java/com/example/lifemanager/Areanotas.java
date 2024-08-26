package com.example.lifemanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lifemanager.VIEW.activity_notas_view;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import VO.NotasOBJ;

public class Areanotas extends AppCompatActivity {
    ListView listaviewnotas;
    ArrayAdapter<String> notasAdapter;
    List<String> notalist; // Lista de strings para exibir no ListView
    DatabaseReference databasenotes;
    Button criarnotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areanotas);

        listaviewnotas = findViewById(R.id.Listviewnotas);
        notalist = new ArrayList<>();

        databasenotes = FirebaseDatabase.getInstance().getReference("Notas");

        databasenotes.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    // Obtenha o nome do campo
                    String fieldName = snapshot.getKey();

                    // Obtenha o valor do campo (converta conforme necessário, por exemplo, para String, Integer, etc.)
                    String fieldValue = snapshot.getValue(String.class);

                    // Faça algo com o nome e o valor do campo
                    String nota = "titulo: "+fieldName+" Conteudo: "+fieldValue;
                    notalist.add(nota);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        criarnotas = findViewById(R.id.btnirtelanota);
        criarnotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), activity_notas_view.class);
                startActivity(it);
            }
        });
    }
}
