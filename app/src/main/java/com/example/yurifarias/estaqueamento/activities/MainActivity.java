package com.example.yurifarias.estaqueamento.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yurifarias.estaqueamento.auxiliares.CalcularEstaqueamentoAuxiliar;
import com.example.yurifarias.estaqueamento.estacas.Estacas;
import com.example.yurifarias.estaqueamento.R;

import Jama.Matrix;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Variáveis para encontrar a rigidez das estacas.
    public static double diametroEstacas;
    public static double comprimentoEstacas;
    public static int itemFckConcreto;
    public static double modElasticidade;

    // Variáveis para os esforços externos atuantes.
    public static double esforcoFx;
    public static double esforcoFy;
    public static double esforcoFz;
    public static double esforcoFa;
    public static double esforcoFb;
    public static double esforcoFc;

    // Variáveis para geometria do estaqueamento.
    public static int qtdEstacas;
    public static double posX;
    public static Estacas[] estaqueamento;

    public static View[] viewsEstacas;

    public static Matrix reacoesNormais;
    public static double[][] movElastico;

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

                String titulo = "";
                String mensagem = "";

                LayoutInflater li = getLayoutInflater();
                View view1 = li.inflate(R.layout.alerta_dialog, null);
                TextView tv = view1.findViewById(R.id.mensagem_estaqueamento);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(view1);

                final AlertDialog alerta;

                if (String.valueOf(MainActivity.diametroEstacas).equals("0.0") || String.valueOf(MainActivity.diametroEstacas).equals("null")
                        || String.valueOf(MainActivity.comprimentoEstacas).equals("0.0") || String.valueOf(MainActivity.comprimentoEstacas).equals("null")
                        || String.valueOf(MainActivity.itemFckConcreto).equals("0") || String.valueOf(MainActivity.itemFckConcreto).equals("null")
                        || String.valueOf(MainActivity.esforcoFx).equals("null") || String.valueOf(MainActivity.esforcoFy).equals("null")
                        || String.valueOf(MainActivity.esforcoFz).equals("null") || String.valueOf(MainActivity.esforcoFa).equals("null")
                        || String.valueOf(MainActivity.esforcoFb).equals("null") || String.valueOf(MainActivity.esforcoFc).equals("null")
                        || String.valueOf(MainActivity.qtdEstacas).equals("0") || String.valueOf(MainActivity.qtdEstacas).equals("null")
                        || String.valueOf(MainActivity.posX).equals("0.0") || String.valueOf(MainActivity.posX).equals("null")
                        || String.valueOf(MainActivity.estaqueamento.length).equals("0") || String.valueOf(MainActivity.estaqueamento.length).equals("null")) {

                    titulo = "ERRO!";
                    mensagem = "REVEJA DADOS DE ENTRADA.";

                    tv.setText(mensagem);
                    builder.setTitle(titulo);
                    alerta = builder.create();

                    alerta.show();

                    view1.findViewById(R.id.mensagem_retornar).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            alerta.dismiss();
                        }
                    });


                } else {

                    CalcularEstaqueamentoAuxiliar auxiliar = new CalcularEstaqueamentoAuxiliar();

                    auxiliar.checarValidade();

                    if (auxiliar.isTesteValidade()) {

                        Intent intentCalcularEstaqueamento = new Intent(MainActivity.this, CalcularEstaqueamentoActivity.class);
                        startActivity(intentCalcularEstaqueamento);

                    } else {

                        titulo = auxiliar.getTitulo();
                        mensagem = auxiliar.getMensagem();

                        tv.setText(mensagem);
                        builder.setTitle(titulo);
                        alerta = builder.create();

                        alerta.show();

                        view1.findViewById(R.id.mensagem_retornar).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                alerta.dismiss();
                            }
                        });

                    }
                }

                break;
        }
    }
}