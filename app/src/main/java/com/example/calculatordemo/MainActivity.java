package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void buttonClicked(int operator) {
        EditText num1 = (EditText) findViewById(R.id.editNum1);
        EditText num2 = (EditText) findViewById(R.id.editNum2);

        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(num1.getText().toString());
            b = Integer.parseInt(num2.getText().toString());
        }
        catch (NumberFormatException e) {
            // just don't do anything if the provided text isn't integers
            return;
        }

        String ans = "";
        switch(operator) {
            case 0:
                ans = (a + b) + "";
                break;
            case 1:
                ans = (a - b) + "";
                break;
            case 2:
                ans = (a * b) + "";
                break;
            case 3:
                ans = (a / b) + "";
                break;
            default:
                break;
        }
        goToResult(ans);

    }

    public void goToResult(String s) {
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = (Button) findViewById(R.id.add);
        Button subtract = (Button) findViewById(R.id.subtract);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button divide = (Button) findViewById(R.id.divide);

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(0);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(1);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(2);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(3);
            }
        });
    }
}