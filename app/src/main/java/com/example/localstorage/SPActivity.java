package com.example.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SPActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @BindView(R.id.text_area)
    EditText editTextView;

    @OnClick(R.id.change_btn)
    void change() {
        Editable text = editTextView.getText();
        editor.putString(getString(R.string.testText), text.toString());
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_p);
        ButterKnife.bind(this);
        sharedPreferences = this.getSharedPreferences("test", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String editText = sharedPreferences.getString(getString(R.string.testText), "");
        editTextView.setText(editText);
    }
}