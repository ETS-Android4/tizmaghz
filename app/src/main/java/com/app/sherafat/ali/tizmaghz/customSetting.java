package com.app.sherafat.ali.tizmaghz;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class customSetting extends LinearLayout {

    EditText editText;
    Button btnOk;
     LinearLayout lytContent ;
     LinearLayout lytButtons;
     TextView txtRight ;
     TextView txtLeft;
    Button btnCancel ;

    public customSetting(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializer(context);
    }


    public customSetting(Context context) {
        super(context);
        initializer(context);
    }


    private void initializer(final Context context) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customSetting = inflater.inflate(R.layout.custom_setting, this);

         lytContent = (LinearLayout) customSetting.findViewById(R.id.lytContent);
          lytButtons = (LinearLayout) customSetting.findViewById(R.id.lytButtons);

          txtRight = (TextView) customSetting.findViewById(R.id.txtRight);
          txtLeft = (TextView) customSetting.findViewById(R.id.txtLeft);
         btnCancel = (Button) customSetting.findViewById(R.id.btnCancel);
        btnOk = (Button) customSetting.findViewById(R.id.btnOk);
        editText = (EditText) customSetting.findViewById(R.id.editText);

        lytContent.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.shrink_to_middle);
                animation.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }


                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }


                    @Override
                    public void onAnimationEnd(Animation animation) {
                        lytContent.setVisibility(View.GONE);
                        lytButtons.setVisibility(View.VISIBLE);
                    }
                });

                lytContent.startAnimation(animation);
            }
        });

        btnCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.shrink_to_middle);
                animation2.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }


                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }


                    @Override
                    public void onAnimationEnd(Animation animation) {
                        lytContent.setVisibility(View.VISIBLE);
                        lytButtons.setVisibility(View.GONE);
                    }
                });
                lytButtons.startAnimation(animation2);
            }
        });

    }

}


/*
        btnOk.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.shrink_to_middle);
                animation2.setAnimationListener(new AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }


                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }


                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(G.context,""+ editText.getText().toString(),Toast.LENGTH_SHORT).show();
                        txtRight.setText("Click on ok button");
                        lytContent.setVisibility(View.VISIBLE);
                        lytButtons.setVisibility(View.GONE);
                    }
                });
                lytButtons.startAnimation(animation2);
            }
        });
*/
