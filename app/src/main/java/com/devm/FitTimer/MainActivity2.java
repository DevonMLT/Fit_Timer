package com.devm.FitTimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity{

    ConstraintLayout fragmentLayout1,fragmentLayout2,fragmentLayout3,fragmentLayout4,fragmentLayout5;
    ImageView collapse, img1, img2, img3, img4, img5;

    ScrollView scrollexample;

    long START_TIME_IN_MILLIS = 180000;
    TextView mTextViewCountDown;
    ImageView mButtonStartPause, mButtonReset;
    CountDownTimer mCountDownTimer;
    boolean mTimerRunning;
    long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    EditText editTitle,editNote1,editWorkout1,editNote2,editWorkout2,editNote3,editWorkout3,editNote4,editWorkout4,editNote5,editWorkout5;
    String SHARED_PREFS = "sharedprefs";
    String TITLE = "title";
    String EX1 = "ex1";
    String N1 = "n1";
    String EX2 = "ex2";
    String N2 = "n2";
    String EX3 = "ex3";
    String N3 = "n3";
    String EX4 = "ex4";
    String N4 = "n4";
    String EX5 = "ex5";
    String N5 = "n5";
    String title,etEx1,etN1,etEx2,etN2,etEx3,etN3,etEx4,etN4,etEx5,etN5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        scrollexample = findViewById(R.id.scrolltest);


        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonReset = findViewById(R.id.button_reset);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimerRunning) {
                    pauseTimer();
                }
                else {
                    startTimer();
                }
            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();

        //Fragment inflater onclick event handler. When the layout is pressed the fragment will expand into the framelayout.
        fragmentLayout1 = findViewById(R.id.fragmentBtn1);
        fragmentLayout2 = findViewById(R.id.fragmentBtn2);
        fragmentLayout3 = findViewById(R.id.fragmentBtn3);
        fragmentLayout4 = findViewById(R.id.fragmentBtn4);
        fragmentLayout5 = findViewById(R.id.fragmentBtn5);


        //this will be added for the fragments POSSIBLY I kind of like how it currently is, it's much simpler
//        fragmentLayout1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                replaceFragment(new setsFragment());
//            }
//        });


        //set fragmentLayout to invisible when the collapse "-" button is pressed. "-" changes to "+" when pressed
        img1 = findViewById(R.id.collapseButton1);
        collapse = findViewById(R.id.collapseButton1);
        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentLayout1.getVisibility() == View.VISIBLE) {
                    fragmentLayout1.setVisibility(View.INVISIBLE);
                    img1.setImageResource(R.drawable.plusmdpi);
                } else {
                    fragmentLayout1.setVisibility(View.VISIBLE);
                    img1.setImageResource(R.drawable.minusmdpi); }
            }
        });
        img2 = findViewById(R.id.collapseButton2);
        collapse = findViewById(R.id.collapseButton2);
        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentLayout2.getVisibility() == View.VISIBLE) {
                    fragmentLayout2.setVisibility(View.INVISIBLE);
                    img2.setImageResource(R.drawable.plusmdpi);
                } else {
                    fragmentLayout2.setVisibility(View.VISIBLE);
                    img2.setImageResource(R.drawable.minusmdpi);
                }
            }
        });
        img3 = findViewById(R.id.collapseButton3);
        collapse = findViewById(R.id.collapseButton3);
        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentLayout3.getVisibility() == View.VISIBLE) {
                    fragmentLayout3.setVisibility(View.INVISIBLE);
                    img3.setImageResource(R.drawable.plusmdpi);
                } else {
                    fragmentLayout3.setVisibility(View.VISIBLE);
                    img3.setImageResource(R.drawable.minusmdpi);
                }
            }
        });
        img4 = findViewById(R.id.collapseButton4);
        collapse = findViewById(R.id.collapseButton4);
        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentLayout4.getVisibility() == View.VISIBLE) {
                    fragmentLayout4.setVisibility(View.INVISIBLE);
                    img4.setImageResource(R.drawable.plusmdpi);
                } else {
                    fragmentLayout4.setVisibility(View.VISIBLE);
                    img4.setImageResource(R.drawable.minusmdpi);
                }
            }
        });
        img5 = findViewById(R.id.collapseButton5);
        collapse = findViewById(R.id.collapseButton5);
        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentLayout5.getVisibility() == View.VISIBLE) {
                    fragmentLayout5.setVisibility(View.INVISIBLE);
                    img5.setImageResource(R.drawable.plusmdpi);
                } else {
                    fragmentLayout5.setVisibility(View.VISIBLE);
                    img5.setImageResource(R.drawable.minusmdpi);
                }
            }
        });
        //____________________________________________________________________________


        //Just a toast test set up for scrolling childview to top of scrollview layout. if i add this
//        sv = findViewById(R.id.scroll_list);
//        textViewTest = findViewById(R.id.textViewSecond);
//        textViewTest.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus) {
//                    Toast.makeText(getApplicationContext(),textViewTest.getText().toString(),Toast.LENGTH_LONG).show();
//                    sv.smoothScrollTo(0,50);
//                }
//            }
//        });
        //____________________________________________________________________________

        editTitle = findViewById(R.id.etTitle);

        editNote1 = findViewById(R.id.etNotes1);
        editWorkout1 = findViewById(R.id.etWorkout1);

        editNote2 = findViewById(R.id.etNotes2);
        editWorkout2 = findViewById(R.id.etWorkout2);

        editNote3 = findViewById(R.id.etNotes3);
        editWorkout3 = findViewById(R.id.etWorkout3);

        editNote4 = findViewById(R.id.etNotes4);
        editWorkout4 = findViewById(R.id.etWorkout4);

        editNote5 = findViewById(R.id.etNotes5);
        editWorkout5 = findViewById(R.id.etWorkout5);

        loadData();
        updateView();
    }

    //code for saving user input into the edittext then saving data when the view is not visibl with onStop then loading and updating the text with updateView.
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TITLE, editTitle.getText().toString());

        editor.putString(N1, editNote1.getText().toString());
        editor.putString(EX1, editWorkout1.getText().toString());

        editor.putString(N2, editNote2.getText().toString());
        editor.putString(EX2, editWorkout2.getText().toString());

        editor.putString(N3, editNote3.getText().toString());
        editor.putString(EX3, editWorkout3.getText().toString());

        editor.putString(N4, editNote4.getText().toString());
        editor.putString(EX4, editWorkout4.getText().toString());

        editor.putString(N5, editNote5.getText().toString());
        editor.putString(EX5, editWorkout5.getText().toString());

        editor.apply();
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        title = sharedPreferences.getString(TITLE, "");

        etN1 = sharedPreferences.getString(N1, "");
        etEx1 = sharedPreferences.getString(EX1, "");

        etN2 = sharedPreferences.getString(N2, "");
        etEx2 = sharedPreferences.getString(EX2, "");

        etN3 = sharedPreferences.getString(N3, "");
        etEx3 = sharedPreferences.getString(EX3, "");

        etN4 = sharedPreferences.getString(N4, "");
        etEx4 = sharedPreferences.getString(EX4, "");

        etN5 = sharedPreferences.getString(N5, "");
        etEx5 = sharedPreferences.getString(EX5, "");
    }
    public void updateView() {
        editTitle.setText(title);

        editNote1.setText(etN1);
        editWorkout1.setText(etEx1);

        editNote2.setText(etN2);
        editWorkout2.setText(etEx2);

        editNote3.setText(etN3);
        editWorkout3.setText(etEx3);

        editNote4.setText(etN4);
        editWorkout4.setText(etEx4);

        editNote5.setText(etN5);
        editWorkout5.setText(etEx5);
    }
    //_____________________________________________________








    //_______________________________TIMER COUNTDOWN CODE____________________________
    public void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setImageResource(R.drawable.playmdpi);
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }
        .start();
        mTimerRunning = true;
        mButtonStartPause.setImageResource(R.drawable.pausemdpi);
        mButtonReset.setVisibility(View.INVISIBLE);
    }
    public void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setImageResource(R.drawable.playmdpi);
        mButtonReset.setVisibility(View.VISIBLE);
    }
    public void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }
    public void updateCountDownText() {
        int minutes = (int) mTimeLeftInMillis / 1000 / 60;
        int seconds = (int) mTimeLeftInMillis / 1000 % 60;
        String timeLeft = String.format(Locale.getDefault(),"%2d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeft);
    }
    //_______________________________TIMER COUNTDOWN CODE____________________________




    //Need to figure out how to give each framelayout/fragmentBtn it's own fragment and how to switch between them within one method. Perhaps make a separate replaceFragment class?
//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.frameLayout1, fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }

}
