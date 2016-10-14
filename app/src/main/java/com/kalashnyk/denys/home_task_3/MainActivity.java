package com.kalashnyk.denys.home_task_3;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    public static double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		//Создание тулбара
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		//Помещаем тубар  в экшнбар
        setSupportActionBar(toolbar);
		
		//Получаем FragmentManager
        FragmentManager fragmentManager = getFragmentManager();
		//Начало операции замены фрагмента
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		//Создание нового фрагмента (калькулятора)
        FragmentCalc fragmentCalc = new FragmentCalc();
		//добавяем фрагмент без пользовательского интерфейса на Activity
        fragmentTransaction.add(R.id.container, fragmentCalc);
		//Нужно, чтобы изменения вступили в силу
        fragmentTransaction.commit();
    }
}
