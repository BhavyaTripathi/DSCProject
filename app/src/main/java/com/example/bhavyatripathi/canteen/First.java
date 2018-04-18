package com.example.bhavyatripathi.canteen;

/**
 * Created by Bhavya Tripathi on 16/04/2018.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class First extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
    }

    public void phone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9205871191"));
        startActivity(intent);
    }

    public void onClick(View view) {
        // Create a new intent to open the {@link NumbersActivity}
        Intent numbersIntent = new Intent(First.this, MainActivity.class);

        // Start the new activity
        startActivity(numbersIntent);
    }
}
