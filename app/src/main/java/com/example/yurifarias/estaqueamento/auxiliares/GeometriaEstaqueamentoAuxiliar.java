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

        if (String.valueOf(MainActivity.qtdEstacas).equals("0")) {

            quantidadeEstacasEditText.setText("");

        } else {

            quantidadeEstacasEditText.setText(String.valueOf(MainActivity.qtdEstacas));
            criaFormularioEstacas(activity);

            try {

                for (int i = 0; i < MainActivity.qtdEstacas; i++) {
                    ((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.pos_y)).setText(String.valueOf(MainActivity.estaqueamento[i].getPosX()));
                    ((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.pos_z)).setText(String.valueOf(MainActivity.estaqueamento[i].getPosY()));
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

            confirmarEstacas(activity, MainActivity.qtdEstacas);

        } catch (Exception e) {
            Toast.makeText(activity, "INSIRA O NÚMERO DE ESTACAS DO SEU ESTAQUEAMENTO.", Toast.LENGTH_LONG).show();
        }
    }

    public void confirmarDadosEstacas(GeometriaEstaqueamentoActivity activity) {

        MainActivity.estaqueamento = new Estacas[MainActivity.qtdEstacas];

        try {
            if (MainActivity.qtdEstacas > 0) {
                for (int i = 0; i < MainActivity.qtdEstacas; i++) {
                    MainActivity.estaqueamento[i] = new Estacas(
                            Double.parseDouble(posXEditText.getText().toString()),
                            Double.parseDouble((((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.pos_y)).getText().toString())),
                            Double.parseDouble((((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.pos_z)).getText().toString())),
                            Double.parseDouble((((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.ang_crav)).getText().toString())),
                            Double.parseDouble((((EditText) MainActivity.viewsEstacas[i].findViewById(R.id.ang_proj)).getText().toString())));
                }
            }

            activity.finish();

        } catch (Exception e) {

            Toast.makeText(activity, "INSIRA TODAS INFORMAÇÕES.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void confirmarEstacas(GeometriaEstaqueamentoActivity activity, int qtdEstacas) {

        if (qtdEstacas <= 0) {

            Toast.makeText(activity, "INSIRA UMA ESTACA OU MAIS", Toast.LENGTH_SHORT).show();
        } else if (qtdEstacas == 1) {

            // criar um formulário para uma estaca com todos os dados já definidos
            // e enviar uma mensagem dizendo que não pode editar uma só estaca,
            // Y = 0, Z = 0, alpha = 0, omega = 0.
            criaFormularioEstacas(activity);
            Toast.makeText(activity, "ESTAQUEAMENTO COM UMA ESTACA NÃO PODERÁ SER EDITADA PARA NÃO CRIAR INSTABILIDADES.", Toast.LENGTH_LONG).show();
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