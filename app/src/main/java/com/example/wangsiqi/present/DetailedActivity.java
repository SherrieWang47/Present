package com.example.wangsiqi.present;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(ZipcodeActivity.EXTRA_MESSAGE_Fullname);
        System.out.println("message"+message);
        String party = intent.getStringExtra(ZipcodeActivity.EXTRA_MESSAGE_Party);
        String birthday = intent.getStringExtra(ZipcodeActivity.EXTRA_MESSAGE_Birthday);
        String address = intent.getStringExtra(ZipcodeActivity.EXTRA_MESSAGE_Adress);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.tvFullname);
        textView.setText(message);

        TextView tvparty = findViewById(R.id.tvParty);
        tvparty.setText(party);

        TextView tvbirthday = findViewById(R.id.tvCommittees);
        TextView tvaddress = findViewById(R.id.tvBills);
        tvbirthday.setText(birthday);
        tvaddress.setText(address);

    }
}
