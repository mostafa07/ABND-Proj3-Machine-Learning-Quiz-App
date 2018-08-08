package com.example.android.quizapp_ml;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button submitBtn;
    RadioGroup q1Group, q3Group, q4Group, q5Group;
    CheckBox q2_op1, q2_op2, q2_op3, q2_op4, q2_op5, q2_op6;
    EditText q6ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = (Button) findViewById(R.id.submitBtn);
        q1Group = (RadioGroup) findViewById(R.id.q1_radio_group);
        q3Group = (RadioGroup) findViewById(R.id.q3_radio_group);
        q4Group = (RadioGroup) findViewById(R.id.q4_radio_group);
        q5Group = (RadioGroup) findViewById(R.id.q5_radio_group);
        q2_op1 = (CheckBox) findViewById(R.id.q2_op1);
        q2_op2 = (CheckBox) findViewById(R.id.q2_op2);
        q2_op3 = (CheckBox) findViewById(R.id.q2_op3);
        q2_op4 = (CheckBox) findViewById(R.id.q2_op4);
        q2_op5 = (CheckBox) findViewById(R.id.q2_op5);
        q2_op6 = (CheckBox) findViewById(R.id.q2_op6);
        q6ET = (EditText) findViewById(R.id.q6_ET);

        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int score = 0;

        switch (view.getId()) {
            case (R.id.submitBtn): {
                //check questions answers
                if (q6ET.getText().toString().equalsIgnoreCase("Yes"))
                    score++;
                if (q1Group.getCheckedRadioButtonId() == R.id.q1_op3)
                    score++;
                if (q2_op1.isChecked() && q2_op3.isChecked() && q2_op6.isChecked()
                        && !q2_op2.isChecked() && !q2_op4.isChecked() && !q2_op5.isChecked())
                    score++;
                if (q3Group.getCheckedRadioButtonId() == R.id.q3_op1)
                    score++;
                if (q4Group.getCheckedRadioButtonId() == R.id.q4_op2)
                    score++;
                if (q5Group.getCheckedRadioButtonId() == R.id.q5_op2)
                    score++;

                //show toast message with score
                if (score > 0)
                    Toast.makeText(getApplicationContext(), "You got " + score + " out of 6!",
                            Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Please answer the questions and try again",
                            Toast.LENGTH_LONG).show();
                break;
            }
            default:
                break;
        }
    }
}
