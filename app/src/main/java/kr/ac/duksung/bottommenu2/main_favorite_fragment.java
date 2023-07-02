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

public class main_favorite_fragment extends Fragment {

    private RecyclerView recyclerView;
    private FavoriteAdapter adapter;
    private ArrayList<FavoriteItem> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main_favorite_fragment, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.favorite_rv);

        list = FavoriteItem.createContactsList(10);
        recyclerView.setHasFixedSize(true);
        adapter = new FavoriteAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        Log.d("Frag", "MainFragment");
        return rootView;
    }
}