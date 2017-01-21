package com.app.sherafat.ali.tizmaghz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMemorize extends AppCompatActivity {

    ArrayList<String> userGuessed;
    Button btnEnd;
    int week;
    boolean superUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_memorize);

        userGuessed = new ArrayList<String>();
        btnEnd = (Button) findViewById(R.id.btnEnd);
        week = G.preferences.getInt("WEEK", -1);
        superUser = G.preferences.getBoolean("SUPER_USER", false);

        TextView txtGuide = (TextView) findViewById(R.id.txtGuide);
        txtGuide.setText("برای ثبت هر واژه از کلید انجام (done)  در صفحه کلید استفاده کنید.");
        txtGuide.setTypeface(G.yekan);
        txtGuide.setLineSpacing(20,1);


        Bundle bundle=this.getIntent().getExtras();
        final String[] words =bundle.getStringArray("ARRAY");
        final EditText edtAnswers = (EditText) this.findViewById(R.id.edtAnswers);
        final TextView txtGuessNumbers = (TextView) findViewById(R.id.txtGuess);



        edtAnswers.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    if (Arrays.asList(words).contains( edtAnswers.getText().toString())) {

                        for (String item : userGuessed){
                            if (item.contains(edtAnswers.getText().toString())){
                                Toast.makeText(G.context,"" + edtAnswers.getText().toString()+"  تکراریه!",Toast.LENGTH_SHORT).show();
                                edtAnswers.setText("");
                                    return true;
                            }
                        }




                        userGuessed.add(edtAnswers.getText().toString());
                    Toast.makeText(G.context,"" + edtAnswers.getText().toString()+" توش بود :)",Toast.LENGTH_SHORT).show();
                    edtAnswers.setText("");
                        txtGuessNumbers.setText(""+userGuessed.size());
                    }

                    return true;
                }
                return false;
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        final AlertDialog.Builder builder =
                new AlertDialog.Builder(TestMemorize.this, R.style.AppCompatAlertDialogStyle);
        builder.setTitle("حالا نتیجه...");
        builder.setMessage(userGuessed.size() + " تاشو تونستی حفظ کنی...!");
                String positiveText = "ok";
                if (!superUser) {
                    positiveText = "آزمون استروپ ...";
                }else {
                    positiveText="خُب...";
                }

        builder.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences.Editor editor = G.preferences.edit();
                if (!superUser) {
                Intent intent = new Intent(TestMemorize.this, StropeActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                    editor.putInt("MEMORIZE_WEEK" + (week + 1), userGuessed.size());
                }
                editor.putBoolean("SUPER_USER",false);
                editor.commit();
                finish();
            }
        });
                builder.setNegativeButton("هنوز یادم میاد !", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        });
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_memorize, menu);
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
