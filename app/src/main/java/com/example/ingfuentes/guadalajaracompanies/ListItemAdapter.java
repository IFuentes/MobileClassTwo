package com.example.ingfuentes.guadalajaracompanies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/** Created by Ing. Fuentes on 15/11/2014. */
public class ListItemAdapter extends BaseAdapter{
    //private Context mContext = null;
    private ArrayList <ListItem> mArrayList = null;
    private LayoutInflater mLayoutInflater = null;

    public ListItemAdapter(Context context, ArrayList<ListItem> arrayList){
        //mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mArrayList= arrayList;
    }
    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return mArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static  class Holder{
        //aqui viene el contenido de la celda
        ImageView imgCompany;
        TextView txtCompanyName;
        TextView txtCompanyGiro;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //agregamos el siguiente codigo
        Holder holder;
        View view = convertView;
        //we are going to check if view is not null
        if (view == null){
            holder =  new Holder();
            view = mLayoutInflater.inflate(R.layout.list_item,null);
            holder.imgCompany = (ImageView)view.findViewById(R.id.imgCompany);
            holder.txtCompanyName =(TextView)view.findViewById(R.id.txtCompanyName);
            holder.txtCompanyGiro =(TextView)view.findViewById(R.id.txtCompanyGiro);
            view.setTag(holder);
        }
        else
        {
            //si ya existe solo lo llamamos
            holder = (Holder)view.getTag();
        }

        holder.imgCompany.setImageDrawable(mArrayList.get(position).getImgCompany());
        holder.txtCompanyName.setText(mArrayList.get(position).getTxtCompanyName());
        holder.txtCompanyGiro.setText(mArrayList.get(position).getTxtCompanyGiro());
        return view;
    }
}
