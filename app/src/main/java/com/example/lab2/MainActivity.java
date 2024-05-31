package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;
    private CheckBox checkBox;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear);  // Change layout file as needed

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        checkBox = findViewById(R.id.checkBox);
        switch1 = findViewById(R.id.switch1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                textView.setText(text);
                Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
            }
        });

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String message = getResources().getString(isChecked ? R.string.snackbar_checkbox_on : R.string.snackbar_checkbox_off);
            Snackbar snackbar = Snackbar.make(buttonView, message, Snackbar.LENGTH_LONG);
            snackbar.setAction(getResources().getString(R.string.snackbar_undo), v -> checkBox.setChecked(!isChecked));
            snackbar.show();
        });
    }
}