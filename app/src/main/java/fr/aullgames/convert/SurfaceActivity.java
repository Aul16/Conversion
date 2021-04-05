package fr.aullgames.convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SurfaceActivity extends AppCompatActivity {

    private EditText et_surfaceFR;
    private EditText et_surfaceUS;

    private Button btn_submit;
    private Button btn_deleteFR;
    private Button btn_deleteUS;

    private Spinner spin_surfaceFR;
    private Spinner spin_surfaceUS;

    private float Have;
    private float Want;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface);

        et_surfaceFR = findViewById(R.id.et_surfaceFR);
        et_surfaceUS = findViewById(R.id.et_surfaceUS);

        spin_surfaceFR = findViewById(R.id.spin_surfaceUnitFR);
        spin_surfaceUS = findViewById(R.id.spin_surfaceUnitUS);

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Convert
                convert("km²", "in²", Have, Want, 1550003000.000000f);
                convert("km²", "ft²", Have, Want, 10763910.000000f);
                convert("km²", "yd²", Have, Want, 1195990.000000f);
                convert("km²", "mi²", Have, Want, 0.386102f);
                convert("km²", "acres", Have, Want, 247.110000f);
                convert("m²", "in²", Have, Want, 1550.000000f);
                convert("m²", "ft²", Have, Want, 10.763900f);
                convert("m²", "yd²", Have, Want, 1.196000f);
                convert("m²", "acres", Have, Want, 0.00024711f);
                convert("m²", "mi²", Have, Want, 0.0000003861022f);
                convert("cm²", "in²", Have, Want, 0.155000f);
                convert("cm²", "ft²", Have, Want, 0.00107639f);
                convert("cm²", "yd²", Have, Want, 0.0001196f);
                convert("cm²", "acres", Have, Want, 0.000000024711f);
                convert("cm²", "mi²", Have, Want, 0.0000000000386102f);
                convert("ha", "in²", Have, Want, 15500030.000000f);
                convert("ha", "ft²", Have, Want, 107639.099999f);
                convert("ha", "yd²", Have, Want, 11959.900000f);
                convert("ha", "mi²", Have, Want, 0.003861022f);
                convert("ha", "acres", Have, Want, 2.4710550000000002f);
                convert("a", "in²", Have, Want, 155000.3f);
                convert("a", "ft²", Have, Want, 1076.3909999999998f);
                convert("a", "yd²", Have, Want, 119.59900000000002f);
                convert("a", "mi²", Have, Want, 0.00003861022f);
                convert("a", "acres", Have, Want, 0.02471055f);

            }
        });

        btn_deleteFR = findViewById(R.id.btn_deleteFR);
        btn_deleteFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_surfaceFR.setText("");
            }
        });

        btn_deleteUS = findViewById(R.id.btn_deleteUS);
        btn_deleteUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_surfaceUS.setText("");
            }
        });
    }

    private void convert(String spinFR, String spinUS, float _Have, float _Want, float Convert){
        if (!et_surfaceFR.getText().toString().equals("")) {
            _Have = Float.valueOf(et_surfaceFR.getText().toString());

            if (spin_surfaceFR.getSelectedItem().toString().equals(spinFR) &&
                    spin_surfaceUS.getSelectedItem().toString().equals(spinUS)) {
                _Want = _Have * Convert;
                et_surfaceUS.setText(String.valueOf(_Want));
            }
        }else if (!et_surfaceUS.getText().toString().equals("")){
            _Have = Float.valueOf(et_surfaceUS.getText().toString());

            if (spin_surfaceFR.getSelectedItem().toString().equals(spinFR) &&
                    spin_surfaceUS.getSelectedItem().toString().equals(spinUS)) {
                _Want = _Have / Convert;
                et_surfaceFR.setText(String.valueOf(_Want));
            }
        }
    }

}
