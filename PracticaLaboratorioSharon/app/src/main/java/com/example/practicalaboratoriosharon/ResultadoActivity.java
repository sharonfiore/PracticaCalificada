package com.example.practicalaboratoriosharon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tv1 = (TextView)findViewById(R.id.txt_resultado1);

        String resultado = getIntent().getStringExtra(MainActivity.EXTRA_MENSAJE);
        tv1.setText("RESULTADO: \n \n"+ resultado);

    }
}
