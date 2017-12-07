package com.abucay.labquiz2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btnLogout;
    TextView tvUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnLogout = (Button) findViewById(R.id.btnLogout);
        tvUser = (TextView) findViewById(R.id.tvUser);

        loadShared();

    }

    public void loadShared(){
        SharedPreferences preferences = this.getSharedPreferences("Preferences", MODE_PRIVATE);
        String data = preferences.getString("data","");
        tvUser.setText(data);
    }


    public void logout (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
