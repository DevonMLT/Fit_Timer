package com.devm.FitTimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout buttonToActivity2;
    EditText tText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tText = findViewById(R.id.testText);

        buttonToActivity2 = findViewById(R.id.llStart);
        buttonToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }






//        editText = findViewById(R.id.edittext);
//        loadData();
//        updateView();
//    }
//    public void onStop() {
//        super.onStop();
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(TEXT, editText.getText().toString());
//        editor.apply();
//    }
//    public void loadData() {
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
//        text = sharedPreferences.getString(TEXT, "");
//    }
//    public void updateView() {
//        editText.setText(text);
//    }

    public void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}