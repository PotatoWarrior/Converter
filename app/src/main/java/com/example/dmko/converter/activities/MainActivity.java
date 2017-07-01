package com.example.dmko.converter.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.dmko.converter.utils.ConverterUtils;
import com.example.dmko.converter.R;

public class MainActivity extends AppCompatActivity {
    private EditText celsiusEditText;
    private EditText fahrenheitEditText;
    private EditText kelvinEditText;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        celsiusEditText = (EditText) findViewById(R.id.celsiusEditText);
        fahrenheitEditText = (EditText) findViewById(R.id.fahrenheitEditText);
        kelvinEditText = (EditText) findViewById(R.id.kelvinEditText);
        clearButton = (Button) findViewById(R.id.clearButton);
        celsiusEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (celsiusEditText.isFocused()) {
                    Double t = parseDouble(s.toString());
                    if(t == null) return;;
                    fahrenheitEditText.setText(String.valueOf(ConverterUtils.convertCelsiusToFahrenheit(t)));
                    kelvinEditText.setText(String.valueOf(ConverterUtils.convertCelsiusToKelvin(t)));
                }
            }
        });
        fahrenheitEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (fahrenheitEditText.isFocused()) {
                    Double t = parseDouble(s.toString());
                    if(t == null) return;;
                    celsiusEditText.setText(String.valueOf(ConverterUtils.convertFahrenheitToCelsius(t)));
                    kelvinEditText.setText(String.valueOf(ConverterUtils.convertFahrenheitToKelvin(t)));
                }
            }
        });
        kelvinEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (kelvinEditText.isFocused()) {
                    Double t = parseDouble(s.toString());
                    if(t == null) return;;
                    fahrenheitEditText.setText(String.valueOf(ConverterUtils.convertKelvinToFahrenheit(t)));
                    celsiusEditText.setText(String.valueOf(ConverterUtils.convertKelvinToCelsius(t)));
                }
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                celsiusEditText.setText("");
                fahrenheitEditText.setText("");
                kelvinEditText.setText("");
            }
        });
    }

    private Double parseDouble(String num){
        try {
            return Double.parseDouble(num);
        } catch (NumberFormatException e){
            return null;
        }
    }
}
