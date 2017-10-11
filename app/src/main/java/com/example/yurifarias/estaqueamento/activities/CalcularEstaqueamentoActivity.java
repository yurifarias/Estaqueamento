package com.example.yurifarias.estaqueamento.activities;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.yurifarias.estaqueamento.R;
import com.example.yurifarias.estaqueamento.auxiliares.CalcularEstaqueamentoAuxiliar;

import Jama.Matrix;

public class CalcularEstaqueamentoActivity extends AppCompatActivity implements View.OnClickListener {

    CalcularEstaqueamentoAuxiliar auxiliar;

    private char casoSimetria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_estaqueamento);
    }

    @Override
    protected void onResume() {
        super.onResume();

        auxiliar = new CalcularEstaqueamentoAuxiliar();
        casoSimetria = auxiliar.getCasoSimetria();

        Button reacoesNormaisButton = (Button) findViewById(R.id.reacoesNormais_button);
        reacoesNormaisButton.setOnClickListener(this);

        Button deslocamentosElasticosButton = (Button) findViewById(R.id.deslocamentosElasticos_button);
        deslocamentosElasticosButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        auxiliar = new CalcularEstaqueamentoAuxiliar();

        auxiliar.calcularCaso(casoSimetria, this);

        switch (view.getId()) {
            case R.id.reacoesNormais_button:

                auxiliar.mostrarReacoesNormais(this);

                break;

            case R.id.deslocamentosElasticos_button:

                auxiliar.mostrarMovimentoElastico(this);

                break;
        }
    }
}