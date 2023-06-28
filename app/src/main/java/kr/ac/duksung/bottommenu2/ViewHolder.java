package kr.ac.duksung.bottommenu2;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{

    public TextView textView;

    ViewHolder(Context context, View itemView){

        super(itemView);

        textView = itemView.findViewById(R.id.textview);


    }
}