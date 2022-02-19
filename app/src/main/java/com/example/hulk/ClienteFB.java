package com.example.hulk;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

import java.util.HashMap;
import java.util.Map;

public class ClienteFB {

    /**
     * Metodo para enviar datos
     * @param cliente
     */
    public void save(Cliente cliente){
        Map<String, Object> clienteMap = new HashMap<>();
        clienteMap.put("nombre", cliente.nombre);
        clienteMap.put("telefono", cliente.telefono);

        new FireBaseCnx().getConnection().collection("cliente")
                .add(clienteMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
//                         Log.w(TAG, "Error adding document", e);
                    }
                });

    }
}
