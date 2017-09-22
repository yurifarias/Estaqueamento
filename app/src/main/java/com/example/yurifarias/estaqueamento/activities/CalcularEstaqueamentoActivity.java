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

    private Matrix matrizComponentesEstacas;
    private Matrix matrizRigidez;
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
        matrizComponentesEstacas = auxiliar.getMatrizComponentesEstacas();
        matrizRigidez = auxiliar.getMatrizRigidez();
        casoSimetria = auxiliar.getCasoSimetria();

        Button reacoesNormaisButton = (Button) findViewById(R.id.reacoesNormais_button);
        reacoesNormaisButton.setOnClickListener(this);

        Button deslocamentosElasticosButton = (Button) findViewById(R.id.deslocamentosElasticos_button);
        deslocamentosElasticosButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reacoesNormais_button:

                auxiliar = new CalcularEstaqueamentoAuxiliar();
                auxiliar.calcularCaso(casoSimetria, this);

                View dialog = getLayoutInflater().inflate(R.layout.dialog_esforcos_normais, null);
                final Dialog reacoesNormaisDialog = new Dialog(this);
                reacoesNormaisDialog.setContentView(dialog);

                final ListView listView = dialog.findViewById(R.id.lv_dialog_estacaReacao);
                final String[] reacoesNormais = new String[MainActivity.qtdEstacas];

                double[][] normais = MainActivity.reacoesNormais.getArray();

                for (int i = 0; i < MainActivity.qtdEstacas; i++) {
                    reacoesNormais[i] = "Estaca " + (1 + i) + ": " + normais[i][0];
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, reacoesNormais);
                listView.setAdapter(adapter);

                reacoesNormaisDialog.show();

                break;

            case R.id.deslocamentosElasticos_button:

                break;
        }
    }
}