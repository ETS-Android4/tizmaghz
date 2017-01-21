package com.app.sherafat.ali.tizmaghz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentA extends Fragment {
    Boolean help = G.preferences.getBoolean("HELP",true);

    private ViewGroup layout;


    public static Fragment instance(int catId) {
        Fragment fragment = new FragmentA();

        Bundle data = new Bundle();
        data.putInt("catId", catId);
        fragment.setArguments(data);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = (ViewGroup) inflater.inflate(R.layout.fragment_tiz_maghz, null);
        return layout;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
        TextView textView  = (TextView) layout.findViewById(R.id.textView);
        textView.setLineSpacing(20, 1);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        textView.setTypeface(G.kamran);
        if (!help) {
            switch (getArguments().getInt("catId")) {
                case 1:
                    imageView.setImageResource(R.mipmap.tiz);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.tiz_intro)));
                    textView.setTypeface(G.mitra);
                    break;
                case 2:
                    imageView.setImageResource(R.mipmap.help1);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.tiz_1)));
                    break;
                case 3:
                    imageView.setImageResource(R.mipmap.help2);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.tiz_2)));
                    break;

                case 4:
                    imageView.setImageResource(R.mipmap.help3);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.tiz_3)));
                    break;

                case 5:
                    imageView.setImageResource(R.mipmap.help4);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.tiz_4)));
                    break;
                case 6:
                    imageView.setImageResource(R.mipmap.help5);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.tiz_5)));
                    break;
                case 7:
                    imageView.setImageResource(R.mipmap.help6);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.tiz_6)));
                    break;
                case 8:
                    imageView.setImageResource(R.mipmap.help7);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.tiz_7)));
                    break;
                case 9:
                    imageView.setImageResource(R.mipmap.help8);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.tiz_8)));
                    break;
            }
        }else {
            switch (getArguments().getInt("catId")) {
                case 1:
                    imageView.setImageResource(R.mipmap.daily);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.daily)));
                    break;
                case 2:
                    imageView.setImageResource(R.mipmap.memorize);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.memorize)));
                    break;
                case 3:
                    imageView.setImageResource(R.mipmap.strope);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.strope)));
                    break;

                case 4:
                    imageView.setImageResource(R.mipmap.four);
                    textView.setText(Html.fromHtml(getResources().getString(R.string.four)));
                    break;
            }
        }

    }
}
