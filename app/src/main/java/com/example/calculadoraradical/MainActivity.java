package com.example.calculadoraradical;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    //SWITCHES
    Switch siaopt, darkopt;

    //BUTTONS
    Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    Button btndiv, btndot, btnmin, btnmult, btnplus, btnclr, btnbks, btnequal;

    //TEXTVIEWS
    TextView resultado, operacao;

    //GLOBAL
    int op = 0;
    Double calculo;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //ACESSIBILIDADE
        assignIdSwitch(siaopt, R.id.switch_sia);
        assignIdSwitch(darkopt, R.id.switch_darkmode);

        //NUMEROS
        assignIdButton(num1, R.id.btn_num1);
        assignIdButton(num2, R.id.btn_num2);
        assignIdButton(num3, R.id.btn_num3);
        assignIdButton(num4, R.id.btn_num4);
        assignIdButton(num5, R.id.btn_num5);
        assignIdButton(num6, R.id.btn_num6);
        assignIdButton(num7, R.id.btn_num7);
        assignIdButton(num8, R.id.btn_num8);
        assignIdButton(num9, R.id.btn_num9);
        assignIdButton(num0, R.id.btn_num0);

        //OPERAÇÕES
        assignIdButton(btndiv, R.id.btn_num_div);
        assignIdButton(btndot, R.id.btn_num_dot);
        assignIdButton(btnmin, R.id.btn_num_minus);
        assignIdButton(btnmult, R.id.btn_num_mult);
        assignIdButton(btnplus, R.id.btn_num_plus);
        assignIdButton(btnclr, R.id.btn_clear);
        assignIdButton(btnbks, R.id.btn_backspace);
        assignIdButton(btnequal, R.id.btn_equal);

        //RESULTADO
        resultado = findViewById(R.id.displayResult);

        //NUMEROS DA OPERAÇÃO
        operacao = findViewById(R.id.numbersInOperation);

    }

    void assignIdButton(Button bt, int id){
        bt = (Button) findViewById(id);
        bt.setOnClickListener(this);
    }

    void assignIdSwitch(Switch sw, int id){
        sw = findViewById(id);
        sw.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        Button botao = (Button) view;
        String textoBotao = botao.getText().toString();
        String textoOperacao = resultado.getText().toString();

        if(textoBotao.equals("˂") && !textoOperacao.isEmpty()){
            textoOperacao = textoOperacao.substring(0, textoOperacao.length()-1);
        } else {
            if(textoBotao.equals("˂") ||
                    textoBotao.equals("-") ||
                    textoBotao.equals("+") ||
                    textoBotao.equals("%") ||
                    textoBotao.equals("÷") ||
                    textoBotao.equals("×") ||
                    textoBotao.equals("=")
            ){
                textoOperacao = textoOperacao;
            } else {
                textoOperacao = textoOperacao + textoBotao;
            }
        }

        resultado.setText(textoOperacao);

        switch (textoBotao) {
            case "-":
                if(!resultado.equals("")){
                    calculo = Double.parseDouble(textoOperacao);
                    operacao.setText(calculo.toString() + textoBotao);
                    resultado.setText("");
                    op = 1;
                } else {
                    op = 0;
                }
                break;
            case "+":
                if(!resultado.equals("")){
                    calculo = Double.parseDouble(textoOperacao);
                    operacao.setText(calculo.toString() + textoBotao);
                    resultado.setText("");
                    op = 2;
                } else {
                    op = 0;
                }
                break;
            case "÷":
                if(!resultado.equals("")){
                    calculo = Double.parseDouble(textoOperacao);
                    operacao.setText(calculo.toString() + textoBotao);
                    resultado.setText("");
                    op = 3;
                } else {
                    op = 0;
                }
                break;
            case "×":
                if(!resultado.equals("")){
                    calculo = Double.parseDouble(textoOperacao);
                    operacao.setText(calculo.toString() + textoBotao);
                    resultado.setText("");
                    op = 4;
                } else {
                    op = 0;
                }
                break;
            case "CE":
                operacao.setText("");
                resultado.setText("");
                calculo = 0.0;
                break;
            case "=":
                if(op == 1){
                    calculo = Double.parseDouble(operacao.getText().toString().substring(0, operacao.length()-1)) - Double.parseDouble(resultado.getText().toString());
                    operacao.setText(operacao.getText().toString() + resultado.getText().toString() + "=" + calculo);
                    resultado.setText(calculo.toString());
                    op = 0;
                } else if (op == 2){
                    calculo = Double.parseDouble(operacao.getText().toString().substring(0, operacao.length()-1)) + Double.parseDouble(resultado.getText().toString());
                    operacao.setText(operacao.getText().toString() + resultado.getText().toString() + "=" + calculo);
                    resultado.setText(calculo.toString());
                    op = 0;
                } else if (op == 3){
                    calculo = Double.parseDouble(operacao.getText().toString().substring(0, operacao.length()-1)) / Double.parseDouble(resultado.getText().toString());
                    operacao.setText(operacao.getText().toString() + resultado.getText().toString() + "=" + calculo);
                    resultado.setText(calculo.toString());
                    op = 0;
                } else if (op == 4){
                    calculo = Double.parseDouble(operacao.getText().toString().substring(0, operacao.length()-1)) * Double.parseDouble(resultado.getText().toString());
                    operacao.setText(operacao.getText().toString() + resultado.getText().toString() + "=" + calculo);
                    resultado.setText(calculo.toString());
                    op = 0;
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {;

        siaopt = findViewById(R.id.switch_sia);
        darkopt = findViewById(R.id.switch_darkmode);

        num0 = findViewById(R.id.btn_num0);
        num1 = findViewById(R.id.btn_num1);
        num2 = findViewById(R.id.btn_num2);
        num3 = findViewById(R.id.btn_num3);
        num4 = findViewById(R.id.btn_num4);
        num5 = findViewById(R.id.btn_num5);
        num6 = findViewById(R.id.btn_num6);
        num7 = findViewById(R.id.btn_num7);
        num8 = findViewById(R.id.btn_num8);
        num9 = findViewById(R.id.btn_num9);

        btndiv = findViewById(R.id.btn_num_div);
        btndot = findViewById(R.id.btn_num_dot);
        btnmin = findViewById(R.id.btn_num_minus);
        btnmult = findViewById(R.id.btn_num_mult);
        btnplus = findViewById(R.id.btn_num_plus);
        btnclr = findViewById(R.id.btn_clear);
        btnbks = findViewById(R.id.btn_backspace);
        btnequal = findViewById(R.id.btn_equal);

        if(compoundButton.getText().toString().equals("aA+") && isChecked){

            siaopt.setTextSize(28);
            darkopt.setTextSize(28);

            operacao.setTextSize(60);
            resultado.setTextSize(45);

            num0.setTextSize(48);
            num1.setTextSize(48);
            num2.setTextSize(48);
            num3.setTextSize(48);
            num4.setTextSize(48);
            num5.setTextSize(48);
            num6.setTextSize(48);
            num7.setTextSize(48);
            num8.setTextSize(48);
            num9.setTextSize(48);

            btndiv.setTextSize(48);
            btndot.setTextSize(48);
            btnmin.setTextSize(48);
            btnmult.setTextSize(48);
            btnplus.setTextSize(48);
            btnclr.setTextSize(48);
            btnbks.setTextSize(48);
            btnequal.setTextSize(48);

            Toast toast = Toast.makeText(this, "Ligou A+", Toast.LENGTH_SHORT);
            toast.show();
        } else if(compoundButton.getText().toString().equals("aA+") && !isChecked){

            siaopt.setTextSize(25);
            darkopt.setTextSize(25);

            operacao.setTextSize(50);
            resultado.setTextSize(35);

            num0.setTextSize(28);
            num1.setTextSize(28);
            num2.setTextSize(28);
            num3.setTextSize(28);
            num4.setTextSize(28);
            num5.setTextSize(28);
            num6.setTextSize(28);
            num7.setTextSize(28);
            num8.setTextSize(28);
            num9.setTextSize(28);

            btndiv.setTextSize(28);
            btndot.setTextSize(28);
            btnmin.setTextSize(28);
            btnmult.setTextSize(28);
            btnplus.setTextSize(28);
            btnclr.setTextSize(28);
            btnbks.setTextSize(28);
            btnequal.setTextSize(28);

            Toast toast = Toast.makeText(this, "Desligou A+", Toast.LENGTH_SHORT);
            toast.show();
        }

        if(compoundButton.getText().toString().equals("Modo escuro/claro") && isChecked){

            num0.setBackgroundColor(getResources().getColor(R.color.darkgray));
            num1.setBackgroundColor(getResources().getColor(R.color.darkgray));
            num2.setBackgroundColor(getResources().getColor(R.color.darkgray));
            num3.setBackgroundColor(getResources().getColor(R.color.darkgray));
            num4.setBackgroundColor(getResources().getColor(R.color.darkgray));
            num5.setBackgroundColor(getResources().getColor(R.color.darkgray));
            num6.setBackgroundColor(getResources().getColor(R.color.darkgray));
            num7.setBackgroundColor(getResources().getColor(R.color.darkgray));
            num8.setBackgroundColor(getResources().getColor(R.color.darkgray));
            num9.setBackgroundColor(getResources().getColor(R.color.darkgray));

            num0.setTextColor(getResources().getColor(R.color.white));
            num1.setTextColor(getResources().getColor(R.color.white));
            num2.setTextColor(getResources().getColor(R.color.white));
            num3.setTextColor(getResources().getColor(R.color.white));
            num4.setTextColor(getResources().getColor(R.color.white));
            num5.setTextColor(getResources().getColor(R.color.white));
            num6.setTextColor(getResources().getColor(R.color.white));
            num7.setTextColor(getResources().getColor(R.color.white));
            num8.setTextColor(getResources().getColor(R.color.white));
            num9.setTextColor(getResources().getColor(R.color.white));

            btndiv.setBackgroundColor(getResources().getColor(R.color.orangedark));
            btndot.setBackgroundColor(getResources().getColor(R.color.orangedark));
            btnmin.setBackgroundColor(getResources().getColor(R.color.orangedark));
            btnmult.setBackgroundColor(getResources().getColor(R.color.orangedark));
            btnplus.setBackgroundColor(getResources().getColor(R.color.orangedark));
            btnclr.setBackgroundColor(getResources().getColor(R.color.orangedark));
            btnbks.setBackgroundColor(getResources().getColor(R.color.orangedark));
            btnequal.setBackgroundColor(getResources().getColor(R.color.orangedark));

            btndiv.setTextColor(getResources().getColor(R.color.white));
            btndot.setTextColor(getResources().getColor(R.color.white));
            btnmin.setTextColor(getResources().getColor(R.color.white));
            btnmult.setTextColor(getResources().getColor(R.color.white));
            btnplus.setTextColor(getResources().getColor(R.color.white));
            btnclr.setTextColor(getResources().getColor(R.color.white));
            btnbks.setTextColor(getResources().getColor(R.color.white));
            btnequal.setTextColor(getResources().getColor(R.color.white));

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            Toast toast = Toast.makeText(this, "Ligou Dark", Toast.LENGTH_SHORT);
            toast.show();
        } else if (compoundButton.getText().toString().equals("Modo escuro/claro") && !isChecked) {

            num0.setBackgroundColor(getResources().getColor(R.color.lightgray));
            num1.setBackgroundColor(getResources().getColor(R.color.lightgray));
            num2.setBackgroundColor(getResources().getColor(R.color.lightgray));
            num3.setBackgroundColor(getResources().getColor(R.color.lightgray));
            num4.setBackgroundColor(getResources().getColor(R.color.lightgray));
            num5.setBackgroundColor(getResources().getColor(R.color.lightgray));
            num6.setBackgroundColor(getResources().getColor(R.color.lightgray));
            num7.setBackgroundColor(getResources().getColor(R.color.lightgray));
            num8.setBackgroundColor(getResources().getColor(R.color.lightgray));
            num9.setBackgroundColor(getResources().getColor(R.color.lightgray));

            num0.setTextColor(getResources().getColor(R.color.black));
            num1.setTextColor(getResources().getColor(R.color.black));
            num2.setTextColor(getResources().getColor(R.color.black));
            num3.setTextColor(getResources().getColor(R.color.black));
            num4.setTextColor(getResources().getColor(R.color.black));
            num5.setTextColor(getResources().getColor(R.color.black));
            num6.setTextColor(getResources().getColor(R.color.black));
            num7.setTextColor(getResources().getColor(R.color.black));
            num8.setTextColor(getResources().getColor(R.color.black));
            num9.setTextColor(getResources().getColor(R.color.black));

            btndiv.setBackgroundColor(getResources().getColor(R.color.orangelight));
            btndot.setBackgroundColor(getResources().getColor(R.color.orangelight));
            btnmin.setBackgroundColor(getResources().getColor(R.color.orangelight));
            btnmult.setBackgroundColor(getResources().getColor(R.color.orangelight));
            btnplus.setBackgroundColor(getResources().getColor(R.color.orangelight));
            btnclr.setBackgroundColor(getResources().getColor(R.color.orangelight));
            btnbks.setBackgroundColor(getResources().getColor(R.color.orangelight));
            btnequal.setBackgroundColor(getResources().getColor(R.color.orangelight));

            btndiv.setTextColor(getResources().getColor(R.color.black));
            btndot.setTextColor(getResources().getColor(R.color.black));
            btnmin.setTextColor(getResources().getColor(R.color.black));
            btnmult.setTextColor(getResources().getColor(R.color.black));
            btnplus.setTextColor(getResources().getColor(R.color.black));
            btnclr.setTextColor(getResources().getColor(R.color.black));
            btnbks.setTextColor(getResources().getColor(R.color.black));
            btnequal.setTextColor(getResources().getColor(R.color.black));

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            Toast toast = Toast.makeText(this, "Desligou Dark", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
