package com.app.sherafat.ali.tizmaghz;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class PagerAdapter extends FragmentPagerAdapter {
    Boolean help = G.preferences.getBoolean("HELP",true);

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
            if (!help) {
        switch (position) {
                case 0:
                    return "تیز مغز";
                case 1:
                    return "فکر کردن";
                case 2:
                    return "محاسبه با سرعت بالا";
                case 3:
                    return "محاسبه با سرعت پایین";
                case 4:
                    return "محاسبات دشوار";
                case 5:
                    return "تماشای تلویزیون";
                case 6:
                    return "نوشتن";
                case 7:
                    return "مطالعه بدون تلفظ";
                case 8:
                    return "مطالعه با صدای بلند";
                default:
                    return "...";
            }
        }else {
                switch (position) {
                    case 0:
                        return "آزمون های روزانه";
                    case 1:
                        return "آزمون حفظ لغت";
                    case 2:
                        return "آزمون استروپ";
                    case 3:
                        return "...";
                    default:
                        return "...";
                }
            }
    }


    @Override
    public Fragment getItem(int position) {
        if (!help) {
            switch (position) {
                case 0:
                    return FragmentA.instance(1);
                case 1:
                    return FragmentA.instance(2);
                case 2:
                    return FragmentA.instance(3);
                case 3:
                    return FragmentA.instance(4);
                case 4:
                    return FragmentA.instance(5);
                case 5:
                    return FragmentA.instance(6);
                case 6:
                    return FragmentA.instance(7);
                case 7:
                    return FragmentA.instance(8);
                case 8:
                    return FragmentA.instance(9);
                default:
                    return FragmentA.instance(1);
            }
        }else {
            switch (position) {
                case 0:
                    return FragmentA.instance(1);
                case 1:
                    return FragmentA.instance(2);
                case 2:
                    return FragmentA.instance(3);
                case 3:
                    return FragmentA.instance(4);
                default:
                    return FragmentA.instance(1);
            }

        }

    }


    @Override
    public int getCount() {
        if (!help){
        return 9;
        }else {
            return 4;
        }
    }

}