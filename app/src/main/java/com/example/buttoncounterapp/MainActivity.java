package com.example.buttoncounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// we are going to be importing widgets
import android.text.method.ScrollingMovementMethod;
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

    //bundle is used to pass data around
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //this is going to be telling you which layout you are going to be using

        //invoking the user input on the textview field
        //every widget is a view
        userInput = (EditText) findViewById(R.id.editText);
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

            }
        };

        //we are going to be using the ourOnClickListener method when the button is clicked
        //ourOnClickListener method is going to be used on OnClickListener
        if (button !=null) {
            button.setOnClickListener(ourOnClickListener);
        }
    }
}