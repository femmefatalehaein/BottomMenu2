package kr.ac.duksung.bottommenu2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.Holder> {
    private Context context;
    private List<MenuItem> list = new ArrayList<>();

    public MenuAdapter(Context context, List<MenuItem> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_menu_item, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    /*
     * Todo 만들어진 ViewHolder에 data 삽입 ListView의 getView와 동일
     *
     * */
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;
        holder.name.setText(list.get(itemposition).name);
        holder.price.setText(list.get(itemposition).price);
        holder.benefit.setText(list.get(itemposition).benefit);
        Log.d("StudyApp", "onBindViewHolder" + itemposition);
    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView price;
        public TextView benefit;

        public Holder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.menu_item_name_tv);
            price = (TextView) view.findViewById(R.id.menu_item_price_sub_tv);
            benefit = (TextView) view.findViewById(R.id.menu_item_package_sub_tv);
        }
    }
}
