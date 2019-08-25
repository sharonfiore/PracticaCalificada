package com.example.practicalaboratoriosharon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText palabra1;
    private EditText palabra2;

    public String respuesta;
    public String respuesta2;
    public static String EXTRA_MENSAJE ="Resultado";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_enviar = (Button) findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int contador=0;

                palabra1 = (EditText) findViewById(R.id.txt_palabra1);
                //palabra2 = (EditText) findViewById(R.id.txt_palabra2);


                String p1 = palabra1.getText().toString();

                /*String p2 = palabra2.getText().toString();


                if(p1.equals(p2)){
                    respuesta = "• Las dos palabras son iguales \n";
                }
                else {
                    respuesta = "• La palabras " + p1+" y "+p2+" son diferentes \n";
                }

                for(int x=0;x<p1.length();x++) {
                    if ( (p1.charAt(x)=='i') || (p1.charAt(x)=='u') || (p1.charAt(x)=='I') || (p1.charAt(x)=='U')){
                        contador++;
                    }
                }

                for(int x=0;x<p2.length();x++) {
                    if ( (p2.charAt(x)=='i') || (p2.charAt(x)=='u') || (p2.charAt(x)=='I') || (p2.charAt(x)=='U')){
                        contador++;
                    }
                }*/

                /*****************************************************/
                String separadores = "[\\ \\, \\.]";
                String[] arreglo = p1.split(separadores);

                for(int i=0;i<arreglo.length;i++){
                    String palabra = arreglo[i];

                    for(int x=0;x<palabra.length();x++) {
                        if ( (palabra.charAt(x)=='i') || (palabra.charAt(x)=='u') || (palabra.charAt(x)=='I') || (palabra.charAt(x)=='U')){
                            contador++;
                        }
                    }

                    if (i != 0) {
                        for (int z = 0; z < i; z++) {
                            if (arreglo[i].equals(arreglo[z])) {
                                respuesta = "• Las palabras son iguales. \n";
                            } else {
                                respuesta = "• La palabras son diferentes. \n";
                            }
                        }
                    }
                }


                String mensaje = respuesta+"\n"+ "• Cantidad de vocales cerradas (i,u) son: "+contador;
                Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);
                intent.putExtra(EXTRA_MENSAJE, mensaje);
                startActivity(intent);
            }
        });
    }
}
