package com.app.sherafat.ali.tizmaghz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_day);

        int chartType = getIntent().getExtras().getInt("chart_view");
        switch (chartType){
            case 1:
                chart chartViewDays = (chart) findViewById(R.id.chartView);
                float[] floats = new float[60];
                int dayValues;
                for (int i=0 ; i<60 ; i++){
                    dayValues=G.preferences.getInt("SECOND_DAY"+(i+1),0);
                    if (dayValues>300){
                        dayValues=300;
                    }
                    if (dayValues==0){
                        dayValues=300;
                    }
                    floats[i] =  300-dayValues;
                }
                chartViewDays.setVerMaxValue(300);
                chartViewDays.setData(floats);
                chartViewDays.setHorAndisScape(2);
                chartViewDays.setVerAndisScape(5);
                chartViewDays.setVerDeviderCount(50);
                break;
            case 2:
                chart chartViewMemorize = (chart) findViewById(R.id.chartView);
                float[] Mem = new float[13];
                int value;
                for (int i=0 ; i<13 ; i++){
                    value=G.preferences.getInt("MEMORIZE_WEEK"+i,0);
                    Mem[i] = value;
                }
                chartViewMemorize.setVerMaxValue(50);
                chartViewMemorize.setData(Mem);
                chartViewMemorize.setHorAndisScape(1);
                chartViewMemorize.setVerAndisScape(2);
                chartViewMemorize.setVerDeviderCount(30);
                break;
            case 3:
                chart chartViewStrope = (chart) findViewById(R.id.chartView);
                float[] stropes = new float[13];
                int stropeValues;
                for (int i=0 ; i<13 ; i++){
                    stropeValues=G.preferences.getInt("SECOND_STROPE"+i,0);
                    if (stropeValues>150){
                        stropeValues=150;
                    }
                    if (stropeValues==0){
                        stropeValues=150;
                    }
                    stropes[i] =150-stropeValues;
                }
                chartViewStrope.setVerMaxValue(150);
                chartViewStrope.setData(stropes);
                chartViewStrope.setHorAndisScape(1);
                chartViewStrope.setVerAndisScape(3);
                chartViewStrope.setVerDeviderCount(50);
                break;

        }

    }



/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chart_view, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
