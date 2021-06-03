package ru.gb.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Calculator calc;
    public static final String CALC_STRING_KEY = "CALC_STRING_KEY";
    public static final String CALC_THEME_KEY = "CALC_THEME_KEY";
    public static final int THEME_REQUEST_CODE = 1234;
    private boolean dayBackground = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        calc = new Calculator("");

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(CALC_STRING_KEY)) {
                calc.appendString(savedInstanceState.getString(CALC_STRING_KEY));
            }
            if (savedInstanceState.containsKey(CALC_THEME_KEY)) {
                dayBackground = savedInstanceState.getBoolean(CALC_THEME_KEY);
            }
        }
        refreshTextView();

        ImageView imageView = findViewById(R.id.image_view_day);
        if (dayBackground) {
            imageView.setImageResource(R.drawable.day);
        } else {
            imageView.setImageResource(R.drawable.night);
        }


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
        ((Button) findViewById(R.id.button_choice)).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Change_background_dialog.class);
            intent.putExtra(CALC_THEME_KEY, dayBackground);
            startActivityForResult(intent, THEME_REQUEST_CODE);
        });
    }

    private void refreshTextView() {
        textView.setText(calc.getCalcString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(CALC_STRING_KEY, calc.getCalcString());
        outState.putBoolean(CALC_THEME_KEY, dayBackground);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == THEME_REQUEST_CODE) {
            boolean dataBooleanExtra = data.getBooleanExtra(CALC_THEME_KEY, dayBackground);
            dayBackground = dataBooleanExtra;
            recreate();
        }
    }}