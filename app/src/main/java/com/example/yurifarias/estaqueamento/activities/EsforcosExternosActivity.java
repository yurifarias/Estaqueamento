package com.example.yurifarias.estaqueamento.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.yurifarias.estaqueamento.R;
import com.example.yurifarias.estaqueamento.auxiliares.EsforcosExternosAuxiliar;

public class EsforcosExternosActivity extends AppCompatActivity implements View.OnClickListener {

    EsforcosExternosAuxiliar auxiliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esforcos_externos);
    }

    @Override
    protected void onResume() {
        super.onResume();

        auxiliar = new EsforcosExternosAuxiliar(this);
        auxiliar.checarValores();

        Button confirmarEsforcosExternosButton = (Button) findViewById(R.id.esforcosExternos_confirmar_button);
        confirmarEsforcosExternosButton.setOnClickListener(this);

        Button cancelarEsforcosExternosButton = (Button) findViewById(R.id.esforcosExternos_cancelar_button);
        cancelarEsforcosExternosButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        auxiliar = new EsforcosExternosAuxiliar(EsforcosExternosActivity.this);

        switch (view.getId()) {
            case R.id.esforcosExternos_confirmar_button:
                auxiliar.salvarDados(EsforcosExternosActivity.this);
                break;

            case R.id.esforcosExternos_cancelar_button:
                auxiliar.cancelar(this);
                break;
        }

    }

}