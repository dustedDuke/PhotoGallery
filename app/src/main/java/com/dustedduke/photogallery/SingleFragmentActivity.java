package com.dustedduke.photogallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dustedduke on 27.07.17.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer); //Запрос фрагмента с идентификатором контейнерного представления

        if(fragment == null) {
            fragment = createFragment();

            //Создание и закрепление транзакции фрагмента
            fm.beginTransaction()   //Создать новую транзакцию фрагмента
                    .add(R.id.fragmentContainer, fragment) //Включить в транзикцию операцию add
                    .commit(); //Закрепить
        }
    }

}
