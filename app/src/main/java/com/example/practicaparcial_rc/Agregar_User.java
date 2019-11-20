package com.example.practicaparcial_rc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Agregar_User extends AppCompatActivity {
    public static final String NAME_FILE = "Configuracion";
    public static final String NICK = "User";
    public static  final String DEFECTO="User_1";

    SharedPreferences configuracion;
    EditText edtNombre;
    Button btnRegistrar;
    Button btnDefecto;
    int Validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrrgar__user);
        this.edtNombre=findViewById(R.id.edtNombre);
        setTitle("Agregar Usuario :)");
        this.Validar=0;
        this.btnRegistrar=findViewById(R.id.btnRegistrar);
        this.btnDefecto=findViewById(R.id.btnDefecto);
        this.configuracion=getSharedPreferences(NAME_FILE,MODE_PRIVATE);
        this.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Agregar_User.this.edtNombre.getText().toString().isEmpty())
                {
                    Guardar();
                    finish();
                }

            }
        });
        this.btnDefecto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Establecer();
                finish();
            }
        });

    }
    public void Guardar(){
        SharedPreferences.Editor editor=this.configuracion.edit();
        editor.putString(NICK,this.edtNombre.getText().toString());
        editor.commit();
    }
    public void Establecer(){
        SharedPreferences.Editor editor=this.configuracion.edit();
        editor.putString(NICK,this.DEFECTO);
        editor.commit();
    }
}
