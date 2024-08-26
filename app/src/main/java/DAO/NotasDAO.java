package DAO;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import VO.NotasOBJ;

public class NotasDAO {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    //area para criar notas
    public void NotasCreateDAO(String id_user,String nome_nota,String conteudo_nota){

        NotasOBJ nota = new NotasOBJ(id_user,nome_nota,conteudo_nota,new Date());
        // Adicionando a nota ao Firestore
        db.collection("Notas")
                .add(nota)
                .addOnSuccessListener(documentReference -> {
                    // Sucesso ao adicionar a nota
                    Log.d("Firestore", "Nota adicionada com ID: " + documentReference.getId());
                })
                .addOnFailureListener(e -> {
                    // Falha ao adicionar a nota
                    Log.w("Firestore", "Erro ao adicionar a nota", e);
                });
    }

    public List<NotasOBJ> NotasreturnDAO(String id){
        List<NotasOBJ> Notas = new ArrayList<>();

        db.collection("Notas").whereEqualTo("userId",id).get().addOnCompleteListener( task -> {
            if (task.isSuccessful()){
                for(QueryDocumentSnapshot document : task.getResult()){
                    NotasOBJ nota = document.toObject(NotasOBJ.class);
                    Notas.add(nota);

                }
            }


        });
        return Notas;
    }


}
