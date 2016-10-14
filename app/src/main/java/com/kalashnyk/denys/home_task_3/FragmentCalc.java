package com.kalashnyk.denys.home_task_3;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

//    import android.support.v4.app.Fragment;

/**
 * Created by User on 29.06.2016.
 */
 //Создание кнопок на фрагменте
public class FragmentCalc extends Fragment implements View.OnClickListener {

    EditText display;
    Button equalse;
    Button zero;
    Button doubleBtn;
    Button clear;
    Button plus;
    Button one;
    Button two;
    Button three;
    Button minus;
    Button four;
    Button five;
    Button six;
    Button increase;
    Button seven;
    Button eight;
    Button nine;
    Button divide;

    ResulFragment fragmentResult;
    FragmentTransaction fm;

    double firstValue = 0.0;
    String operation = "";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_calc, null);

        fragmentResult = new ResulFragment();
		
        display = (EditText)v.findViewById(R.id.display);
        zero = (Button)v.findViewById(R.id.btn_zero);
        equalse = (Button)v.findViewById(R.id.btn_equalse);
        doubleBtn = (Button)v.findViewById(R.id.btn_duoble);
        clear = (Button)v.findViewById(R.id.btn_clear);
        plus = (Button)v.findViewById(R.id.btn_plus);
        one = (Button)v.findViewById(R.id.btn_one);
        two = (Button)v.findViewById(R.id.btn_two);
        three = (Button)v.findViewById(R.id.btn_three);
        minus = (Button)v.findViewById(R.id.btn_minus);
        four = (Button)v.findViewById(R.id.btn_four);
        five = (Button)v.findViewById(R.id.btn_five);
        six = (Button)v.findViewById(R.id.btn_six);
        increase = (Button)v.findViewById(R.id.btn_increase);
        seven = (Button)v.findViewById(R.id.btn_seven);
        eight = (Button)v.findViewById(R.id.btn_eight);
        nine = (Button)v.findViewById(R.id.btn_nine);
        divide = (Button)v.findViewById(R.id.btn_divide);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        clear.setOnClickListener(this);
        doubleBtn.setOnClickListener(this);
        equalse.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        increase.setOnClickListener(this);
        divide.setOnClickListener(this);
        return v;
    }

	//Изменение значения Display в зависимости от нажатия кнопок
	//Выполнение арифметических операций
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_zero:
                checkSymbol();
                display.setText(display.getText().toString() + "0");
                break;
            case R.id.btn_one:
                checkSymbol();
                display.setText(display.getText().toString()+"1");
                break;
            case R.id.btn_two:
                checkSymbol();
                display.setText(display.getText().toString()+"2");
                break;
            case R.id.btn_three:
                checkSymbol();
                display.setText(display.getText().toString()+"3");
                break;
            case R.id.btn_four:
                checkSymbol();
                display.setText(display.getText().toString()+"4");
                break;
            case R.id.btn_five:
                checkSymbol();
                display.setText(display.getText().toString()+"5");
                break;
            case R.id.btn_six:
                checkSymbol();
                display.setText(display.getText().toString()+"6");
                break;
            case R.id.btn_seven:
                checkSymbol();
                display.setText(display.getText().toString()+"7");
                break;
            case R.id.btn_eight:
                checkSymbol();
                display.setText(display.getText().toString()+"8");
                break;
            case R.id.btn_nine:
                checkSymbol();
                display.setText(display.getText().toString()+"9");
                break;
            case R.id.btn_equalse:
                double secondValue = Double.valueOf(display.getText().toString());
                if("+".equals(operation)){
                    MainActivity.result = firstValue + secondValue;
                }
                if("-".equals(operation)){
                    MainActivity.result = firstValue - secondValue;
                }
                if("*".equals(operation)){
                    MainActivity.result = firstValue * secondValue;
                }
                if("/".equals(operation)){
                    MainActivity.result = firstValue / secondValue;
                }
                display.setText(Double.toString(MainActivity.result));
                responseDate();
                break;
            case R.id.btn_clear:
                display.setText("");
                break;
            case R.id.btn_duoble:
                display.setText(".");
                break;
            case R.id.btn_plus:
                try{
                firstValue = Double.valueOf(display.getText().toString());
                } catch (NumberFormatException e) {}
                display.setText("+");
                operation = "+";
                break;
            case R.id.btn_minus:
                try{
                firstValue = Double.valueOf(display.getText().toString());
                } catch (NumberFormatException e) {}
                display.setText(("-"));
                operation = "-";
                break;
            case R.id.btn_increase:
                try {
                    firstValue = Double.valueOf(display.getText().toString());
                } catch (NumberFormatException e) {}
                display.setText("*");
                operation = "*";
                break;
            case R.id.btn_divide:
                try {
                firstValue = Double.valueOf(display.getText().toString());
                } catch (NumberFormatException e) {}
                display.setText("/");
                operation = "/";
                break;
            default:
                break;
        }
    }
	
	//Если нажатая клавивиша -- арифм. оп., то очищаем поле ввода (для ввода второго числа)
    private void checkSymbol()
    {
        if(display.getText().toString().contains("/")||
                display.getText().toString().contains("*")||
                display.getText().toString().contains("+")||
                display.getText().toString().contains("-"))
        {
            display.setText("");
        }
    }
	
	//Создание фрагмента с последующей заменой текущего на новый
    private void responseDate()
    {
        ResulFragment fragmentResul = new ResulFragment();
        fm = getFragmentManager().beginTransaction();
        fm.replace(R.id.container, fragmentResul);
        fm.addToBackStack(null);
        fm.commit();
    }
}
