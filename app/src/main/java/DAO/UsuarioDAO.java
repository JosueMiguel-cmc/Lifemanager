package DAO;

import com.google.firebase.auth.FirebaseAuth;

public class UsuarioDAO {
    FirebaseAuth User = FirebaseAuth.getInstance();
    public void LogautUser() {
            User.signOut();

    }
}
