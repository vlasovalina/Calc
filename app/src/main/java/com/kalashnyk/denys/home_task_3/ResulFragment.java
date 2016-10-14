package com.kalashnyk.denys.home_task_3;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
//    import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
/**
 * Created by User on 29.06.2016.
 */
 // Создаем свой фрагмент, наследник Fragment
public class ResulFragment extends Fragment {
    Button back;
    TextView res;
	//API для работы с фрагментами
    FragmentTransaction fm;
    @Override
	//Создание фрагмента
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.fragment_result,  null);
        res = (TextView) v.findViewById(R.id.txt_result);
        back = (Button) v.findViewById(R.id.btn_back);
        String calcResult = String.valueOf(MainActivity.result);
        res.setText(calcResult);
		//Лямбда-функция для обработки нажатия на кнопку Back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
				//Возвращаемся к предыдущему фрагменту и удаляем его из стека
                getFragmentManager().popBackStack();
            }
        });
        return v;
    }
}
