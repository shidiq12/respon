package com.gmail1998milatisidik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter<item> {

    private List<item> playerItemList;

    private Context context;

    public ListViewAdapter(List<item> playerItemList, Context context) {
        super(context, R.layout.activity_daftar, playerItemList);
        this.playerItemList = playerItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.activity_daftar, null, true);

        TextView textViewNo = listViewItem.findViewById(R.id.no);
        TextView textViewName = listViewItem.findViewById(R.id.name);
        TextView textViewPosition = listViewItem.findViewById(R.id.jurusan);
        TextView textViewBirth_date = listViewItem.findViewById(R.id.universitas);
        ImageView imgVIew = listViewItem.findViewById(R.id.daftar);


        item playerItem = playerItemList.get(position);

        textViewNo.setText(playerItem.getNo());
        textViewName.setText(playerItem.getName());
        textViewBirth_date.setText(playerItem.getUniversitas());
        textViewPosition.setText(playerItem.getJurusan());

        Glide.with(context).load(playerItem.getDaftar()).into(imgVIew);

        return listViewItem;
    }
}