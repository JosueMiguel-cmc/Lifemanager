package com.example.lifemanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

import VO.NotasAdapter;
import VO.NotasOBJ;

public class Areanotas extends AppCompatActivity {
    ListView listaviewnotas;
    NotasAdapter notasadapter;
    List<NotasOBJ> notalist;
    DatabaseReference databasenotes;
    Button criarnotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areanotas);

        listaviewnotas = findViewById(R.id.Listviewnotas);
        notalist = new ArrayList<>();
        notasadapter = new NotasAdapter(this, notalist);
        listaviewnotas.setAdapter(notasadapter);

        String iduser = FirebaseAuth.getInstance().getUid();
        databasenotes = FirebaseDatabase.getInstance().getReference("Notas").child(iduser);
        databasenotes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                notalist.clear();
                for (DataSnapshot noteSnapshot : dataSnapshot.getChildren()) {
                    NotasOBJ note = noteSnapshot.getValue(NotasOBJ.class);
                    notalist.add(note);
                }
                notasadapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Areanotas", "Database error: " + databaseError.getMessage());
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
