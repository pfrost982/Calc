package ru.gb.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Calculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        calc = new Calculator("");

        ((Button) findViewById(R.id.button_open_bracket)).setOnClickListener(v -> {
            calc.appendString("(");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_close_bracket)).setOnClickListener(v -> {
            calc.appendString(")");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_percent)).setOnClickListener(v -> {
            calc.appendString("%");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_C)).setOnClickListener(v -> {
            calc.clear();
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_7)).setOnClickListener(v -> {
            calc.appendString("7");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_8)).setOnClickListener(v -> {
            calc.appendString("8");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_9)).setOnClickListener(v -> {
            calc.appendString("9");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_div)).setOnClickListener(v -> {
            calc.appendString("/");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_4)).setOnClickListener(v -> {
            calc.appendString("4");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_5)).setOnClickListener(v -> {
            calc.appendString("5");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_6)).setOnClickListener(v -> {
            calc.appendString("6");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_mul)).setOnClickListener(v -> {
            calc.appendString("x");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_1)).setOnClickListener(v -> {
            calc.appendString("1");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_2)).setOnClickListener(v -> {
            calc.appendString("2");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_3)).setOnClickListener(v -> {
            calc.appendString("3");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_minus)).setOnClickListener(v -> {
            calc.appendString("-");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_point)).setOnClickListener(v -> {
            calc.appendString(".");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_0)).setOnClickListener(v -> {
            calc.appendString("0");
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_equal)).setOnClickListener(v -> {
            calc.calculateResult();
            refreshTextView();
        });
        ((Button) findViewById(R.id.button_plus)).setOnClickListener(v -> {
            calc.appendString("+");
            refreshTextView();
        });
    }

    private void refreshTextView() {
        textView.setText(calc.getCalcString());
    }
}