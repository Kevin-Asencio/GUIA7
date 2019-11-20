package com.example.practicaparcial_rc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import  static com.example.practicaparcial_rc.MainActivity.numero;
import static com.example.practicaparcial_rc.MainActivity.NUMERO;
import  static com.example.practicaparcial_rc.MainActivity.NAME_FILE;
import static com.example.practicaparcial_rc.MainActivity.SCORE;
import static com.example.practicaparcial_rc.MainActivity.INTENTOS;
public class Activity_Juego extends AppCompatActivity {
    Random rs;
    private Button btnIntento;
    private EditText edtNumero;
    private TextView txbIntentos;
    private int Intentos;
    SharedPreferences configuracion;
    int Puntuacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__juego);
        setTitle("A Jugar!!");
        this.rs=new Random();
        this.Puntuacion=0;
        this.Intentos=0;
        this.btnIntento=findViewById(R.id.btnIntento);
        this.edtNumero=findViewById(R.id.edtNumero);
        this.txbIntentos=findViewById(R.id.txbIntentos);
        this.configuracion=getSharedPreferences(NAME_FILE,MODE_PRIVATE);
        this.Puntuacion=configuracion.getInt(SCORE,0);
        this.Intentos=this.configuracion.getInt(INTENTOS,-1);
        this.btnIntento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edtNumero.getText().toString().isEmpty())
                {
                    Activity_Juego.this.Intentos++;
                    txbIntentos.setText(String.valueOf(Intentos));
                    if(Integer.parseInt(edtNumero.getText().toString())==numero)
                    {
                          Toast.makeText(Activity_Juego.this, "Felicidades has Ganado", Toast.LENGTH_LONG).show();
                          Activity_Juego.this.Puntuacion+=10;
                          Guardar();
                          GetNumeroAleatorio();
                        Toast.makeText(Activity_Juego.this, "Se ha generado un nuevo Nuemro!!", Toast.LENGTH_LONG).show();

                    }else
                        {
                            Toast.makeText(Activity_Juego.this, "Sigue Intentando!", Toast.LENGTH_SHORT).show();
                            Activity_Juego.this.Puntuacion-=1;
                            Guardar();
                        }

                }else
                    {
                        Toast.makeText(Activity_Juego.this, "No ha ingresado ningun valor!!", Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }

    public void Guardar()
    {
        SharedPreferences.Editor editor=this.configuracion.edit();
        editor.putInt(SCORE,this.Puntuacion);
        editor.putInt(INTENTOS,this.Intentos);
        editor.commit();
    }
    private void GetNumeroAleatorio()
    {
        numero=1+rs.nextInt(10);
        SharedPreferences.Editor editor=this.configuracion.edit();
        editor.putInt(NUMERO,numero);
        //se reinicia el contador de oportunidades para el nuevo numero
        editor.putInt(INTENTOS,0);
        editor.commit();
        this.txbIntentos.setText("0");
        this.Intentos=0;
    }
    public  void onDestroy()
    {
        super.onDestroy();
        Guardar();

    }
    public  void onPause()
    {
        super.onPause();
        Guardar();

    }
}
