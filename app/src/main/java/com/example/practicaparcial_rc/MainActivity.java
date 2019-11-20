package com.example.practicaparcial_rc;

import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Entidades.Usuario;

public class MainActivity extends AppCompatActivity {
    public static final String NAME_FILE = "Configuracion";
    public static final String NICK = "User";
    public static final String NUMERO = "NUMERO";
    public static final  String SCORE="PUNTUACION";
    public static final  String INTENTOS="Intentos";

    public static int numero;
    SharedPreferences configuracion;
     private Button btnJuego;
     private Button btnPuntuacion;
     private Button btnVer;
     int intentos;
    private Random rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Guia 7");
        this.btnJuego=findViewById(R.id.btnJuego);
        this.btnPuntuacion=findViewById(R.id.btnPuntuacion);
        intentos=0;
        this.btnVer=findViewById(R.id.btnVer);
        this.configuracion=getSharedPreferences(NAME_FILE,MODE_PRIVATE);
        this.numero=0;
        this.rs=new Random();

        //establecer intentos a 0
        if(this.configuracion.getInt(INTENTOS,-1)==-1)
        {
            SharedPreferences.Editor editor=this.configuracion.edit();
            editor.putInt(INTENTOS,0);
            editor.commit();
        }
        //establecer la puntiacion en 10
        if(this.configuracion.getInt(SCORE,-1)==-1)
        {
            SharedPreferences.Editor editor=this.configuracion.edit();
            editor.putInt(SCORE,10);
            editor.commit();
        }

        //Creacion del nuemro aleatorio si este es nulo
        if(this.configuracion.getInt(NUMERO,-1)==-1)
        {
            GetNumeroAleatorio();
        }else
        {
            this.numero=configuracion.getInt(NUMERO,-1);
        }
        // si el User es nulo se proporciona un medio para registrar el usuaio
        if(this.configuracion.getString(NICK,null)==null)
        {
            Intent intent=new Intent(this, Agregar_User.class);
            startActivity(intent);
        }else
            {
                Toast.makeText(this, "El usuario es "+this.configuracion.getString(NICK,"no hay"), Toast.LENGTH_SHORT).show();
            }
        this.btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "El Numero es "+MainActivity.this.configuracion.getInt(NUMERO,-1), Toast.LENGTH_LONG).show();
            }
        });

        this.btnPuntuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Activity_Puntuacion.class);
                startActivity(intent);
            }
        });

        this.btnJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Activity_Juego.class);
                startActivity(intent);
            }
        });

    }
    private int GetNumeroAleatorio()
    {
        this.numero=1+rs.nextInt(10);
        SharedPreferences.Editor editor=this.configuracion.edit();
        editor.putInt(NUMERO,this.numero);
        editor.commit();
        return numero;
    }
}
