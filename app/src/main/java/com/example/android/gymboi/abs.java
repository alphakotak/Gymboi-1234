package com.example.android.gymboi;

import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class abs extends AppCompatActivity {

    String email_str;



    EditText r1;
    EditText r2;
    EditText r3;
    EditText r4;

    EditText ar1;
    EditText ar2;
    EditText ar3;
    EditText ar4;

    EditText br1;
    EditText br2;
    EditText br3;
    EditText br4;

    EditText cr1;
    EditText cr2;
    EditText cr3;
    EditText cr4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);

        final RadioGroup group = (RadioGroup) findViewById(R.id.rdgrp1);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                switch(id)
                {
                    case R.id.surya:
                        email_str = "ssuthar8016@gmail.com";
                        Toast toast = Toast.makeText(getApplicationContext(), email_str, Toast.LENGTH_SHORT);
                        toast.show();
                        break;

                    case R.id.kotak:
                        email_str = "meet.kotak@somaiya.edu";
                        Toast toast1 = Toast.makeText(getApplicationContext(), email_str, Toast.LENGTH_SHORT);
                        toast1.show();
                        break;

                    case R.id.samir:
                        email_str = "thakker.samir@gmail.com";
                        Toast toast2 = Toast.makeText(getApplicationContext(), email_str, Toast.LENGTH_SHORT);
                        toast2.show();
                        break;

                    case R.id.amita:
                        email_str = "Ilurocky81@gmail.com";
                        Toast toast3 = Toast.makeText(getApplicationContext(), email_str, Toast.LENGTH_SHORT);
                        toast3.show();
                        break;


                }
            }
        });


        r1 = (EditText) findViewById(R.id.r1);
        r2 = (EditText) findViewById(R.id.r2);
        r3 = (EditText) findViewById(R.id.r3);
        r4 = (EditText) findViewById(R.id.r4);

        ar1 = (EditText) findViewById(R.id.ar1);
        ar2 = (EditText) findViewById(R.id.ar2);
        ar3 = (EditText) findViewById(R.id.ar3);
        ar4 = (EditText) findViewById(R.id.ar4);

        br1 = (EditText) findViewById(R.id.br1);
        br2 = (EditText) findViewById(R.id.br2);
        br3 = (EditText) findViewById(R.id.br3);
        br4 = (EditText) findViewById(R.id.br4);

        cr1 = (EditText) findViewById(R.id.cr1);
        cr2 = (EditText) findViewById(R.id.cr2);
        cr3 = (EditText) findViewById(R.id.cr3);
        cr4 = (EditText) findViewById(R.id.cr4);

    }

    public void submitOrder(View view)
        /* obj view of class view imported above*/ {
        CheckBox full_crunchCheckbox = (CheckBox) findViewById(R.id.full_crunch);
        boolean hasfull_crunch = full_crunchCheckbox.isChecked();


        String a = r1.getText().toString();
        String b = r2.getText().toString();
        String c = r3.getText().toString();
        String d = r4.getText().toString();

        CheckBox half_crunchCheckbox = (CheckBox) findViewById(R.id.half_crunch);
        boolean hashalf_crunch = half_crunchCheckbox.isChecked();


        String a1 = ar1.getText().toString();
        String b1 = ar2.getText().toString();
        String c1 = ar3.getText().toString();
        String d1 = ar4.getText().toString();

        CheckBox hanging_leg_raiseCheckbox = (CheckBox) findViewById(R.id.hanging_legs_raise);
        boolean hashanging_leg_raise = hanging_leg_raiseCheckbox.isChecked();

        String a2 = br1.getText().toString();
        String b2 = br2.getText().toString();
        String c2 = br3.getText().toString();
        String d2 = br4.getText().toString();

        CheckBox hanging_knee_raiseCheckbox = (CheckBox) findViewById(R.id.hanging_knee_raise);
        boolean hashanging_knee_raise = hanging_knee_raiseCheckbox.isChecked();

        String a3 = cr1.getText().toString();
        String b3 = cr2.getText().toString();
        String c3 = cr3.getText().toString();
        String d3 = cr4.getText().toString();


        String message = createSummary(a, b, c, d, hasfull_crunch, a1, b1, c1, d1, hashalf_crunch, a2, b2, c2, d2, hashanging_leg_raise, a3, b3, c3, d3, hashanging_knee_raise);


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email_str});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Gymboi beta test mail" );
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }




    }
    private String createSummary(String a, String b, String c, String d, boolean hasfull_crunch, String a1, String b1, String c1, String d1, boolean hashalf_crunch, String a2, String b2,
                                 String c2, String d2, boolean hashanging_leg_raise, String a3, String b3, String c3, String d3, boolean hashanging_knee_raise){

        String msg1 = getString(R.string.nota);
        String msg2 = getString(R.string.nota);
        String msg3 = getString(R.string.nota);
        String msg4 = getString(R.string.nota);


        if (hasfull_crunch)
        {
            msg1 = getString(R.string.full_crunch);
            msg1 += "\n" + a + "-" + b + "-" + c + "-" + d;


        }

        if (hashalf_crunch)
        {
            msg2 = getString(R.string.half_crunch);
            msg2 += "\n" + a1 + "-" + b1 + "-" + c1 + "-" + d1;

        }

        if (hashanging_leg_raise)
        {
            msg3 = getString(R.string.hanging_leg_raise);
            msg3 += "\n" + a2 + "-" + b2 + "-" + c2 + "-" + d2;


        }

        if(hashanging_knee_raise)
        {
            msg3 = getString(R.string.hanging_knee_raise);
            msg3 += "\n" + a3 + "-" + b3 + "-" + c3 + "-" + d3;


        }

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        String finalmsg = "Workout for " +date +"\n" +msg1 +"\n" + msg2 +"\n" + msg3 +"\n" + msg4;
        return finalmsg;

    }



    /**
     * This method displays the given quantity value on the screen.
     * @param message
     */
}
