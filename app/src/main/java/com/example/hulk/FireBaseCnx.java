package com.example.hulk;

import com.google.firebase.firestore.FirebaseFirestore;

//Conexion con FireBase
public class FireBaseCnx {
    public FirebaseFirestore getConnection(){
        return FirebaseFirestore.getInstance();
    }
}



