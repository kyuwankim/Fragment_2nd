package com.kyuwankim.android.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListFragment list;
    DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createFragments();
        addList();


    }

    public void addDetail() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame, detail);
        // transaction 처리 전체를 stack에 담아놨다가 안드로이드의 back 버튼으로 뒤로가기를 할 수 있다
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void addList() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame, list);
        transaction.addToBackStack(null);
        transaction.commit();
    }



    public void createFragments() {
        list = new ListFragment();
        list.setActivity(this);
        detail = new DetailFragment();
        detail.setActivity(this);
    }

    public void backToList() {
        super.onBackPressed();
    }
}
