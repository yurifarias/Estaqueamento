package com.example.yurifarias.estaqueamento.auxiliares;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yurifarias.estaqueamento.activities.CaracteristicasEstacasActivity;
import com.example.yurifarias.estaqueamento.activities.MainActivity;
import com.example.yurifarias.estaqueamento.R;

import Jama.Matrix;

public class CaracteristicasEstacasAuxiliar {

    private EditText campoDiametroEstacas;
    private EditText campoComprimentoEstacas;
    private Spinner spinnerFckConcreto;

    private String[] tiposFck = {"", "C20", "C25", "C30", "C35", "C40", "C45", "C50"};

    public CaracteristicasEstacasAuxiliar(CaracteristicasEstacasActivity activity) {

        campoDiametroEstacas = (EditText) activity.findViewById(R.id.diametroEstacas_editText);
        campoComprimentoEstacas = (EditText) activity.findViewById(R.id.comprimentoEstacas_editText);
        spinnerFckConcreto = (Spinner) activity.findViewById(R.id.fck_spinner);

    }

    public void checarValores() {

        if (String.valueOf(MainActivity.diametroEstacas).equals("0.0")) {

            campoDiametroEstacas.setText("");

        } else {

            campoDiametroEstacas.setText(String.valueOf(MainActivity.diametroEstacas));
        }

        if (String.valueOf(MainActivity.comprimentoEstacas).equals("0.0")) {

            campoComprimentoEstacas.setText("");

        } else {

            campoComprimentoEstacas.setText(String.valueOf(MainActivity.comprimentoEstacas));
        }

        if (String.valueOf(MainActivity.itemFckConcreto).equals("0") || String.valueOf(MainActivity.itemFckConcreto).equals("null")) {

            spinnerFckConcreto.setSelection(MainActivity.itemFckConcreto);

        } else {

            spinnerFckConcreto.setSelection(MainActivity.itemFckConcreto);
        }
    }

    public void salvarDados(CaracteristicasEstacasActivity activity) {

        try {

            MainActivity.diametroEstacas = Double.parseDouble(campoDiametroEstacas.getText().toString());
            MainActivity.comprimentoEstacas = Double.parseDouble(campoComprimentoEstacas.getText().toString());
            MainActivity.itemFckConcreto = spinnerFckConcreto.getSelectedItemPosition();

            determinarFckConcreto();

            activity.finish();

        } catch (Exception e) {
            Toast.makeText(activity, "INSIRA TODOS OS DADOS.", Toast.LENGTH_LONG).show();
        }
    }

    public void cancelar(CaracteristicasEstacasActivity activity) {

        if (MainActivity.diametroEstacas == 0 && MainActivity.comprimentoEstacas == 0 &&
                MainActivity.itemFckConcreto == 0 || String.valueOf(MainActivity.itemFckConcreto).equals("null")) {

            Toast.makeText(activity, "NADA FOI SALVO.", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(activity, "NADA FOI ALTERADO.", Toast.LENGTH_SHORT).show();
        }

        activity.finish();
    }

    public ArrayAdapter adapter(CaracteristicasEstacasActivity activity) {

        return new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, tiposFck);
    }

    private void determinarFckConcreto() {

        switch (MainActivity.itemFckConcreto) {
            case 0:

                MainActivity.modElasticidade = 21 * Math.pow(10, 9);
                break;

            case 1:

                MainActivity.modElasticidade = 24 * Math.pow(10, 9);
                break;

            case 2:

                MainActivity.modElasticidade = 27 * Math.pow(10, 9);
                break;

            case 3:

                MainActivity.modElasticidade = 29 * Math.pow(10, 9);
                break;

            case 4:

                MainActivity.modElasticidade = 32 * Math.pow(10, 9);
                break;

            case 5:

                MainActivity.modElasticidade = 34 * Math.pow(10, 9);
                break;

            case 6:

                MainActivity.modElasticidade = 37 * Math.pow(10, 9);
                break;
        }
    }
}