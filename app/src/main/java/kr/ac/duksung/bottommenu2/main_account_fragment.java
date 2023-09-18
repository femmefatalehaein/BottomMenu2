package kr.ac.duksung.bottommenu2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link main_account_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class main_account_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView qrtext;

    public main_account_fragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment main_account_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static main_account_fragment newInstance(String param1, String param2) {
        main_account_fragment fragment = new main_account_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        Intent intent = new Intent();
        String qr = intent.getStringExtra("qr");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_account_fragment, container, false);
        ImageView treeImageView = view.findViewById(R.id.account_tree_iv);

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

        return view;
    }
}