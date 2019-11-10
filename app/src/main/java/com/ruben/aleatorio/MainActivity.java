package com.ruben.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton dados,aleatorio,ganadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
    dados.setOnClickListener(this);
    aleatorio.setOnClickListener(this);
    ganadores.setOnClickListener(this);
    }

    private void instancias() {
    dados=findViewById(R.id.btnDados);
    aleatorio=findViewById(R.id.btnAleatorios);
    ganadores=findViewById(R.id.btnGanadores);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.btnAleatorios:
                i= new Intent(getApplicationContext(),ActivityAleatorios.class);
                startActivity(i);
                break;
            case R.id.btnGanadores:
                i= new Intent(getApplicationContext(),ActivityGanadores.class);
                startActivity(i);
                break;
            case R.id.btnDados:
                i= new Intent(getApplicationContext(),ActivityDados.class);
                startActivity(i);
                break;

        }
    }


}
