package com.example.lifemanager.VIEW;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lifemanager.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class activity_notas_view extends AppCompatActivity {
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    EditText conteudo;
    EditText titulo;
    Button criarnota;
    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_view);

    conteudo = findViewById(R.id.areaconteudoNota);
    titulo = findViewById(R.id.areatituloNota);
    criarnota = findViewById(R.id.btn_nota_salvar);
    voltar = findViewById(R.id.btn_voltar);

    voltar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
    criarnota.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            HashMap<String,Object> Notas = new HashMap<>();

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference dataNotas = database.getReference("Notas");
            String iduser = user.getUid();
            String id = dataNotas.push().getKey();
            Notas.put("id_nota",id);
            Notas.put("id_user",iduser);
            Notas.put("Titulo",titulo.getText().toString());
            Notas.put("conteudo",conteudo.getText().toString());




            dataNotas.child(id).setValue(Notas).addOnCompleteListener(Task ->{
                if(Task.isSuccessful()){
                    Snackbar sna = Snackbar.make(findViewById(R.id.btn_nota_salvar),"Notas criadas com sucesso!",Snackbar.LENGTH_SHORT);
                    sna.setBackgroundTint(Color.GREEN);
                    sna.setTextColor(Color.WHITE);
                    sna.show();
                }
            });


        }
    });

    }
}