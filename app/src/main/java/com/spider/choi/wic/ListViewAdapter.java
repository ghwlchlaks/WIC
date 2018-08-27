package com.spider.choi.wic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.spider.choi.wic.ListViewItem;
import com.spider.choi.wic.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter{

    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    //listViewAdapter 생성자
    public ListViewAdapter(){

    }

    //adapter에 사용되는 데이터의 개수를 리턴
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    //지정한 position에 있는 데이터 리턴
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    //지정한 position에 있는 데이터와 관계된 아이템의 id를 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 view를 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //listview_item.xml layout을 inflate하여 convertView참조 획득
        if(convertView == null ){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        //참조획득
        ImageView iconImageView = (ImageView)convertView.findViewById(R.id.userImage);
        TextView titleTextView = (TextView)convertView.findViewById(R.id.title);
        TextView heartCountTextView = (TextView)convertView.findViewById(R.id.heartCount);
        TextView likeCountTextView =(TextView)convertView.findViewById(R.id.likeCount);

        // listViewItemList 에서 position에 위치한 데이터 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        //아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getIconDrawable());
        titleTextView.setText(listViewItem.getTitleStr());
        heartCountTextView.setText(listViewItem.getHeartCount());
        likeCountTextView.setText(listViewItem.getLikeCount());

        return convertView;
    }

    // 아이템 데이터를 추가를 위한 함수
    public void addItem(Drawable icon, String title, String heartCount, String likeCount) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setHeartCount(heartCount);
        item.setLikeCount(likeCount);

        listViewItemList.add(item);
    }
}
