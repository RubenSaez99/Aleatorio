package com.ruben.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityAleatorios extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    RadioGroup grupoRadios;
    RadioButton sinRango, conRango;
    EditText numeroMinimo, numeroMaximo, numeroDecimales, numerosTotales;
    CheckBox permitirDecimales;
    Switch repetirNumeros;
    ImageButton btnCohete;
    ArrayList numerosUsados;
    TextView etiqueta;
    int max, min;
    double generado;
    boolean rango, repetir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorios);
        instancias();
        acciones();
    }

    private void acciones() {
        grupoRadios.setOnCheckedChangeListener(this);
        sinRango.setOnCheckedChangeListener(this);
        conRango.setOnCheckedChangeListener(this);
        btnCohete.setOnClickListener(this);
        repetirNumeros.setOnCheckedChangeListener(this);
        permitirDecimales.setOnCheckedChangeListener(this);
    }

    private void instancias() {
        grupoRadios = findViewById(R.id.grupoRadios);
        sinRango = findViewById(R.id.sinRango);
        conRango = findViewById(R.id.conRango);
        numeroMinimo = findViewById(R.id.numeroMinimo);
        numeroMinimo.setEnabled(false);
        numeroMaximo = findViewById(R.id.numeroMaximo);
        numeroMaximo.setEnabled(false);
        numeroDecimales = findViewById(R.id.numeroDecimales);
        numeroDecimales.setEnabled(false);
        numerosTotales = findViewById(R.id.numeroTotales);
        permitirDecimales = findViewById(R.id.permitirDecimales);
        repetirNumeros = findViewById(R.id.switchRepetirNumeros);
        btnCohete = findViewById(R.id.btnCohete);
        etiqueta = findViewById(R.id.etiqueta);
        numerosUsados = new ArrayList<Double>();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getCheckedRadioButtonId()) {
            case R.id.sinRango:
                rango = false;
                numeroMinimo.setEnabled(false);
                numeroMaximo.setEnabled(false);
                break;
            case R.id.conRango:
                rango = true;
                numeroMinimo.setEnabled(true);
                numeroMaximo.setEnabled(true);
                break;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.permitirDecimales:
                if (permitirDecimales.isChecked())
                    numeroDecimales.setEnabled(true);
                else
                    numeroDecimales.setEnabled(false);
                break;
            case R.id.switchRepetirNumeros:
                if (repetirNumeros.isChecked())
                    repetir = true;
                else
                    repetir = false;
                break;
        }

    }

    public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCohete:
                etiqueta.setText("");
                numerosUsados.clear();
                if (rango) {
                    max = Integer.valueOf(numeroMaximo.getText().toString());
                    min = Integer.valueOf(numeroMinimo.getText().toString());
                    if (permitirDecimales.isChecked()) {
                        for (int i = 0; i < Integer.valueOf(numerosTotales.getText().toString()); i++) {
                            if (!repetir) {
                                do {
                                    generado = formatearDecimales((Math.random() * (max - min) + min), Integer.valueOf(numeroDecimales.getText().toString()));
                                } while (numerosUsados.contains(generado));
                            } else {
                                generado = formatearDecimales((Math.random() * (max - min) + min), Integer.valueOf(numeroDecimales.getText().toString()));
                            }
                            numerosUsados.add(generado);
                            etiqueta.setText(etiqueta.getText() + "\n" + (generado));
                        }
                    } else {
                        for (int i = 0; i < Integer.valueOf(numerosTotales.getText().toString()); i++) {
                            if (!repetir) {
                                do {
                                    generado = formatearDecimales((Math.random() * (max - min) + min), 0);
                                } while (numerosUsados.contains(generado));
                            } else {
                                generado = formatearDecimales((Math.random() * (max - min) + min), 0);
                            }
                            numerosUsados.add(generado);
                            etiqueta.setText(etiqueta.getText() + "\n" + (generado));
                        }
                    }
                } else {
                    if (permitirDecimales.isChecked()) {
                        for (int i = 0; i < Integer.valueOf(numerosTotales.getText().toString()); i++) {
                            if (!repetir) {
                                do {
                                    generado = formatearDecimales((Math.random() * 1000), Integer.valueOf(numeroDecimales.getText().toString()));
                                } while (numerosUsados.contains(generado));
                            } else {
                                generado = formatearDecimales((Math.random() * 1000), Integer.valueOf(numeroDecimales.getText().toString()));
                            }
                            numerosUsados.add(generado);
                            etiqueta.setText(etiqueta.getText() + "\n" + (generado));
                        }
                    } else {
                        for (int i = 0; i < Integer.valueOf(numerosTotales.getText().toString()); i++) {
                            if (!repetir) {
                                do {
                                    generado = formatearDecimales((Math.random() * 1000), 0);
                                } while (numerosUsados.contains(generado));
                            } else {
                                generado = formatearDecimales((Math.random() * 1000), 0);
                            }
                            numerosUsados.add(generado);
                            etiqueta.setText(etiqueta.getText() + "\n" + (generado));
                        }
                    }
                }
                System.out.println(numerosUsados);
                System.out.println(repetir);
                break;
        }
    }
}
