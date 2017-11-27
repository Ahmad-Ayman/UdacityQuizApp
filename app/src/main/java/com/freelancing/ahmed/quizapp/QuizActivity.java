package com.freelancing.ahmed.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class QuizActivity extends AppCompatActivity {
    Button next;
    private RadioGroup radioGroup,radioGroup2,radioGroup3,radioGroup4;
    private CheckBox ans2_1,ans2_2,ans2_3,ans2_4,ans3_1,ans3_2,ans3_3,ans3_4;
    private EditText ans7,ans8;
    MediaPlayer player;
    AssetFileDescriptor afd;
    int grading=0;
    boolean is1chekced,is2chekced,is3chekced,is4chekced,is3_1chekced,is3_2chekced,is3_3chekced,is3_4chekced;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        next=(Button) findViewById(R.id.grades);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        radioGroup2 = (RadioGroup) findViewById(R.id.radio2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radio3);
        radioGroup4 = (RadioGroup)findViewById(R.id.radio4);
        ans7 = (EditText) findViewById(R.id.answerq7);
        ans8 = (EditText) findViewById(R.id.answerq8);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Question One checking
                    // get selected radio button from radioGroup
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    // check if correct answer
                        if(selectedId==R.id.option3) {
                            grading++;
                        }
                //Question Two Checking
                    ans2_1 = (CheckBox) findViewById(R.id.checkbox1);
                    ans2_2 = (CheckBox) findViewById(R.id.checkbox2);
                    ans2_3 = (CheckBox) findViewById(R.id.checkbox3);
                    ans2_4 = (CheckBox) findViewById(R.id.checkbox4);
                    is1chekced= ans2_1.isChecked();
                    is2chekced= ans2_2.isChecked();
                    is3chekced= ans2_3.isChecked();
                    is4chekced= ans2_4.isChecked();
                    if(is1chekced==false && is2chekced == false && is3chekced==false && is4chekced == true){
                        grading++;
                    }
                //Question Three Checking
                ans3_1 = (CheckBox) findViewById(R.id.checkbox2_1);
                ans3_2 = (CheckBox) findViewById(R.id.checkbox2_2);
                ans3_3 = (CheckBox) findViewById(R.id.checkbox2_3);
                ans3_4 = (CheckBox) findViewById(R.id.checkbox2_4);
                is3_1chekced= ans3_1.isChecked();
                is3_2chekced= ans3_2.isChecked();
                is3_3chekced= ans3_3.isChecked();
                is3_4chekced= ans3_4.isChecked();
                if(is3_1chekced==false && is3_2chekced==true   && is3_3chekced==false && is3_4chekced==true){
                    grading++;
                }
                //Question Four checking
                // get selected radio button from radioGroup
                int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                // check if correct answer
                if(selectedId2==R.id.option2_3) {
                    grading++;
                }
                //Question Five checking
                // get selected radio button from radioGroup
                int selectedId3 = radioGroup3.getCheckedRadioButtonId();
                // check if correct answer
                if(selectedId3==R.id.option3_1) {
                    grading++;
                }
                //Question Six checking
                // get selected radio button from radioGroup
                int selectedId4 = radioGroup4.getCheckedRadioButtonId();
                // check if correct answer
                if(selectedId4==R.id.option4_2) {
                    grading++;
                }
                //Question Seven checking
                String answer7=ans7.getText().toString();
                if( answer7.trim().equals("")) {
                    ans7.setError("Question 7 is missing");
                }else {
                    String s = answer7.toLowerCase();
                    if (s.equals("chocolate") || s.equals("الشيكولاتة") || s.equals("شيكولاتة")) {
                        grading++;
                    }
                }
                //Question Eight checking
                String no=ans8.getText().toString();       //this will get a string
                if( no.trim().equals("")) {
                    ans8.setError("Question 8 is missing");
                }else {
                    int no2 = Integer.parseInt(no);
                    if (no2 == 687) {
                        grading++;
                    }
                }
                //this will get a no from the string
                if(grading == 8){
                  /*  Intent i=new Intent(QuizActivity.this,ResultActivity.class);
                    i.putExtra("grade",grading);
                    startActivity(i);
                    finish();*/
                    try {
// Read the music file from the asset folder
                        afd = getAssets().openFd("woho.mp3");
// Creation of new media player;
                        player = new MediaPlayer();
// Set the player music source.
                        player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),afd.getLength());
// Set the looping and play the music.
                        player.setLooping(true);
                        player.prepare();
                        player.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    AlertDialog.Builder alert = new AlertDialog.Builder(QuizActivity.this);
                    alert.setTitle("Congratulations.");
                    alert.setIcon(R.drawable.conf);
                    alert.setMessage("You are a True PotterHead, you Scored "+grading+" out of 8 points. You deserve a Chocolate Frog");
                    alert.setPositiveButton("Tutorial",new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                           QuizActivity.super.onBackPressed();
                            player.stop();
                            player=null;
                        }
                    });
                    alert.setNeutralButton("Reset",
                            new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                                grading=0;
                                // reseting every items
                                ans2_1.setChecked(false);
                                ans2_2.setChecked(false);
                                ans2_3.setChecked(false);
                                ans2_4.setChecked(false);
                                ans3_1.setChecked(false);
                                ans3_2.setChecked(false);
                                ans3_3.setChecked(false);
                                ans3_4.setChecked(false);
                                radioGroup.clearCheck();
                                radioGroup2.clearCheck();
                                radioGroup3.clearCheck();
                                radioGroup4.clearCheck();
                                ans7.setText("");
                                ans8.setText("");
                                is1chekced=false;
                                is2chekced=false;
                                is3chekced=false;
                                is4chekced=false;
                                is3_1chekced=false;
                                is3_2chekced=false;
                                is3_3chekced=false;
                                is3_4chekced=false;
                                player.stop();
                                player=null;
                            }
                        });

                    alert.show();
                    grading = 0;
                }
                else {
                    Toast.makeText(QuizActivity.this, getString(R.string.toastss, grading), Toast.LENGTH_SHORT).show();
                    grading = 0;
                }

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_option_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        //respond to menu item selection
        switch (item.getItemId()) {
            case R.id.reset:
                grading=0;
               // private RadioGroup radioGroup,radioGroup2,radioGroup3,radioGroup4;

                ans2_1.setChecked(false);
                ans2_2.setChecked(false);
                ans2_3.setChecked(false);
                ans2_4.setChecked(false);
                ans3_1.setChecked(false);
                ans3_2.setChecked(false);
                ans3_3.setChecked(false);
                ans3_4.setChecked(false);
                radioGroup.clearCheck();
                radioGroup2.clearCheck();
                radioGroup3.clearCheck();
                radioGroup4.clearCheck();
                ans7.setText("");
                ans8.setText("");
                is1chekced=false;
                is2chekced=false;
                is3chekced=false;
                is4chekced=false;
                is3_1chekced=false;
                is3_2chekced=false;
                is3_3chekced=false;
                is3_4chekced=false;
                  player.stop();
                  player=null;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
