package com.app.sherafat.ali.tizmaghz;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
    String [] textItems;
    Context context;
    int [] imageItems;
    private static LayoutInflater inflater=null;
    public CustomAdapter(Enhanced mainActivity, String[] prgmNameList, int[] prgmImages) {
        textItems =prgmNameList;
        context=mainActivity;
        imageItems =prgmImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // Typeface yekan= Typeface.createFromAsset(context.getAssets(), "fonts/yekan.ttf");


    }
    @Override
    public int getCount() {
        return textItems.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView textView;
        ImageView imageView;
    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.program_list, null);
        holder.textView =(TextView) rowView.findViewById(R.id.textView1);
        holder.imageView =(ImageView) rowView.findViewById(R.id.imageView1);
        holder.textView.setText(textItems[position]);
        holder.textView.setTypeface(G.yekan);
        holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        holder.imageView.setImageResource(imageItems[position]);
/*
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context, "You Clicked "+ textItems[position], Toast.LENGTH_LONG).show();
                if (position == 2) {

                    Intent intent= new Intent(CustomAdapter.this,nnn.class);


                }
            }
        });
        */
        return rowView;
    }

}