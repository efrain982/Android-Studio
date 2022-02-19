package com.example.hulk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText telefono;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time time = new time();
        time.execute();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void hello()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ejecutar()
    {
        time time = new time();
        time.execute();
    }

    public class time extends AsyncTask<Void,Integer,Boolean>
    {
        @Override
        protected Boolean doInBackground(Void... voids) {
            for (int i=1; i<=4; i++)
            {
                hello();
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            ClienteFB clienteFB = new ClienteFB();
            Cliente cliente = new Cliente();
//            cliente.nombre = nombre.getText().toString();
//            cliente.telefono = 10;
            MaquinaUno maquinaUno = new MaquinaUno();
            MaquinaDos maquinaDos = new MaquinaDos();
            MaquinaTres maquinaTres = new MaquinaTres();

            int min = 50;
            int max = 100;

            //Generate random int value from 50 to 100
            System.out.println("Random value in int from "+min+" to "+max+ ":");
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            System.out.println(random_int);

            cliente.temp = random_int;
            cliente.temp2 = random_int;
            cliente.temp3 = random_int;

//              Se envia el objeto al objeto para mandar los datos a FireBase
            clienteFB.save(cliente);
            maquinaUno.save(cliente);
            maquinaDos.save(cliente);
            maquinaTres.save(cliente);

            ejecutar();
            Toast.makeText(MainActivity.this, "Cada Dos Segundos", Toast.LENGTH_SHORT).show();
        }
    }
}