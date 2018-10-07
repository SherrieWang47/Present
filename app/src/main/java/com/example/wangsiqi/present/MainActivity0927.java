package com.example.wangsiqi.present;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity0927 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.wangsiqi.present.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0927);
    }

    /** Called when the user taps the search_zip button */
    public void searchZip(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ZipcodeActivity.class);
        EditText editText = (EditText) findViewById(R.id.editZip);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the search_location button */
    public void searchLocation(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, LocationActivity.class);

        startActivity(intent);
    }


}
