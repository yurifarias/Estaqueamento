package com.example.yurifarias.estaqueamento.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.yurifarias.estaqueamento.R;
import com.example.yurifarias.estaqueamento.auxiliares.CaracteristicasEstacasAuxiliar;

public class CaracteristicasEstacasActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    CaracteristicasEstacasAuxiliar auxiliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas_estacas);

        auxiliar = new CaracteristicasEstacasAuxiliar(this);

        Spinner tiposFckSpinner = (Spinner) findViewById(R.id.fck_spinner);
        tiposFckSpinner.setAdapter(auxiliar.adapter(this));
        tiposFckSpinner.setOnItemSelectedListener(this);

        Button confirmarCaracteristicasEstacasButton = (Button) findViewById(R.id.caracteristicasEstacas_confirmar_button);
        confirmarCaracteristicasEstacasButton.setOnClickListener(this);

        Button cancelarCaracteristicasEstacasButton = (Button) findViewById(R.id.caracteristicasEstacas_cancelar_button);
        cancelarCaracteristicasEstacasButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        auxiliar = new CaracteristicasEstacasAuxiliar(this);
        auxiliar.checarValores();
    }

    @Override
    public void onClick(View view) {

        auxiliar = new CaracteristicasEstacasAuxiliar(this);

        switch (view.getId()) {
            case R.id.caracteristicasEstacas_confirmar_button:
                auxiliar.salvarDados(this);
                break;

            case R.id.caracteristicasEstacas_cancelar_button:
                auxiliar.cancelar(this);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}