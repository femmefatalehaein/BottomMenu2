package kr.ac.duksung.bottommenu2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private ArrayList<MenuItem> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_menu_korean_rv);

        list = MenuItem.createContactsList(10);
        recyclerView.setHasFixedSize(true);
        adapter = new MenuAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        Log.d("Frag", "MainFragment");
        return rootView;
    }
}