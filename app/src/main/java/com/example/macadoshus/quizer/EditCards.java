package com.example.macadoshus.quizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by Macadoshus on 4/2/2017.
 */

public class EditCards extends AppCompatActivity {

    EditText Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_cards);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Title = (EditText) findViewById(R.id.TitleEdit);

        Intent i = getIntent();
        if (i.getExtras() != null) {
            String value = i.getExtras().getString("Card_Title");
            Log.d("SomeMOREBS",i.getExtras().getString("Card_Title"));
            Title.setText(value);
        }
        else{
            Log.d("WOW", "Not Even there");
            Title.setText("SomeBS");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit_text_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.save:

                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("Card_Title", Title.getText().toString());
                i.putExtra("position", getIntent().getIntExtra("position", 0));
                i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(i);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
