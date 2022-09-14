package com.example.calculadoraradical;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //ACESSIBILIDADE
        Switch siaopt = findViewById(R.id.switch_sia);
        Switch darkopt = findViewById(R.id.switch_darkmode);

        //NUMEROS
        Button num1 = (Button) findViewById(R.id.btn_num1);
        Button num2 = (Button) findViewById(R.id.btn_num2);
        Button num3 = (Button) findViewById(R.id.btn_num3);
        Button num4 = (Button) findViewById(R.id.btn_num4);
        Button num5 = (Button) findViewById(R.id.btn_num5);
        Button num6 = (Button) findViewById(R.id.btn_num6);
        Button num7 = (Button) findViewById(R.id.btn_num7);
        Button num8 = (Button) findViewById(R.id.btn_num8);
        Button num9 = (Button) findViewById(R.id.btn_num9);
        Button num0 = (Button) findViewById(R.id.btn_num0);

        //OPERAÇÕES
        Button btndiv = (Button) findViewById(R.id.btn_num_div);
        Button btndot = (Button) findViewById(R.id.btn_num_dot);
        Button btnmin = (Button) findViewById(R.id.btn_num_minus);
        Button btnmult = (Button) findViewById(R.id.btn_num_mult);
        Button btnplus = (Button) findViewById(R.id.btn_num_plus);
        Button btnclr = (Button) findViewById(R.id.btn_clear);
        Button btnpnt = (Button) findViewById(R.id.btn_percent);
        Button btnequal = (Button) findViewById(R.id.btn_equal);

        //RESULTADO
        TextView resultado = (TextView) findViewById(R.id.displayResult);

        //NUMEROS DA OPERAÇÃO
        TextView operacao = (TextView) findViewById(R.id.numbersInOperation);


        siaopt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){

                    num1.setTextSize(48);
                    num2.setTextSize(48);
                    num3.setTextSize(48);
                    num4.setTextSize(48);
                    num5.setTextSize(48);
                    num6.setTextSize(48);
                    num7.setTextSize(48);
                    num8.setTextSize(48);
                    num9.setTextSize(48);
                    num0.setTextSize(48);

                    btndiv.setTextSize(48);
                    btndot.setTextSize(48);
                    btnmin.setTextSize(48);
                    btnmult.setTextSize(48);
                    btnplus.setTextSize(48);
                    btnclr.setTextSize(48);
                    btnpnt.setTextSize(48);
                    btnequal.setTextSize(48);

                } else {

                    num1.setTextSize(28);
                    num2.setTextSize(28);
                    num3.setTextSize(28);
                    num4.setTextSize(28);
                    num5.setTextSize(28);
                    num6.setTextSize(28);
                    num7.setTextSize(28);
                    num8.setTextSize(28);
                    num9.setTextSize(28);
                    num0.setTextSize(28);

                    btndiv.setTextSize(28);
                    btndot.setTextSize(28);
                    btnmin.setTextSize(28);
                    btnmult.setTextSize(28);
                    btnplus.setTextSize(28);
                    btnclr.setTextSize(28);
                    btnpnt.setTextSize(28);
                    btnequal.setTextSize(28);

                }
            }
        });
        darkopt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){

                    num1.setTextColor(Color.BLACK);
                    num2.setTextColor(Color.BLACK);
                    num3.setTextColor(Color.BLACK);
                    num4.setTextColor(Color.BLACK);
                    num5.setTextColor(Color.BLACK);
                    num6.setTextColor(Color.BLACK);
                    num7.setTextColor(Color.BLACK);
                    num8.setTextColor(Color.BLACK);
                    num9.setTextColor(Color.BLACK);
                    num0.setTextColor(Color.BLACK);

                    num1.getResources().getColor(R.color.lightgray);
                    num2.getResources().getColor(R.color.lightgray);
                    num3.getResources().getColor(R.color.lightgray);
                    num4.getResources().getColor(R.color.lightgray);
                    num5.getResources().getColor(R.color.lightgray);
                    num6.getResources().getColor(R.color.lightgray);
                    num7.getResources().getColor(R.color.lightgray);
                    num8.getResources().getColor(R.color.lightgray);
                    num9.getResources().getColor(R.color.lightgray);
                    num0.getResources().getColor(R.color.lightgray);

                    btndiv.setTextColor(Color.BLACK);
                    btndot.setTextColor(Color.BLACK);
                    btnmin.setTextColor(Color.BLACK);
                    btnmult.setTextColor(Color.BLACK);
                    btnplus.setTextColor(Color.BLACK);
                    btnclr.setTextColor(Color.BLACK);
                    btnpnt.setTextColor(Color.BLACK);
                    btnequal.setTextColor(Color.BLACK);

                    btndiv.setBackgroundColor(Color.WHITE);
                    btndot.setBackgroundColor(Color.WHITE);
                    btnmin.setBackgroundColor(Color.WHITE);
                    btnmult.setBackgroundColor(Color.WHITE);
                    btnplus.setBackgroundColor(Color.WHITE);
                    btnclr.setBackgroundColor(Color.WHITE);
                    btnpnt.setBackgroundColor(Color.WHITE);
                    btnequal.setBackgroundColor(Color.WHITE);

                } else {

                    num1.setTextColor(Color.WHITE);
                    num2.setTextColor(Color.WHITE);
                    num3.setTextColor(Color.WHITE);
                    num4.setTextColor(Color.WHITE);
                    num5.setTextColor(Color.WHITE);
                    num6.setTextColor(Color.WHITE);
                    num7.setTextColor(Color.WHITE);
                    num8.setTextColor(Color.WHITE);
                    num9.setTextColor(Color.WHITE);
                    num0.setTextColor(Color.WHITE);

                    num1.getResources().getColor(R.color.darkgray);
                    num2.getResources().getColor(R.color.darkgray);
                    num3.getResources().getColor(R.color.darkgray);
                    num4.getResources().getColor(R.color.darkgray);
                    num5.getResources().getColor(R.color.darkgray);
                    num6.getResources().getColor(R.color.darkgray);
                    num7.getResources().getColor(R.color.darkgray);
                    num8.getResources().getColor(R.color.darkgray);
                    num9.getResources().getColor(R.color.darkgray);
                    num0.getResources().getColor(R.color.darkgray);

                    btndiv.setTextColor(Color.WHITE);
                    btndot.setTextColor(Color.WHITE);
                    btnmin.setTextColor(Color.WHITE);
                    btnmult.setTextColor(Color.WHITE);
                    btnplus.setTextColor(Color.WHITE);
                    btnclr.setTextColor(Color.WHITE);
                    btnpnt.setTextColor(Color.WHITE);
                    btnequal.setTextColor(Color.WHITE);

                    btndiv.setBackgroundColor(Color.BLACK);
                    btndot.setBackgroundColor(Color.BLACK);
                    btnmin.setBackgroundColor(Color.BLACK);
                    btnmult.setBackgroundColor(Color.BLACK);
                    btnplus.setBackgroundColor(Color.BLACK);
                    btnclr.setBackgroundColor(Color.BLACK);
                    btnpnt.setBackgroundColor(Color.BLACK);
                    btnequal.setBackgroundColor(Color.BLACK);

                }
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacao.setText("1");
            }
        });


    }
}
