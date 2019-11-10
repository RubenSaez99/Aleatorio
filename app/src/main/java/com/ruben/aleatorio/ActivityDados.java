package com.ruben.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityDados extends AppCompatActivity implements View.OnClickListener {
    Button tirar;
    ImageView dados;
    int[] imagenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        instancias();
        acciones();
    }

    private void acciones() {
        tirar.setOnClickListener(this);
    }

    private void instancias() {
        tirar=findViewById(R.id.btnTirarDados);
        dados=findViewById(R.id.imagnDados);
        imagenes= new int[]{R.drawable.dado_uno,R.drawable.dado_dos,R.drawable.dado_tres,R.drawable.dado_cuatro,R.drawable.dado_cinco,R.drawable.dado_seis};
    }
    @Override
    public void onClick(View v) {
        dados.setImageDrawable(getDrawable(imagenes[(int)(Math.random()*6)]));
    }
}
