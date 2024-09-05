package com.example.lifemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lifemanager.VIEW.activity_notas_view;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import VO.NotasAdapter;
import VO.NotasOBJ;
public class MinhasNotasView extends AppCompatActivity {
    ImageButton btncriarnota;
    ListView listviewnotas;
    NotasAdapter notasAdapter;
    ArrayList<NotasOBJ> arrayListNOBJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_notas_view);


        arrayListNOBJ = new ArrayList<>();
        listviewnotas = findViewById(R.id.ListViewNotas); // Certifique-se de inicializar listviewnotas aqui


        inicializarnotas();


        btncriarnota = findViewById(R.id.btncriar);
        btncriarnota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), activity_notas_view.class);
                startActivity(it);
            }
        });
    }

    public void inicializarnotas() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Notas");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();


        if (userId != null) {
            reference.orderByChild("id_user").equalTo(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    arrayListNOBJ.clear(); // Limpa a lista antes de adicionar novas notas
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        NotasOBJ nota = snapshot.getValue(NotasOBJ.class);
                        if (nota != null) {
                            arrayListNOBJ.add(nota);
                        }
                    }

                    notasAdapter = new NotasAdapter(MinhasNotasView.this, arrayListNOBJ);
                    listviewnotas.setAdapter(notasAdapter);
                    notasAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
