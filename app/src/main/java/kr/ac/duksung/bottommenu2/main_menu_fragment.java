package kr.ac.duksung.bottommenu2;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class main_menu_fragment extends Fragment {



    public main_menu_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment main_menu_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static main_menu_fragment newInstance(String param1, String param2) {
        main_menu_fragment fragment = new main_menu_fragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_menu_fragment, container, false);


        Button form_list_button1 = (Button) rootView.findViewById(R.id.form_list_1);
        Button form_list_button2 = (Button) rootView.findViewById(R.id.form_list_2);
        Button form_list_button3 = (Button) rootView.findViewById(R.id.form_list_3);
        Button form_list_button4 = (Button) rootView.findViewById(R.id.form_list_4);




        form_list_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("button", ": 1 on Click 작동");
                Toast tMsg = Toast.makeText(rootView.getContext(),"버튼1",Toast.LENGTH_SHORT);
                tMsg.show();

            }
        });

        form_list_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Button color
                form_list_button1.setBackgroundResource(R.color.transparent);
                form_list_button2.setBackgroundResource(R.drawable.category_selected);
                form_list_button3.setBackgroundResource(R.color.transparent);
                form_list_button4.setBackgroundResource(R.color.transparent);

                // text color
                form_list_button1.setTextColor(ContextCompat.getColor(rootView.getContext(), R.color.black));
                form_list_button2.setTextColor(ContextCompat.getColor(rootView.getContext(), R.color.white));
                form_list_button3.setTextColor(ContextCompat.getColor(rootView.getContext(), R.color.black));
                form_list_button4.setTextColor(ContextCompat.getColor(rootView.getContext(), R.color.black));

                Toast tMsg = Toast.makeText(rootView.getContext(),"버튼2",Toast.LENGTH_SHORT);
            }
        });

        form_list_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast tMsg = Toast.makeText(rootView.getContext(),"버튼3",Toast.LENGTH_SHORT);
            }
        });

        form_list_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast tMsg = Toast.makeText(rootView.getContext(),"버튼4",Toast.LENGTH_SHORT);
            }
        });

        return rootView;

    }

    private void setBtnColor(){

    }
/*
    private void initTransactionEvent() {

        final FirstFragment firstFragment = new FirstFragment();
        final SecondFragment secondFragment = new SecondFragment();
        final ThirdFragment thirdFragment = new ThirdFragment();
        final FourthFragment fourthFragment = new FourthFragment();

        Button form_list_button1 = (Button) findViewById(R.id.form_list_1);
        Button form_list_button2 = (Button) findViewById(R.id.form_list_2);
        Button form_list_button3 = (Button) findViewById(R.id.form_list_3);
        Button form_list_button4 = (Button) findViewById(R.id.form_list_4);


        getSupportFragmentManager().beginTransaction().add(R.id.form_list_fv, firstFragment).commit();


        form_list_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Button color
                form_list_button1.setBackgroundResource(R.drawable.category_selected);
                form_list_button2.setBackgroundResource(R.color.transparent);
                form_list_button3.setBackgroundResource(R.color.transparent);
                form_list_button4.setBackgroundResource(R.color.transparent);

                // text color
                form_list_button1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                form_list_button2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                form_list_button3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                form_list_button4.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.form_list_fv, firstFragment);
                transaction.commit();
            }
        });

        form_list_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Button color
                form_list_button1.setBackgroundResource(R.color.transparent);
                form_list_button2.setBackgroundResource(R.drawable.category_selected);
                form_list_button3.setBackgroundResource(R.color.transparent);
                form_list_button4.setBackgroundResource(R.color.transparent);

                // text color
                form_list_button1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                form_list_button2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                form_list_button3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                form_list_button4.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.form_list_fv, secondFragment);
                transaction.commit();
            }
        });

        form_list_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Button color
                form_list_button1.setBackgroundResource(R.color.transparent);
                form_list_button2.setBackgroundResource(R.color.transparent);
                form_list_button3.setBackgroundResource(R.drawable.category_selected);
                form_list_button4.setBackgroundResource(R.color.transparent);

                // text color
                form_list_button1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                form_list_button2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                form_list_button3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                form_list_button4.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.form_list_fv, thirdFragment);
                transaction.commit();
            }
        });

        form_list_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Button color
                form_list_button1.setBackgroundResource(R.color.transparent);
                form_list_button2.setBackgroundResource(R.color.transparent);
                form_list_button3.setBackgroundResource(R.color.transparent);
                form_list_button4.setBackgroundResource(R.drawable.category_selected);

                // text color
                form_list_button1.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                form_list_button2.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                form_list_button3.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                form_list_button4.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.form_list_fv, fourthFragment);
                transaction.commit();
            }
        });
    }*/


}