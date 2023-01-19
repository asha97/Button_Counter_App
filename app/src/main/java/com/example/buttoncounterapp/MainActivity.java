package com.example.buttoncounterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// we are going to be importing widgets
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button; //field that is going to be storing reference
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //need to make sure that you have the same name as the fields that you have defined when dragging the widgets
   /* private EditText editText;
    private Button button;
    private TextView textView;
    */

    private EditText userInput;
    private Button button;
    private TextView textView;
    //private int numTimesClicked = 0;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents";

    //bundle is used to pass data around
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //this is going to be telling you which layout you are going to be using

        //invoking the user input on the textview field
        //every widget is a view
        userInput = (EditText) findViewById(R.id.editText);
        userInput.setText("");

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        //we want to add the scrolling method when there are taps on the button
        textView.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod());

        //method that is going to be used in order to increment the number of times the button
        //has been clicked
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* numTimesClicked = numTimesClicked +1;
                String result = "\nThe button has been pressed " + numTimesClicked + " time!" ;
                if (numTimesClicked != 1){
                    result += "s"; // this is going to be adding an s when there are more than one clicks, grammatical purposes!
                }
                result = result + "\n";
                textView.append(result);
                */

                //here we are going to be getting the user input and display on the click of the button
                String result = userInput.getText().toString();
                result  = result + "\n";
                textView.append(result);
                userInput.setText("");
            }

            //bundle is used to pass data around
            //we are going to be using it for restoring the states.
        };

        //we are going to be using the ourOnClickListener method when the button is clicked
        //ourOnClickListener method is going to be used on OnClickListener
            button.setOnClickListener(ourOnClickListener);
            Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
       // String savedString = savedInstanceState.getString(TEXT_CONTENTS);
       // textView.setText(savedString);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }


    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    //log.d methods are used showing messages on the terminal
    //abd is going to run and install the emulator

    //in logcat on the bottom, you could monitor what is going on in the code when you are entering something in the textview
    //onPause is going to be saving the data when there is going to be a pause in the application!!!
    //onStop is going to be used to stop a transfer for example
    //each method has a context and a use!
}