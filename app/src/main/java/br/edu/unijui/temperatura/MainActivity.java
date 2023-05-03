package br.edu.unijui.temperatura;

import static br.edu.unijui.temperatura.R.id.txtResultado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTemperaturaInicial;
    private TextView editResultado;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTemperaturaInicial = findViewById(R.id.editTextNumber1);
        editResultado = findViewById(txtResultado);
    }

    public void Converter(View view) {
        double temperaturaInicial = Double.parseDouble(editTemperaturaInicial.getText().toString());

        RadioGroup grupoInicialSelecionado = findViewById(R.id.radioGroup);
        int inicialSelecionado = grupoInicialSelecionado.getCheckedRadioButtonId();

        RadioGroup grupoFinalSelecioando = findViewById(R.id.radioGroup2);
        int finalSelecionado = grupoFinalSelecioando.getCheckedRadioButtonId();

        editResultado.setVisibility(View.VISIBLE);

        if (inicialSelecionado == R.id.radioButtonCelsius1) {
            if (finalSelecionado == R.id.radioButtonCelsius2) {
                double temperaturaCelsius = temperaturaInicial;
                editResultado.setText(String.format("%.2f", temperaturaCelsius));
            } else if (finalSelecionado == R.id.radioButtonFahrenheit2) {
                double temperaturaFahrenheit = (temperaturaInicial * 1.8) + 32;
                editResultado.setText(String.format("%.2f", temperaturaFahrenheit));
            } else if (finalSelecionado == R.id.radioButtonKelvin2) {
                double temperaturaKelvin = temperaturaInicial + 273.15;
                editResultado.setText(String.format("%.2f", temperaturaKelvin));
            }
        }

        if (inicialSelecionado == R.id.radioButtonFahrenheit1) {
            if (finalSelecionado == R.id.radioButtonCelsius2) {
                double temperaturaCelsius = (temperaturaInicial-32) * 5/9;
                editResultado.setText(String.format("%.2f", temperaturaCelsius));
            } else if (finalSelecionado == R.id.radioButtonFahrenheit2) {
                double temperaturaFahrenheit = temperaturaInicial;
                editResultado.setText(String.format("%.2f", temperaturaFahrenheit));
            } else if (finalSelecionado == R.id.radioButtonKelvin2) {
                double temperaturaKelvin = (temperaturaInicial-32) * 5/9 + 273.15;
                editResultado.setText(String.format("%.2f", temperaturaKelvin));
            }
        }

        if (inicialSelecionado == R.id.radioButtonKelvin1) {
            if (finalSelecionado == R.id.radioButtonCelsius2) {
                double temperaturaCelsius = temperaturaInicial-273.15;
                editResultado.setText(String.format("%.2f", temperaturaCelsius));
            } else if (finalSelecionado == R.id.radioButtonFahrenheit2) {
                double temperaturaFahrenheit = (temperaturaInicial-273.15) * 9/5 + 32;
                editResultado.setText(String.format("%.2f", temperaturaFahrenheit));
            } else if (finalSelecionado == R.id.radioButtonKelvin2) {
                double temperaturaKelvin = temperaturaInicial;
                editResultado.setText(String.format("%.2f", temperaturaKelvin));
            }
        }

    }
}