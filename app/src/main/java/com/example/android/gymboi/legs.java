package com.example.android.gymboi;

import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class legs extends AppCompatActivity {

    EditText w1;
    EditText w2;
    EditText w3;
    EditText w4;

    EditText r1;
    EditText r2;
    EditText r3;
    EditText r4;

    EditText aw1;
    EditText aw2;
    EditText aw3;
    EditText aw4;

    EditText ar1;
    EditText ar2;
    EditText ar3;
    EditText ar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);
        w1 = (EditText) findViewById(R.id.weight1);
        w2 = (EditText) findViewById(R.id.weight2);
        w3 = (EditText) findViewById(R.id.weight3);
        w4 = (EditText) findViewById(R.id.weight4);

        r1 = (EditText) findViewById(R.id.r1);
        r2 = (EditText) findViewById(R.id.r2);
        r3 = (EditText) findViewById(R.id.r3);
        r4 = (EditText) findViewById(R.id.r4);

        aw1 = (EditText) findViewById(R.id.aweight1);
        aw2 = (EditText) findViewById(R.id.aweight2);
        aw3 = (EditText) findViewById(R.id.aweight3);
        aw4 = (EditText) findViewById(R.id.aweight4);

        ar1 = (EditText) findViewById(R.id.ar1);
        ar2 = (EditText) findViewById(R.id.ar2);
        ar3 = (EditText) findViewById(R.id.ar3);
        ar4 = (EditText) findViewById(R.id.ar4);
    }

    public void submitOrder(View view)
        /* obj view of class view imported above*/ {
        CheckBox BicepsCheckbox = (CheckBox) findViewById(R.id.biceps);
        boolean hasBiceps = BicepsCheckbox.isChecked();

        String a = w1.getText().toString();
        String b = w2.getText().toString();
        String c = w3.getText().toString();
        String d = w4.getText().toString();
        String e = r1.getText().toString();
        String f = r2.getText().toString();
        String g = r3.getText().toString();
        String h = r4.getText().toString();

        CheckBox TricepsCheckbox = (CheckBox) findViewById(R.id.triceps);
        boolean hasTriceps = TricepsCheckbox.isChecked();

        String a1 = aw1.getText().toString();
        String b1 = aw2.getText().toString();
        String c1 = aw3.getText().toString();
        String d1 = aw4.getText().toString();
        String e1 = ar1.getText().toString();
        String f1 = ar2.getText().toString();
        String g1 = ar3.getText().toString();
        String h1 = ar4.getText().toString();


        String message = createSummary(a, b, c, d, e, f, g, h, hasBiceps, a1, b1, c1, d1, e1, f1, g1, h1, hasTriceps);


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"meet.kotak@somaiya.edu"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Gymboi beta test mail" );
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }




    }
    private String createSummary(String a, String b, String c, String d, String e, String f, String g, String h, boolean biceps, String a1, String b1, String c1, String d1, String e1, String f1, String g1, String h1, boolean triceps){

        String msg1 = getString(R.string.nota);
        String msg3 = getString(R.string.nota);


        if (biceps)
        {
            msg1 = getString(R.string.biceps);
            msg1 += "\n" + a + "-" + b + "-" + c + "-" + d;
            msg1 += "\n" + e + "-" + f + "-" + g + "-" + h;

        }

        if (triceps)
        {
            msg3 = getString(R.string.triceps);
            msg3 += "\n" + a1 + "-" + b1 + "-" + c1 + "-" + d1;
            msg3 += "\n" + e1 + "-" + f1 + "-" + g1 + "-" + h1;

        }

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        String finalmsg = "Workout for " +date +"\n" +msg1 +"\n" + msg3;
        return finalmsg;

    }



    /**
     * This method displays the given quantity value on the screen.
     * @param message
     */


}
