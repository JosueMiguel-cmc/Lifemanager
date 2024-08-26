package com.example.lifemanager.VIEW;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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
    EditText conteudo;
    EditText titulo;
    ImageButton criarnota;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_view);
    conteudo = findViewById(R.id.areaconteudoNota);
    titulo = findViewById(R.id.areatituloNota);
    criarnota = findViewById(R.id.btn_nota_salvar);

    criarnota.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            HashMap<String,Object> Notas = new HashMap<>();
            Notas.put("Titulo",titulo.getText().toString());
            Notas.put("conteudo",conteudo.getText().toString());


            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference dataNotas = database.getReference("Notas");
            String iduser = user.getUid();
            String id = dataNotas.push().getKey();
            Notas.put("id_nota",id);
            Notas.put("id_user",iduser);

            dataNotas.child(id).setValue(Notas).addOnCompleteListener(Task ->{
                if(Task.isSuccessful()){
                    Snackbar sna = Snackbar.make(findViewById(R.id.btn_nota_salvar),"cadastrado com sucesso!",Snackbar.LENGTH_SHORT);
                    sna.setBackgroundTint(Color.GREEN);
                    sna.setTextColor(Color.WHITE);
                    sna.show();
                }
            });


        }
    });

    }
}