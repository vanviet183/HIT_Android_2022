package com.vitvn183.formloginfacebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowInfo extends AppCompatActivity {

    TextView username;
    TextView pass;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getId();

        Intent intent = getIntent();
        Account acc = intent.getParcelableExtra("acc");
        System.out.println(acc.getUsername());
        System.out.println(acc.getPassword());

        username.setText("Username: " + acc.getUsername());
        pass.setText("Password: " + acc.getPassword());

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowInfo.this, Login.class);
                startActivity(intent);
            }
        });
    }

    public void getId() {
        username = findViewById(R.id.usernameShow);
        pass = findViewById(R.id.passwordShow);
        exit = findViewById(R.id.exit);
    }
}