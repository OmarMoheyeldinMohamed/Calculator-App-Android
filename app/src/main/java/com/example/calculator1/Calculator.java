package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//test



public class Calculator extends AppCompatActivity implements  View.OnClickListener {

    private  model m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        m = new model();

        Button button;
        for (int i : new int[]{R.id.clear, R.id.plus_minus, R.id.modulus, R.id.divide, R.id.seven, R.id.eight, R.id.nine, R.id.multiply, R.id.four, R.id.five, R.id.six, R.id.minus, R.id.one, R.id.two, R.id.three, R.id.plus, R.id.zero, R.id.decimal, R.id.equal}) {
            button = (Button)findViewById(i);
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        TextView tv;
        tv = (TextView) findViewById(R.id.calc_number);
        switch (view.getId())
        {

            case R.id.clear: {
                m.getbutton('C');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.plus_minus: {
                m.getbutton('~');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.modulus: {
                m.getbutton('%');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.divide: {
                m.getbutton('/');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.seven: {
                m.getbutton('7');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.eight: {
                m.getbutton('8');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.nine: {
                m.getbutton('9');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.multiply: {
                m.getbutton('X');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.four: {
                m.getbutton('4');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.five: {
                m.getbutton('5');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.six: {
                m.getbutton('6');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.minus: {
                m.getbutton('-');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.one: {
                m.getbutton('1');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.two: {
                m.getbutton('2');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.three: {
                m.getbutton('3');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.plus: {
                m.getbutton('+');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.zero: {
                m.getbutton('0');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.decimal: {
                m.getbutton('.');
                tv.setText(m.get_what_to_write());
                break;
            }
            case R.id.equal: {
                m.getbutton('=');
                tv.setText(m.get_what_to_write());
                break;
            }
        }
    }

    /*@Override
    public void onClick(View view) {
        if (view.getId() == R.id.clear_button)
        {


        }
    }*/
}