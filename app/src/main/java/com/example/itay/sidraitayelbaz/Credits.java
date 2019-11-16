package com.example.itay.sidraitayelbaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


/**
 *
 * credits activity
 */
public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     *
     * takes you back to the previous activity
     */
    public void back(View view) {
        finish();
    }
}
