package com.example.yurifarias.estaqueamento.auxiliares;

import android.widget.EditText;
import android.widget.Toast;

import com.example.yurifarias.estaqueamento.activities.CaracteristicasEstacasActivity;
import com.example.yurifarias.estaqueamento.activities.MainActivity;
import com.example.yurifarias.estaqueamento.R;

public class CaracteristicasEstacasAuxiliar {

    private EditText campoDiametroEstacas;
    private EditText campoComprimentoEstacas;
    private EditText campoFckConcreto;

    public CaracteristicasEstacasAuxiliar(CaracteristicasEstacasActivity activity) {

        campoDiametroEstacas = (EditText) activity.findViewById(R.id.diametroEstacas_editText);
        campoComprimentoEstacas = (EditText) activity.findViewById(R.id.comprimentoEstacas_editText);
        campoFckConcreto = (EditText) activity.findViewById(R.id.fckConcreto_editText);

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

        if (String.valueOf(MainActivity.fckConcreto).equals("0.0")) {
            campoFckConcreto.setText("");
        } else {
            campoFckConcreto.setText(String.valueOf(MainActivity.fckConcreto));
        }
    }

    public void salvarDados(CaracteristicasEstacasActivity activity) {

        try {
            MainActivity.diametroEstacas = Double.parseDouble(campoDiametroEstacas.getText().toString());
            MainActivity.comprimentoEstacas = Double.parseDouble(campoComprimentoEstacas.getText().toString());
            MainActivity.fckConcreto = Double.parseDouble(campoFckConcreto.getText().toString());

            activity.finish();

        } catch (Exception e) {
            Toast.makeText(activity, "INSIRA TODOS OS DADOS.", Toast.LENGTH_LONG).show();
        }
    }

    public void cancelar(CaracteristicasEstacasActivity activity) {

        if (MainActivity.diametroEstacas == 0 && MainActivity.comprimentoEstacas == 0 && MainActivity.fckConcreto == 0) {

            Toast.makeText(activity, "NADA FOI SALVO.", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(activity, "NADA FOI ALTERADO.", Toast.LENGTH_SHORT).show();
        }

        activity.finish();
    }
}