package com.vitvn183.formloginfacebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    TextView login, note;
    EditText name, email, pass, repass;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getId();
        String username = email.getText().toString();
        String password = pass.getText().toString();
        String confirmPass = repass.getText().toString();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFormSignUp();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

    }

    private void getId() {
        login = findViewById(R.id.login);
        signup = findViewById(R.id.sign_up);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        repass = findViewById(R.id.repass);
        note = findViewById(R.id.note);
    }


    public void validateFormSignUp() {
        String password = pass.getText().toString();
        String confirmPassword = repass.getText().toString();
        boolean isWrong = false;
        if(name.getText().toString().trim() == "") {
            isWrong = true;
            note.setText("Vui lòng nhập họ và tên");
        } else if(email.getText().toString().trim() == "") {
            isWrong = true;
            note.setText("Vui lòng nhập email");
        } else if(password.trim() == "") {
            isWrong = true;
            note.setText("Vui lòng nhập mật khẩu");
        } else if(!password.trim().equals(confirmPassword.trim())) {
            isWrong = true;
            note.setText("Mật khẩu không khớp");
        }

        if(!isWrong) {
            Intent intent = new Intent(SignUp.this, ShowInfo.class);

            Account acc = new Account();
            acc.setUsername(email.getText().toString());
            acc.setPassword(pass.getText().toString());
            intent.putExtra("acc", (Parcelable) acc);

            startActivity(intent);
        }
    }
}