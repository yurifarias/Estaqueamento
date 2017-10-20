package com.example.yurifarias.estaqueamento.auxiliares;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yurifarias.estaqueamento.estacas.Estacas;
import com.example.yurifarias.estaqueamento.activities.GeometriaEstaqueamentoActivity;
import com.example.yurifarias.estaqueamento.activities.MainActivity;
import com.example.yurifarias.estaqueamento.R;

public class GeometriaEstaqueamentoAuxiliar {

    private EditText quantidadeEstacasEditText;
    private EditText posXEditText;

    public GeometriaEstaqueamentoAuxiliar(GeometriaEstaqueamentoActivity activity) {

        quantidadeEstacasEditText = (EditText) activity.findViewById(R.id.qtdEstacasEditText_geometriaEstaqueamento);
        posXEditText = (EditText) activity.findViewById(R.id.cotaArrasamento_editText_geometriaEstaqueamento);
    }

    public void checarValores(GeometriaEstaqueamentoActivity activity) {

        if (String.valueOf(MainActivity.qtdEstacas).equals("0") && String.valueOf(MainActivity.posX).equals("0.0")) {

            quantidadeEstacasEditText.setText("");
            posXEditText.setText("");

        } else {

            quantidadeEstacasEditText.setText(String.valueOf(MainActivity.qtdEstacas));
            posXEditText.setText(String.valueOf(MainActivity.posX));

            criaFormularioEstacas(activity);

            try {

                for (int i = 0; i < MainActivity.qtdEstacas; i++) {
                    ((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.pos_y)).setText(String.valueOf(MainActivity.estaqueamento[i].getPosY()));
                    ((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.pos_z)).setText(String.valueOf(MainActivity.estaqueamento[i].getPosZ()));
                    ((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.ang_crav)).setText(String.valueOf(MainActivity.estaqueamento[i].getAngCrav()));
                    ((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.ang_proj)).setText(String.valueOf(MainActivity.estaqueamento[i].getAngProj()));
                }
            } catch (Exception e) {

            }
        }
    }

    public void confirmarQtdEstacas(GeometriaEstaqueamentoActivity activity) {

        try {
            MainActivity.qtdEstacas = Integer.parseInt(quantidadeEstacasEditText.getText().toString());
            MainActivity.posX = Double.parseDouble(posXEditText.getText().toString());

            confirmarEstacas(activity);

        } catch (Exception e) {

            Toast.makeText(activity, "INSIRA TODOS OS DADOS.", Toast.LENGTH_LONG).show();
        }
    }

    public void confirmarDadosEstacas(GeometriaEstaqueamentoActivity activity) {

        MainActivity.estaqueamento = new Estacas[MainActivity.qtdEstacas];

        try {
            if (MainActivity.qtdEstacas > 0) {
                for (int i = 0; i < MainActivity.qtdEstacas; i++) {
                    MainActivity.estaqueamento[i] = new Estacas(
                            MainActivity.posX,
                            Double.parseDouble((((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.pos_y)).getText().toString())),
                            Double.parseDouble((((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.pos_z)).getText().toString())),
                            Double.parseDouble((((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.ang_crav)).getText().toString())),
                            Double.parseDouble((((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.ang_proj)).getText().toString())));
                }
            }

            activity.finish();

        } catch (Exception e) {

            Toast.makeText(activity, "INSIRA TODAS INFORMAÇÕES PEDIDAS.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void confirmarEstacas(GeometriaEstaqueamentoActivity activity) {

        if (MainActivity.qtdEstacas <= 1) {

            Toast.makeText(activity, "INSIRA DUAS ESTACA OU MAIS", Toast.LENGTH_SHORT).show();

        } else {

            criaFormularioEstacas(activity);
        }
    }

    protected void criaFormularioEstacas(GeometriaEstaqueamentoActivity activity) {

        LinearLayout llContainer = (LinearLayout) activity.findViewById(R.id.itemEstacas_geometriaEstaqueamento);
        llContainer.removeAllViews();
        MainActivity.viewsEstacas = new View[MainActivity.qtdEstacas];

        for (int i = 0; i < MainActivity.qtdEstacas; i++) {
            MainActivity.viewsEstacas[i] = activity.getLayoutInflater().inflate(R.layout.item_estacas, null, false);
            ((TextView)MainActivity.viewsEstacas[i].findViewById(R.id.TV_indice)).setText("#" + String.valueOf(i + 1));
            llContainer.addView(MainActivity.viewsEstacas[i]);
        }
    }
}