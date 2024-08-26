package DAO;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import VO.NotasOBJ;

public class NotasDAO {
    private DatabaseReference databasenotes;

    public NotasDAO() {
        String iduser = FirebaseAuth.getInstance().getUid();
        databasenotes = FirebaseDatabase.getInstance().getReference("Notas").child(iduser);
    }

    public void getNotas(final OnNotasRetrievedListener listener) {
        databasenotes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<NotasOBJ> notalist = new ArrayList<>();
                for (DataSnapshot noteSnapshot : dataSnapshot.getChildren()) {
                    NotasOBJ note = noteSnapshot.getValue(NotasOBJ.class);
                    notalist.add(note);
                }
                listener.onNotasRetrieved(notalist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Tratar erro, se necessário
                listener.onError(databaseError.toException());
            }
        });
    }

    public interface OnNotasRetrievedListener {
        void onNotasRetrieved(List<NotasOBJ> notalist);
        void onError(Exception exception);
    }
}
