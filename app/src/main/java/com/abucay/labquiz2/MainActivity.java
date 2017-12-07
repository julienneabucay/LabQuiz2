package com.abucay.labquiz2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnRemember, btnLogin;
    EditText etUser, etPassword;
    SharedPreferences preferences;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRemember = (Button) findViewById(R.id.btnRemember);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        etUser = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPassword);

        preferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        String getname = preferences.getString("key1","no valu found");
        String getpass = preferences.getString("key2","no valu found");


        if (etUser != null ){
            etUser.setText(getname);
            etPassword.setText(getpass);
        }


    }


    public void rememberMe(View view){

            String name = etUser.getText().toString();
            String pass = etPassword.getText().toString();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("key1", name);
            editor.putString("key2",pass);
            editor.commit();

            Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

    }





    public void login (View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
