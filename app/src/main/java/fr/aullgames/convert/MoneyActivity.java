package fr.aullgames.convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MoneyActivity extends AppCompatActivity {

    private float Have;
    private float Want;

    private EditText et_moneyFR;
    private EditText et_moneyUS;

    private Button btn_submit;
    private Button btn_deleteFR;
    private Button btn_deleteUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        et_moneyFR = findViewById(R.id.et_moneyFR);
        et_moneyUS = findViewById(R.id.et_moneyUS);

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et_moneyFR.getText().toString().equals("")) {
                    Have = Float.valueOf(et_moneyFR.getText().toString());
                    Want = Have * 1.1754f;
                    et_moneyUS.setText(String.valueOf(Want));
                }else if (!et_moneyUS.getText().toString().equals("")){
                    Have = Float.valueOf(et_moneyUS.getText().toString());
                    Want = Have / 1.1754f;
                    et_moneyFR.setText(String.valueOf(Want));
                }
            }
        });

        btn_deleteFR = findViewById(R.id.btn_deleteFR);
        btn_deleteFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_moneyFR.setText("");
            }
        });

        btn_deleteUS = findViewById(R.id.btn_deleteUS);
        btn_deleteUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_moneyUS.setText("");
            }
        });
    }
}