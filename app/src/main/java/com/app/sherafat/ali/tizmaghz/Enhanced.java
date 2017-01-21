package com.app.sherafat.ali.tizmaghz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Enhanced extends AppCompatActivity {

    public ListView listView;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle drawerToggle;
    public String activityTitle;
    Context context;
    public static int [] prgmImages={R.drawable.statue,R.drawable.chart_black,R.drawable.brain_icon,R.drawable.setting,R.drawable.icon,R.drawable.send_email,R.drawable.help};
    public static String [] prgmNameList={"وضعیت","نمودار","تمرین آزاد","تنظیمات","تیز مغز","پیشنهادات","راهنما"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enhanced);
        context=this;
        listView = (ListView)findViewById(R.id.lstMenuItems);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        activityTitle = getTitle().toString();


        addDrawerItems();
        setupDrawer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Enhanced.this, MemorizeActivity.class));
            }
        });





    }
    public void addDrawerItems() {

        listView.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    final Dialog dialog = new Dialog(Enhanced.this);
                    dialog.setContentView(R.layout.dialog_progress);
                    dialog.setTitle("وضعیت شما...");
                    dialog.setCancelable(true);

                  final TextView txtDay= (TextView) dialog.findViewById(R.id.txtDsy);
                  final TextView txtPercent= (TextView) dialog.findViewById(R.id.txtPercent);
                  final ProgressBar prgDay= (ProgressBar) dialog.findViewById(R.id.prgDay);

                    int day = G.preferences.getInt("DAY",0);
                    int week = G.preferences.getInt("WEEK",-1);
                    int dayInWeek=day%5;
                    String dayInString="";
                    String weekInString="";
                    switch (dayInWeek){
                        case 0:
                            if (day==0) {
                                dayInString ="قبل از شروع";
                            }else {
                                dayInString ="پنجم";
                            }
                            break;
                        case 1:
                            dayInString ="اول";
                            break;
                        case 2:
                            dayInString ="دوم";
                            break;
                        case 3:
                            dayInString ="سوم";
                            break;
                        case 4:
                            dayInString ="چهارم";
                            break;
                    }
                    switch (week){
                        case -1:
                            weekInString="قبل از شروع دوره";
                            break;
                        case 0:
                                weekInString="اول";
                            break;
                        case 1:
                            weekInString="دوم";
                            break;
                        case 2:
                            weekInString="سوم";
                            break;
                        case 3:
                            weekInString="چهارم";
                            break;
                        case 4:
                            weekInString="پنجم";
                            break;
                        case 5:
                            weekInString="ششم";
                            break;
                        case 6:
                            weekInString="هفتم";
                            break;
                        case 7:
                            weekInString="هشتم";
                            break;
                        case 8:
                            weekInString="نهم";
                            break;
                        case 9:
                            weekInString="دهم";
                            break;
                        case 10:
                            weekInString="یازدهم";
                            break;
                        case 11:
                            weekInString="دوازدهم";
                            break;
                        case 12:
                            weekInString="پایان دوره";
                            break;
                    }
                    txtDay.setText("شما در روز " + dayInString + " از هفته ی "+ weekInString + " هستید :)");
                    int percent = (int) (day*1.66) +1;
                    txtPercent.setText("میزان پیشروی شما در دوره "+percent+" درصد است !");
                    prgDay.setProgress(day);
                    dialog.show();
                }

if (position==1){
    final Dialog dialog = new Dialog(Enhanced.this);
    dialog.setContentView(R.layout.dialog_chart);
    dialog.setTitle("نوع نمودار رو انتخاب کن ... ");
    dialog.setCancelable(true);

    final RadioButton rd1 = (RadioButton) dialog.findViewById(R.id.rd_1);
    final RadioButton rd2 = (RadioButton) dialog.findViewById(R.id.rd_2);
    final RadioButton rd3 = (RadioButton) dialog.findViewById(R.id.rd_3);
    ImageView imageView = (ImageView) dialog.findViewById(R.id.imageView);

    imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (rd1.isChecked()) {
                Intent intent = new Intent(Enhanced.this, ChartActivity.class);
                intent.putExtra("chart_view", 1);
                startActivity(intent);
                dialog.dismiss();
            }
            if (rd2.isChecked()) {
                Intent intent = new Intent(Enhanced.this, ChartActivity.class);
                intent.putExtra("chart_view", 2);
                startActivity(intent);
                dialog.dismiss();
            }
            if (rd3.isChecked()) {
                Intent intent = new Intent(Enhanced.this, ChartActivity.class);
                intent.putExtra("chart_view", 3);
                startActivity(intent);
                dialog.dismiss();
            }
        }
    });

    dialog.show();


}
                if (position==2){

                    final Dialog dialog = new Dialog(Enhanced.this);
                    dialog.setContentView(R.layout.dialog_super_user);
                    dialog.setTitle("کدوم آزمون ؟");
                    dialog.setCancelable(true);

                    final RadioButton rd1 = (RadioButton) dialog.findViewById(R.id.rd_1);
                    final RadioButton rd2 = (RadioButton) dialog.findViewById(R.id.rd_2);
                    final RadioButton rd3 = (RadioButton) dialog.findViewById(R.id.rd_3);
                    ImageView imageView = (ImageView) dialog.findViewById(R.id.imageView);

                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences.Editor editor = G.preferences.edit();
                            if (rd1.isChecked()) {
                                editor.putBoolean("SUPER_USER", true);
                                editor.commit();
                                Intent intent = new Intent(Enhanced.this, CalcActivity.class);
                                startActivity(intent);
                                dialog.dismiss();
                            }
                            if (rd2.isChecked()) {
                                // SharedPreferences.Editor editor = G.preferences.edit();
                                editor.putBoolean("SUPER_USER", true);
                                editor.commit();
                                Intent intent = new Intent(Enhanced.this, MemorizeActivity.class);
                                startActivity(intent);
                                dialog.dismiss();
                            }
                            if (rd3.isChecked()) {
                                //SharedPreferences.Editor editor = G.preferences.edit();
                                editor.putBoolean("SUPER_USER", true);
                                editor.commit();
                                Intent intent = new Intent(Enhanced.this, StropeActivity.class);
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        }
                    });

                    dialog.show();
                }

                if (position==3){
                      final SharedPreferences.Editor editor = G.preferences.edit();
                    final Dialog dialog = new Dialog(Enhanced.this);
                    dialog.setContentView(R.layout.dialog_settings);
                    dialog.setTitle("تنظیمات");
                    dialog.setCancelable(true);
                    Window window = dialog.getWindow();
                    window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    final customSetting customSetting1 = (customSetting) dialog.findViewById(R.id.setting1);
                    final customSetting customSetting2 = (customSetting) dialog.findViewById(R.id.setting2);
                    Button btnDefault = (Button) dialog.findViewById(R.id.btnDefault);
                    btnDefault.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            editor.putInt("CALCULATE", 100);
                            editor.putInt("STROPE", 50);
                            editor.commit();
                            customSetting1.txtLeft.setText("100");
                            customSetting2.txtLeft.setText("50");
                        }
                    });
                    customSetting1.txtRight.setText("تعداد سوالات آزمون محاسبه");
                    customSetting1.txtLeft.setText("" + G.preferences.getInt("CALCULATE", 100));
                    customSetting1. btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View arg0) {
                            try {
                                float editTextValueFloat = Float.valueOf(customSetting1.editText.getText().toString());
                                final int editTextValue = (int) editTextValueFloat;

                                //  final int editTextFinal =editTextValue;
                                final Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.shrink_to_middle);
                                animation2.setAnimationListener(new Animation.AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {
                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        try {
                                            if (editTextValue < 5) {
                                                editor.putInt("CALCULATE", 5);
                                                customSetting1.editText.setText("");
                                                customSetting1.txtLeft.setText("" + 5);
                                                editor.commit();
                                            } else if (editTextValue > 200) {
                                                editor.putInt("CALCULATE", 200);
                                                customSetting1.editText.setText("");
                                                customSetting1.txtLeft.setText("" + 200);
                                                editor.commit();
                                            } else {
                                                editor.putInt("CALCULATE", editTextValue);
                                                customSetting1.editText.setText("");
                                                customSetting1.txtLeft.setText("" + editTextValue);
                                                editor.commit();
                                            }
                                            Toast.makeText(G.context,"تغییرات اعمال شد", Toast.LENGTH_SHORT).show();
                                            customSetting1.lytContent.setVisibility(View.VISIBLE);
                                            customSetting1.lytButtons.setVisibility(View.GONE);
                                        } catch (Exception e) {
                                            Toast.makeText(G.context, "مقدار معتبر وارد کنید !!", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                                customSetting1.lytButtons.startAnimation(animation2);
                            }catch (Exception e){
                                Toast.makeText(G.context, "مقدار معتبر وارد کنید !!", Toast.LENGTH_LONG).show();
                            }
                        }
                        }
                    );

                    customSetting2.txtRight.setText("تعداد سوالات آزمون استروپ");
                    customSetting2.txtLeft.setText("" + G.preferences.getInt("STROPE", 50));
                    customSetting2.btnOk.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View arg0) {
                                  try {
                                      float editTextValueFloat = Float.valueOf(customSetting2.editText.getText().toString());
                                      final int editTextValue = (int) editTextValueFloat;
                                      final Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.shrink_to_middle);
                                      animation2.setAnimationListener(new Animation.AnimationListener() {
                                          @Override
                                          public void onAnimationStart(Animation animation) {
                                          }

                                          @Override
                                          public void onAnimationRepeat(Animation animation) {
                                          }

                                          @Override
                                          public void onAnimationEnd(Animation animation) {
                                              try {
                                                  if (editTextValue < 5) {
                                                      editor.putInt("STROPE", 5);
                                                      customSetting2.editText.setText("");
                                                      customSetting2.txtLeft.setText("" + 5);
                                                      editor.commit();
                                                  } else if (editTextValue > 100) {
                                                      editor.putInt("STROPE", 100);
                                                      customSetting2.editText.setText("");
                                                      customSetting2.txtLeft.setText("" + 100);
                                                      editor.commit();
                                                  } else {
                                                      editor.putInt("STROPE", editTextValue);
                                                      customSetting2.editText.setText("");
                                                      customSetting2.txtLeft.setText("" + editTextValue);
                                                      editor.commit();
                                                  }
                                                  Toast.makeText(G.context,"تغییرات اعمال شد", Toast.LENGTH_SHORT).show();
                                                  customSetting2.lytContent.setVisibility(View.VISIBLE);
                                                  customSetting2.lytButtons.setVisibility(View.GONE);
                                              } catch (Exception e) {
                                                  Toast.makeText(G.context, "مقدار معتبر وارد کنید !!", Toast.LENGTH_LONG).show();
                                              }
                                          }
                                      });
                                      customSetting2.lytButtons.startAnimation(animation2);
                                  }catch (Exception e){
                                      Toast.makeText(G.context, "مقدار معتبر وارد کنید !!", Toast.LENGTH_LONG).show();
                                  }
                              }
                          }
                    );
                        dialog.show();
                    }

                if(position==4){
                    SharedPreferences.Editor editor = G.preferences.edit();
                    Intent intent = new Intent(Enhanced.this,tizMaghz.class);
                    editor.putBoolean("HELP",false);
                    editor.commit();
                    startActivity(intent);
                }
                if (position==5){

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sherafat01@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "تیز مغز");
                    intent.putExtra(Intent.EXTRA_TEXT, "متن پیام ...");
                    try {
                        startActivity(Intent.createChooser(intent, "ارسال ایمیل از طریق..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(G.context, "خطایی رخ داده است!!!", Toast.LENGTH_SHORT).show();
                    }
                }

                if (position==6){

                    SharedPreferences.Editor editor = G.preferences.edit();
                    editor.putBoolean("HELP",true);
                    editor.commit();
                    Intent intent = new Intent(Enhanced.this,tizMaghz.class);
                    startActivity(intent);


                }
                }
        });
    }

    public void setupDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Menu");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(activityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        drawerToggle.setDrawerIndicatorEnabled(true);  //this is that nice icon in toolbar
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            // Toast.makeText(G.context, "Time for an upgrade!", Toast.LENGTH_SHORT).show();

            return true;
        }

        // Activate the navigation drawer toggle
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}