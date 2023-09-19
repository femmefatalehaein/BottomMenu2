package kr.ac.duksung.bottommenu2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class main_account_fragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main_account_fragment, container, false);
        ImageView treeImageView = rootView.findViewById(R.id.account_tree_iv);

        // 가상의 리워드 값
        int rewardValue = 250; // 임의로 설정

        // 리워드 값에 따라 다른 이미지 설정
        if (rewardValue >= 0 && rewardValue < 100) {
            treeImageView.setImageResource(R.drawable.ic_seed);
        } else if (rewardValue >= 100 && rewardValue < 200) {
            treeImageView.setImageResource(R.drawable.ic_sprout);
        } else if (rewardValue >= 200 && rewardValue < 300) {
            treeImageView.setImageResource(R.drawable.ic_small_tree);
        } else if (rewardValue >= 300 && rewardValue < 400) {
            treeImageView.setImageResource(R.drawable.ic_tree);
        } else if (rewardValue >= 400 && rewardValue < 500) {
            treeImageView.setImageResource(R.drawable.ic_apple_tree);
        } else {
            // 기본 이미지 설정
            treeImageView.setImageResource(R.drawable.ic_seed);
        }

        return rootView;

    }
}