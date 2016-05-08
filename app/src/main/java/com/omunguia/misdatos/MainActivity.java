package com.omunguia.misdatos;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verDetalleContacto();
    }

    public void verDetalleContacto(){
        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNombre = (EditText) findViewById(R.id.etNombre);
                DatePicker dpFecha = (DatePicker) findViewById(R.id.dpFechaNacimiento);
                EditText etTelefono = (EditText) findViewById(R.id.etTelefono);
                EditText etEmail = (EditText) findViewById(R.id.etEmail);
                EditText etDireccion = (EditText) findViewById(R.id.etDireccionContacto);

                //Log.i("#Datos","Nombre:" + etNombre.getText().toString());

                Intent intDetallesContacto = new Intent(MainActivity.this,DetalleContacto.class); //declara una actividad

                intDetallesContacto.putExtra("nombre", etNombre.getText().toString());
                String fecha =  String.valueOf(dpFecha.getYear()) +"-" + String.valueOf(dpFecha.getMonth() + 1) + "-" + String.valueOf(dpFecha.getDayOfMonth());
                intDetallesContacto.putExtra("fecha", fecha);
                intDetallesContacto.putExtra("telefono", etTelefono.getText().toString());
                intDetallesContacto.putExtra("email", etEmail.getText().toString());
                intDetallesContacto.putExtra("direccion", etDireccion.getText().toString());


                //Snackbar.make(v,fecha,Snackbar.LENGTH_SHORT).show();
                startActivity(intDetallesContacto); //carga una nueva actividad en la pila

                //finish(); //para finalizar la actividad
            }
        });
    }
}
