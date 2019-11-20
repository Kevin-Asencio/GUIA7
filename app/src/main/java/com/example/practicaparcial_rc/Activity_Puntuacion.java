package com.example.practicaparcial_rc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import  static com.example.practicaparcial_rc.MainActivity.numero;
import static com.example.practicaparcial_rc.MainActivity.NUMERO;
import  static com.example.practicaparcial_rc.MainActivity.NAME_FILE;
import static com.example.practicaparcial_rc.MainActivity.SCORE;
import static com.example.practicaparcial_rc.MainActivity.INTENTOS;
import static com.example.practicaparcial_rc.Agregar_User.NICK;

public class Activity_Puntuacion extends AppCompatActivity {
    TextView txbUser;
    TextView txbPuntuacion;
    TextView txbInten;
    SharedPreferences configuracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__puntuacion);
        setTitle("Puntuacion");
        this.configuracion=getSharedPreferences(NAME_FILE,MODE_PRIVATE);
        this.txbInten=findViewById(R.id.txbInten);
        this.txbUser=findViewById(R.id.txbUser);
        this.txbPuntuacion=findViewById(R.id.txbPuntuacion);
        llenar();


    }
    private void llenar()
    {
        this.txbUser.setText(this.configuracion.getString(NICK,null));
        this.txbPuntuacion.setText(String.valueOf(this.configuracion.getInt(SCORE,-1)));
        this.txbInten.setText(String.valueOf(this.configuracion.getInt(INTENTOS,-1)));

    }
}
