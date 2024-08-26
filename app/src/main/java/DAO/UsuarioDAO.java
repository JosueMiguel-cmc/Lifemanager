package DAO;

import com.google.firebase.auth.FirebaseAuth;

public class UsuarioDAO {
    FirebaseAuth User;
    public void LogautUser(){
        if (User != null)
        User.getCurrentUser();
        User.signOut();
    }

}
