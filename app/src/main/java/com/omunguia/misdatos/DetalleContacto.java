package com.omunguia.misdatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        iniBtnEditar();
    }



    public void iniBtnEditar(){

        //recuperar datos
        Bundle bundle = getIntent().getExtras();

        String nombre = bundle.getString("nombre");
        String fecha =  bundle.getString("fecha");
        String telefono =  bundle.getString("telefono");
        String email =  bundle.getString("email");
        String direccion =  bundle.getString("direccion");

        //Log.i("#Reciviendo datos DetallesContacto",nombre);
        TextView tvNombre = (TextView)findViewById(R.id.tvNombre);
        TextView tvFecha = (TextView)findViewById(R.id.tvFecha);
        TextView tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView)findViewById(R.id.tvEmail);
        TextView tvDireView = (TextView)findViewById(R.id.tvDireccion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDireView.setText(direccion);

        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); //manda a traer a la actividad anterior que era la de editar datos
                //Intent intEditarContacto = new Intent(DetalleContacto.this,MainActivity.class);
                //startActivity(intEditarContacto);
                finish(); //Finaliza la actividad
            }
        });


    }
}
