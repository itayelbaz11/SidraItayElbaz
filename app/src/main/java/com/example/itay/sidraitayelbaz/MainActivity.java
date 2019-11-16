package com.example.itay.sidraitayelbaz;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Switch;
        import android.widget.Toast;

/**
 * @author Itay Elbaz
 * @version alpha
 * @since 6.7.2003
 *
 * in this activity you choos the type of the series, first number and Difference or multiplier and then move to the next activity
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    /**
     * f is the first number of the series
     * x is the Difference or multiplier
     * sw is the java object of the Switch
     * et1 is a java object of the editText
     * et2 is a java object of the editText
     */

    double f,x;
    boolean b=false;
    Switch sw;
    EditText et1,et2;
    String st,st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw=(Switch) findViewById(R.id.sw);
        et1=(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
    }

    public void swiiii(View view) {
        if(sw.isChecked())
            b=true;
        else
            b=false;
    }

    /**
     * When the button next is clicked this method works.
     * The mothod checks if the user entered numbers and then move to the next activity with the numbers and type that were chosen,
     * if not it alerts the person to enter numbers
     *
     */
    public void btn(View view) {
        st=et1.getText().toString();
        st2=et2.getText().toString();
        if(st.length()!=0&&st2.length()!=0) {
            f=Double.parseDouble(st);
            x=Double.parseDouble(st2);
            Intent si=new Intent(this,sidraShow.class);
            si.putExtra("hukiut",x);
            si.putExtra("first",f);
            si.putExtra("sug",b);
            startActivity(si);
        }
        else {
            Toast.makeText(this, "enter numbers..", Toast.LENGTH_SHORT).show();
        }
        }

    /**
     * moving to the credits activity
     */
    public void cred(View view) {
        Intent mi=new Intent(this,Credits.class);
        startActivity(mi);
    }
}
