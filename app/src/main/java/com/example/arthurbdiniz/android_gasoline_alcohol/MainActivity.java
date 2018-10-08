package com.example.arthurbdiniz.android_gasoline_alcohol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGasolina = null;
    private EditText editTextAlcool = null;

    private Button buttonCalculate = null;

    private Double precoGasolina = null;
    private Double precoAlcool = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGasolina = findViewById(R.id.editTextGasolina);
        editTextAlcool = findViewById(R.id.editTextAlcool);

        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textGasolina = editTextGasolina.getText().toString();
                String textAlcool = editTextAlcool.getText().toString();

                if (textGasolina.equals("")) {
                    editTextGasolina.setError("Complete o campo gasolina antes de continuar");
                    return;
                }
                if (textAlcool.equals("")) {
                    editTextAlcool.setError("Complete o campo alcool antes de continuar");
                    return;
                }

                precoGasolina = Double.valueOf(textGasolina);
                precoAlcool = Double.valueOf(textAlcool);

                Log.d("MainActivity", precoGasolina.toString() + "  " + precoAlcool.toString());

                if (precoGasolina * 0.7 <= precoAlcool) {
                    Toast.makeText(getApplicationContext(), "Use Gasolina", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Use Alcool", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
