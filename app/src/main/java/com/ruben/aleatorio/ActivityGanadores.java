package com.ruben.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ActivityGanadores extends AppCompatActivity implements View.OnClickListener {
    TextView lista;
    EditText nombre;
    Button generar, agregar;
    ArrayList participantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganadores);
        instancias();
        acciones();
    }

    private void acciones() {
        generar.setOnClickListener(this);
        agregar.setOnClickListener(this);

    }

    private void instancias() {
        lista=findViewById(R.id.lista);
        nombre=findViewById(R.id.nombre);
        generar=findViewById(R.id.generar);
        agregar=findViewById(R.id.agregar);
        participantes=new ArrayList<String>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.agregar:
                if(!nombre.getText().toString().isEmpty()) {
                    lista.setText(lista.getText() + "\n" + nombre.getText().toString());
                    participantes.add(nombre.getText().toString());
                    nombre.setText("");
                }
                break;
            case R.id.generar:
                if(!participantes.isEmpty()) {
                    lista.setText("GANADOR:\n" + participantes.get((int) (Math.random() * participantes.size())).toString());
                    participantes.clear();
                }else
                lista.setText("NO HAY PARTICIPANTES");
                break;
        }
    }
}
