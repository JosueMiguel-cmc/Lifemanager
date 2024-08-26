package com.example.lifemanager.VIEW;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lifemanager.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import javax.net.ssl.SNIHostName;

public class Cadview extends AppCompatActivity {
    TextInputEditText emailinput, senhainput;
    Button cadbtn, logbtn;
    private FirebaseAuth FBA = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (FBA.getCurrentUser() != null){
            Intent it = new Intent(getBaseContext(), PrincipalView.class);
            startActivity(it);
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadview);
       emailinput = findViewById(R.id.emailinp);
       senhainput = findViewById(R.id.senhainp);
       cadbtn = findViewById(R.id.cadastrarbtn);
       logbtn = findViewById(R.id.loginbtn);


       cadbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email = emailinput.getText().toString();
               String senha = senhainput.getText().toString();
               if (email.isEmpty() || senha.isEmpty()){
                   Snackbar sna = Snackbar.make(findViewById(R.id.cadastrarbtn),"por favor preencha todos os campos!",Snackbar.LENGTH_SHORT);
                   sna.setBackgroundTint(Color.RED);
                   sna.setTextColor(Color.WHITE);
                   sna.show();
               }else{
                   FBA.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(task -> {
                       if (task.isSuccessful()){
                           Snackbar sna = Snackbar.make(findViewById(R.id.cadastrarbtn),"cadastrado com sucesso!",Snackbar.LENGTH_SHORT);
                           sna.setBackgroundTint(Color.GREEN);
                           sna.setTextColor(Color.WHITE);
                           sna.show();

                           emailinput.setText("");
                           senhainput.setText("");
                       }
                   });

               }
           }
       });
       logbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent it = new Intent(getBaseContext(), Logview.class);
               startActivity(it);
               finish();
           }
       });

    }
}