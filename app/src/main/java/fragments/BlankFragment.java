package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.ramonilho.demonavigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener {

    private EditText etValor1;
    private EditText etValor2;

    private Button btnSomar, btnSubtrair, btnMultiplicar, btnDividir;

    private TextView tvResultado;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_blank, container, false);

        // Getting values
        etValor1 = (EditText) itemView.findViewById(R.id.valor1);
        etValor2 = (EditText) itemView.findViewById(R.id.valor2);
        btnSomar = (Button) itemView.findViewById(R.id.btnSomar);
        btnSubtrair = (Button) itemView.findViewById(R.id.btnSubtrair);
        btnMultiplicar = (Button) itemView.findViewById(R.id.btnMultiplicar);
        btnDividir = (Button) itemView.findViewById(R.id.btnDividir);
        tvResultado = (TextView) itemView.findViewById(R.id.tvResultado);

        // Setting listeners to this
        btnSomar.setOnClickListener(this);
        btnSubtrair.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);

        return itemView;
    }

    @Override
    public void onClick(View v) {
        int result = 0;
        if (etValor1.getText().toString().trim().equals("") || etValor2.getText().toString().trim().equals("")) {
            Toast.makeText(getContext(),"Informe ambos os valores", Toast.LENGTH_SHORT);
            return;
        }

        int v1 = Integer.parseInt(etValor1.getText().toString());
        int v2 = Integer.parseInt(etValor2.getText().toString());

        switch (v.getId()) {
            case R.id.btnSomar:
                result = v1 + v2;
                break;
            case R.id.btnSubtrair:
                result = v1 - v2;
                break;
            case R.id.btnMultiplicar:
                result = v1 * v2;
                break;
            case R.id.btnDividir:
                result = v1 / v2;
                break;
        }

        tvResultado.setText(String.valueOf(result));
    }
}
