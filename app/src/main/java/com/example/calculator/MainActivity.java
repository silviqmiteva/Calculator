package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    Button number0,number1,number2,number3,number4,number5,number6,number7,number8,number9,
    btnEquals,btnPlus,btnMinus,btnDiv,btnMul,btnC,btnSqrt,btnPercent,btnPoint;
    TextView textView;
    double firstNumber=0, secondNumber=0;
    String operation = "";
    boolean resultShown = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number0 = findViewById(R.id.btn0);
        number1 = findViewById(R.id.btn1);
        number2 = findViewById(R.id.btn2);
        number3 = findViewById(R.id.btn3);
        number4 = findViewById(R.id.btn4);
        number5 = findViewById(R.id.btn5);
        number6 = findViewById(R.id.btn6);
        number7 = findViewById(R.id.btn7);
        number8 = findViewById(R.id.btn8);
        number9 = findViewById(R.id.btn9);
        btnEquals = findViewById(R.id.btnEquals);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMultiplication);
        btnDiv = findViewById(R.id.btnDivision);
        btnPoint= findViewById(R.id.btnPoint);
        btnC = findViewById(R.id.btnC);
        btnSqrt = findViewById(R.id.btnSqrt);
        btnPercent = findViewById(R.id.btnPercent);
        textView = findViewById(R.id.numberField);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                firstNumber=0;
                secondNumber=0;
            }
        });

            number1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "1");
                }
            });

            number2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "2");
                }
            });

            number3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "3");
                }
            });

            number4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "4");
                }
            });

            number5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "5");
                }
            });

            number6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "6");
                }
            });

            number7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "7");
                }
            });

            number8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "8");
                }
            });

            number9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "9");
                }
            });

            number0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(textView.getText() + "0");
                }
            });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.length()==0){
                    textView.setText("");
                }else {
                    firstNumber = Double.parseDouble(textView.getText() + "");
                    operation = "+";
                    textView.setText(null);
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView.getText().length() != 0) {
                    firstNumber = Double.parseDouble(textView.getText() + "");
                    operation = "-";
                    textView.setText("");
                }else {
                    textView.setText("-");
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(textView.getText() + "");
                operation = "*";
                textView.setText("");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(textView.getText()+"");
                operation = "/";
                textView.setText("");
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(textView.getText()+"");
                operation="%";
                textView.setText("");
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Double.parseDouble(textView.getText().toString());
                textView.setText("");
                operation = "sqrt";
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString()+".");
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            boolean allowed = true;
            @Override
            public void onClick(View v) {
                String number = textView.getText().toString();
                if(number.length()>0) {
                    secondNumber = Double.parseDouble(textView.getText().toString());
                }
                double result = 0;
                if(operation.equals("+")){
                    result = firstNumber + secondNumber;
                }else if(operation.equals("-")){
                    result = firstNumber - secondNumber;
                }else if(operation.equals("*")){
                    result = firstNumber * secondNumber;
                }else if(operation.equals("/")){
                    if(secondNumber==0){
                        allowed = false;
                    }else {
                        result = firstNumber / secondNumber;
                    }
                }else if(operation.equals("sqrt")){
                    if(firstNumber==0) {
                        result = Math.sqrt(secondNumber);
                    }else{
                        result = firstNumber*(Math.sqrt(secondNumber));
                    }
                }else if(operation.equals("%")){
                    result = firstNumber*(secondNumber/100) ;
                }

                if(allowed==true) {
                    NumberFormat nm = NumberFormat.getNumberInstance();
                    textView.setText(nm.format(result));
                }else{
                    textView.setText("∞");
                }
                firstNumber = 0;
                secondNumber = 0;
                resultShown = true;
            }
        });

    }
}
