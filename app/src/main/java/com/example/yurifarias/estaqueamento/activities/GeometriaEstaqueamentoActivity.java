package com.example.yurifarias.estaqueamento.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.yurifarias.estaqueamento.R;
import com.example.yurifarias.estaqueamento.auxiliares.GeometriaEstaqueamentoAuxiliar;

public class GeometriaEstaqueamentoActivity extends AppCompatActivity implements View.OnClickListener {

    GeometriaEstaqueamentoAuxiliar auxiliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometria_estaqueamento);
    }

    @Override
    protected void onResume() {
        super.onResume();

        auxiliar = new GeometriaEstaqueamentoAuxiliar(this);
        auxiliar.checarValores(this);

        Button confirmarQtdEstacasButton = (Button) findViewById(R.id.confirmarQtdEstacas_geometriaEstaqueamento);
        confirmarQtdEstacasButton.setOnClickListener(this);

        Button confirmarGeometriaEstaqueamento = (Button) findViewById(R.id.confirmarGeometriaEstaqueamentoButton);
        confirmarGeometriaEstaqueamento.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        auxiliar = new GeometriaEstaqueamentoAuxiliar(this);

        switch (view.getId()) {
            case R.id.confirmarQtdEstacas_geometriaEstaqueamento:
                auxiliar.confirmarQtdEstacas(this);
                break;

            case R.id.confirmarGeometriaEstaqueamentoButton:
                auxiliar.confirmarDadosEstacas(this);
                break;
        }
    }
}