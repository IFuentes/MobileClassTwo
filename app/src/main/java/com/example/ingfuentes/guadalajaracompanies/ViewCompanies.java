package com.example.ingfuentes.guadalajaracompanies;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.Button;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class ViewCompanies extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_companies);

        ListView list_view = (ListView)findViewById(R.id.list_view_show);
        //Instancia de listItemAdapter to set the final view
        final ListItemAdapter listItemAdapter = new ListItemAdapter(getBaseContext(),GlobalClass.arrView);
        list_view.setAdapter(listItemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_companies, menu);
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

    public void setItems(){
        //listItem = new ListItem();
        //listItem.setImgCompany (getResources().getDrawable(R.drawable.baymax));
        //listItem.setTxtCompanyName("Continental");
        //listItem.setTxtCompanyGiro("Automotriz");
        //mArrayList.add(listItem);
    }

}
