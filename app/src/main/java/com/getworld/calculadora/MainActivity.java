package com.getworld.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito,numeroNove,
    ponto, multiplicacao, divisao, soma, igual, botao_Limpar, porcentagem, subtracao;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponente();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);

        soma.setOnClickListener(this);
        ponto.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        //porcentagem.setOnClickListener(this);

        botao_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");

            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;

                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);

                }
                txtResultado.setText("");

            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    Expression expressao = new  ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    //double resultado = expressao + (porcentagem * expressao);
                    long longResult = (long) resultado;

                    if(resultado == (double) longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));

                    }else{

                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }

                }catch (Exception e){

                }

            }
        });

    }

    private void IniciarComponente(){

        numeroZero = findViewById(R.id.mumero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.mumero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.mumero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.mumero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        subtracao = findViewById(R.id.subtracao);
        divisao = findViewById(R.id.divisao);
        soma = findViewById(R.id.soma);
        multiplicacao = findViewById(R.id.multiplicacao);
        igual = findViewById(R.id.igual);
        botao_Limpar = findViewById(R.id.bt_limpar);
        backspace = findViewById(R.id.backspace);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado =findViewById(R.id.txt_resultado);
        //porcentagem = findViewById(R.id.porcentagem);



    }

    public void AcressentarUmaExpressao(String string, boolean limpar_dados){
        

        if(txtResultado.getText().equals("")){

            txtExpressao.setText(" ");

        }

        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);

        }else {

            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.mumero_zero:
                AcressentarUmaExpressao("0", true);
                break;

            case R.id.numero_um:
                AcressentarUmaExpressao("1", true);
                break;

            case R.id.mumero_dois:
                AcressentarUmaExpressao("2", true);
                break;


            case R.id.numero_tres:
                AcressentarUmaExpressao("3", true);
                break;


            case R.id.numero_quatro:
                AcressentarUmaExpressao("4", true);
                break;

            case R.id.mumero_cinco:
                AcressentarUmaExpressao("5", true);
                break;

            case R.id.numero_seis:
                AcressentarUmaExpressao("6", true);
                break;


            case R.id.numero_sete:
                AcressentarUmaExpressao("7", true);
                break;

            case R.id.mumero_oito:
                AcressentarUmaExpressao("8", true);
                break;


            case R.id.numero_nove:
                AcressentarUmaExpressao("9", true);
                break;


            case R.id.ponto:
                AcressentarUmaExpressao(".", true);
                break;

            case R.id.soma:
                AcressentarUmaExpressao("+", false);
                break;

            case R.id.subtracao:
                AcressentarUmaExpressao("-", false);
                break;

            case R.id.divisao:
                AcressentarUmaExpressao("/", false);
                break;

            /*case R.id.porcentagem:
                AcressentarUmaExpressao("%", false);
                break;*/

            case R.id.multiplicacao:
                AcressentarUmaExpressao("*", false);
                break;

        }
    }
}