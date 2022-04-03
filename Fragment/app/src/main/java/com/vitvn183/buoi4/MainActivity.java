package com.vitvn183.buoi4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstFragment.SendData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddFragment();

        SecondFragment secondFragment;
    }

    private void AddFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fg1, new FirstFragment());
        transaction.add(R.id.fg2, new SecondFragment());
        transaction.commit();
    }

    @Override
    public void onSendData(User user) {
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fg2);
        if (secondFragment != null) {
            secondFragment.getUsername.setText("Username: " + user.getUsername());
            secondFragment.getPassword.setText("Username: " + user.getPassword());
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

}