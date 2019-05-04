package com.karla.control_venta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSesion;
    EditText txtUsuario,txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSesion=findViewById(R.id.btn_login_Iniciar_Sesion);
        txtUsuario=findViewById(R.id.txt_login_Usuario);
        txtPass=findViewById(R.id.txt_login_Contraseña);

        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtUsuario.getText().toString().isEmpty() && !txtPass.getText().toString().isEmpty()){
                    if(txtUsuario.getText().toString().equals("invitado") && txtPass.getText().toString().equals("invitado")){
                        startActivity(new Intent(MainActivity.this, Invitado.class));
                        finish();
                    }else{
                        if(txtUsuario.getText().toString().equals("admin") && txtPass.getText().toString().equals("admin")){
                            startActivity(new Intent(MainActivity.this, Administrador.class));
                            finish();
                        }
                    }
                }
            }
        });

    }
}
