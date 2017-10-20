package com.example.yurifarias.estaqueamento.auxiliares;

import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yurifarias.estaqueamento.activities.EsforcosExternosActivity;
import com.example.yurifarias.estaqueamento.activities.MainActivity;
import com.example.yurifarias.estaqueamento.R;

public class EsforcosExternosAuxiliar {

    private EditText campoEsforcoFx;
    private EditText campoEsforcoFy;
    private EditText campoEsforcoFz;
    private EditText campoEsforcoFa;
    private EditText campoEsforcoFb;
    private EditText campoEsforcoFc;

    public EsforcosExternosAuxiliar(EsforcosExternosActivity activity) {

        campoEsforcoFx = (EditText) activity.findViewById(R.id.fx_editText);
        campoEsforcoFy = (EditText) activity.findViewById(R.id.fy_editText);
        campoEsforcoFz = (EditText) activity.findViewById(R.id.fz_editText);
        campoEsforcoFa = (EditText) activity.findViewById(R.id.fa_editText);
        campoEsforcoFb = (EditText) activity.findViewById(R.id.fb_editText);
        campoEsforcoFc = (EditText) activity.findViewById(R.id.fc_editText);
    }

    public void checarValores() {

        if (String.valueOf(MainActivity.esforcoFx).equals("0.0")) {
            campoEsforcoFx.setText("0");
        } else {
            campoEsforcoFx.setText(String.valueOf(MainActivity.esforcoFx / 1000));
        }

        if (String.valueOf(MainActivity.esforcoFy).equals("0.0")) {
            campoEsforcoFy.setText("0");
        } else {
            campoEsforcoFy.setText(String.valueOf(MainActivity.esforcoFy / 1000));
        }

        if (String.valueOf(MainActivity.esforcoFz).equals("0.0")) {
            campoEsforcoFz.setText("0");
        } else {
            campoEsforcoFz.setText(String.valueOf(MainActivity.esforcoFz / 1000));
        }

        if (String.valueOf(MainActivity.esforcoFa).equals("0.0")) {
            campoEsforcoFa.setText("0");
        } else {
            campoEsforcoFa.setText(String.valueOf(MainActivity.esforcoFa / 1000));
        }

        if (String.valueOf(MainActivity.esforcoFb).equals("0.0")) {
            campoEsforcoFb.setText("0");
        } else {
            campoEsforcoFb.setText(String.valueOf(MainActivity.esforcoFb / 1000));
        }

        if (String.valueOf(MainActivity.esforcoFc).equals("0.0")) {
            campoEsforcoFc.setText("0");
        } else {
            campoEsforcoFc.setText(String.valueOf(MainActivity.esforcoFc / 1000));
        }
    }

    public void salvarDados(EsforcosExternosActivity activity) {

        try {
            MainActivity.esforcoFx = 1000 * Double.parseDouble(campoEsforcoFx.getText().toString());
            MainActivity.esforcoFy = 1000 * Double.parseDouble(campoEsforcoFy.getText().toString());
            MainActivity.esforcoFz = 1000 * Double.parseDouble(campoEsforcoFz.getText().toString());
            MainActivity.esforcoFa = 1000 * Double.parseDouble(campoEsforcoFa.getText().toString());
            MainActivity.esforcoFb = 1000 * Double.parseDouble(campoEsforcoFb.getText().toString());
            MainActivity.esforcoFc = 1000 * Double.parseDouble(campoEsforcoFc.getText().toString());

            Toast.makeText(activity, "ESFORÇOS SALVOS.", Toast.LENGTH_SHORT).show();

            activity.finish();

        } catch (Exception e) {

            if (campoEsforcoFx.getText().toString().equals("")) {
                MainActivity.esforcoFx = 0;
            }

            if (campoEsforcoFy.getText().toString().equals("")) {
                MainActivity.esforcoFy = 0;
            }

            if (campoEsforcoFz.getText().toString().equals("")) {
                MainActivity.esforcoFz = 0;
            }

            if (campoEsforcoFa.getText().toString().equals("")) {
                MainActivity.esforcoFa = 0;
            }

            if (campoEsforcoFb.getText().toString().equals("")) {
                MainActivity.esforcoFb = 0;
            }

            if (campoEsforcoFc.getText().toString().equals("")) {
                MainActivity.esforcoFc = 0;
            }

            Toast toast = Toast.makeText(activity, "ESFORÇOS SALVOS." + "\nESFORÇOS NÃO INSERIDOS SERÃO DEFINIDOS COMO 0.", Toast.LENGTH_LONG);
            LinearLayout layout = (LinearLayout) toast.getView();
            if (layout.getChildCount() > 0) {
                TextView textView = (TextView) layout.getChildAt(0);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
            }
            toast.show();

            activity.finish();
        }
    }

    public void cancelar(EsforcosExternosActivity activity) {

        if (MainActivity.esforcoFx == 0 || MainActivity.esforcoFy == 0 || MainActivity.esforcoFz == 0 ||
                MainActivity.esforcoFa == 0 || MainActivity.esforcoFb == 0 || MainActivity.esforcoFc == 0) {

            Toast.makeText(activity, "NADA FOI SALVO.", Toast.LENGTH_SHORT).show();
            activity.finish();
        } else {

            Toast.makeText(activity, "NEUNHUM ESFORÇO FOI ALTERADO.", Toast.LENGTH_SHORT).show();
            activity.finish();
        }
    }
}