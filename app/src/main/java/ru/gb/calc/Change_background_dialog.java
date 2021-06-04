package ru.gb.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Change_background_dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background_dialog);

        boolean day_background = getIntent().getExtras().getBoolean(MainActivity.CALC_THEME_KEY);
        ImageView imageView = findViewById(R.id.image_view);
        if (day_background) {
            imageView.setImageResource(R.drawable.day);
        } else {
            imageView.setImageResource(R.drawable.night);
        }
        findViewById(R.id.button_day).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(MainActivity.CALC_THEME_KEY, true);
            setResult(RESULT_OK, intent);
            finish();
        });
        findViewById(R.id.button_night).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(MainActivity.CALC_THEME_KEY, false);
            setResult(RESULT_OK, intent);
            finish();
        });

    }
}