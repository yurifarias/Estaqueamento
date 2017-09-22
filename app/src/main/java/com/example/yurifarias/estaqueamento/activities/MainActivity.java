package com.example.yurifarias.estaqueamento.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.yurifarias.estaqueamento.estacas.Estacas;
import com.example.yurifarias.estaqueamento.R;

import Jama.Matrix;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static double diametroEstacas;
    public static double comprimentoEstacas;
    public static double fckConcreto;

    public static double esforcoFx;
    public static double esforcoFy;
    public static double esforcoFz;
    public static double esforcoFa;
    public static double esforcoFb;
    public static double esforcoFc;

    public static int qtdEstacas;
    public static View[] viewsEstacas;
    public static Estacas[] estaqueamento;

    public static Matrix reacoesNormais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume () {
        super.onResume();

        Button caracteristicasEstacasButton = (Button) findViewById(R.id.caracteristicasEstacas_button);
        caracteristicasEstacasButton.setOnClickListener(this);

        Button esforcosExternosButton = (Button) findViewById(R.id.esforcosExternos_button);
        esforcosExternosButton.setOnClickListener(this);

        Button geometriaEstaqueamentoButton = (Button) findViewById(R.id.geometriaEstaqueamento_button);
        geometriaEstaqueamentoButton.setOnClickListener(this);

        Button calcularEstaqueamentoButton = (Button) findViewById(R.id.calcularEstaqueamento_button);
        calcularEstaqueamentoButton.setOnClickListener(this);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.caracteristicasEstacas_button:
                Intent intentAbrirCaracteristicasEstacas = new Intent(MainActivity.this, CaracteristicasEstacasActivity.class);
                startActivity(intentAbrirCaracteristicasEstacas);
                break;

            case R.id.esforcosExternos_button:
                Intent intentAbrirEsforcosExternos = new Intent(MainActivity.this, EsforcosExternosActivity.class);
                startActivity(intentAbrirEsforcosExternos);
                break;

            case R.id.geometriaEstaqueamento_button:
                Intent intentAbrirGeometriaEstacas = new Intent(MainActivity.this, GeometriaEstaqueamentoActivity.class);
                startActivity(intentAbrirGeometriaEstacas);
                break;

            case R.id.calcularEstaqueamento_button:
                Intent intentCalcularEstaqueamento = new Intent(MainActivity.this, CalcularEstaqueamentoActivity.class);
                startActivity(intentCalcularEstaqueamento);
                break;
        }
    }
}