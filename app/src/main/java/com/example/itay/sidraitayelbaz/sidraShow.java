package com.example.itay.sidraitayelbaz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author Itay Elbaz
 * @version alpha
 * @since 6.7.2003
 *
 * This activity shows the series and you are able to do a long click on every item and have two options: to get the items index
 * or to get the sum of the numbers until the item you chose
 *
 */

public class sidraShow extends AppCompatActivity implements View.OnCreateContextMenuListener,AdapterView.OnItemLongClickListener {

    /**
     * d is a double array for the series numbers
     * m is a String array for the series numbers Strings
     * f is the first number of the series
     * x is the Difference or multiplier
     * index is the list views choice index
     * lv is the java object of the list view
     * tv is the java object of the text view
     */

    double[] d=new double[20];
    String[] m=new String[20];
    double f,x;
    boolean b;
    ListView lv;
    TextView tv;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidra_show);

        lv=(ListView) findViewById(R.id.lv);
        tv=(TextView) findViewById(R.id.tv);


        Intent gi=getIntent();
        x=gi.getDoubleExtra("hukiut",-2000000000);
        f=gi.getDoubleExtra("first",-2000000000);
        b=gi.getBooleanExtra("sug",false);

        d[0]=f;
        if (!b) {
            for (int i=1;i<=19;i++){
                 d[i]=d[i-1]+x;
            }
        }
        else{
          for (int i=1;i<=19;i++){
           d[i]=d[i-1]*x;
         }}

        for(int i=0;i<=19;i++) {
            m[i]=""+d[i];
        }

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,m);
        lv.setAdapter(adp);
        lv.setOnCreateContextMenuListener(this);
        lv.setOnItemLongClickListener(this);
    }

    /**
     *
     * This method create the context menu
     */
    @Override
    public void onCreateContextMenu (ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("Options");
        menu.add("item index");
        menu.add("sum");

    }

    /**
     *The method works whem you click an option, if you click "item index" it will put the item index in a textview and if you click "sum" it will put the sum of numbers until the item you chose
     * @param item the selected item
     *
     */
    @Override
    public boolean onContextItemSelected(MenuItem item){
        String oper=item.getTitle().toString();
        if (oper.equals("item index")) {
            tv.setText("index: "+(index+1));
        }
        if (oper.equals("sum")) {
            double sum=0;
            for(int i=0;i<=index;i++) {
                sum+=d[i];
            }
            tv.setText("sum= "+sum);
        }
        return super.onContextItemSelected(item);
    }

    /**
     * going back to the first activity
     *
     */
    public void b(View view) {
        finish();
    }

    /**
     * moving to the credits activity
     */
    public void credi(View view) {
        Intent mi=new Intent(this,Credits.class);
        startActivity(mi);
    }

    /**
     *
     * I use this metod to get the series item index
     * @param position the list view item index
     *
     *
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        index=position;
        return false;
    }
}
