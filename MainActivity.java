package com.example.android.actionbareg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //we will customize the actionbar
        ActionBar actionBar = getSupportActionBar(); //first get our actionbar
        actionBar.setTitle("WELCOME");
        //you can remove title
        //actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);      //display <- mark
        //actionBar.hide();   //it closes actionbar
        //actionBar.show();   //it shows actionbar again

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id)
        {
            case android.R.id.home:
                finish();
                break;
            case R.id.accept:
                Toast.makeText(MainActivity.this, "ACCEPTED", Toast.LENGTH_SHORT).show();
                break;
            case R.id.call:
                Intent intent = new Intent();      //IMPLICIT Intent in interview question
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel://08041645630"));
                startActivity(intent);
                break;
            case R.id.cancel:
                Toast.makeText(MainActivity.this, "CANCELLED", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
