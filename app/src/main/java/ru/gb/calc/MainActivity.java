package ru.gb.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Calculator calc;
    private final String CALC_STRING_KEY = "CALC_STRING_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        calc = new Calculator("");

        if (savedInstanceState != null && savedInstanceState.containsKey(CALC_STRING_KEY)) {
            calc.appendString(savedInstanceState.getString(CALC_STRING_KEY));
        }
        refreshTextView();

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
            calc.clear();
        });
        ((Button) findViewById(R.id.button_plus)).setOnClickListener(v -> {
            calc.appendString("+");
            refreshTextView();
        });

        //ImageView imageView = findViewById(R.id.image_view);
        //imageView.setImageResource(R.drawable.back_image33_land);
    }

    private void refreshTextView() {
        textView.setText(calc.getCalcString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CALC_STRING_KEY, calc.getCalcString());
    }
}