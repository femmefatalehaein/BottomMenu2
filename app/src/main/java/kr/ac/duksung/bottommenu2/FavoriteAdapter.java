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

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.Holder>{
    private Context context;
    private List<FavoriteItem> list = new ArrayList<>();

    public FavoriteAdapter(Context context, List<FavoriteItem> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_favorite_item, parent, false);
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
        holder.menu.setText(list.get(itemposition).menu);
        holder.size.setText(list.get(itemposition).size);
        Log.d("FavoriteAdapter", "onBindViewHolder" + itemposition);
    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView menu;
        public TextView size;

        public Holder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.favorite_item_name_tv);
            menu = (TextView) view.findViewById(R.id.favorite_item_menu_sub_tv);
            size = (TextView) view.findViewById(R.id.favorite_item_size_sub_tv);
        }
    }
}
