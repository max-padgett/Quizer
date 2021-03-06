package com.example.macadoshus.quizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private List<CardInfo> cards = new ArrayList<>();;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Button addButton = (Button) findViewById(R.id.add_card);

        addButton.setOnClickListener(onClickListener);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new CardAdapter(cards, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_toolbar, menu);
        return true;
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            cards.add(new CardInfo("Stuff"));
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.join_room:
                Intent i = new Intent(this, JoinRoomActivity.class);
                startActivity(i);
                break;
            case R.id.create_room:
                Intent j = new Intent(this, CreateRoomActivity.class);
                startActivity(j);
                break;
            case R.id.quit:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        setIntent(intent);
        if(intent.getExtras() != null){
            String s = intent.getStringExtra("Card_Title");
            cards.set(intent.getIntExtra("position", 0), new CardInfo(s));
            adapter.notifyDataSetChanged();
            Log.d("SomeStuff", String.valueOf(intent.getIntExtra("position", 0)));
        }
        else
            Log.d("Nothing", "Nothing there");

        adapter.notifyDataSetChanged();
    }


    /*public void setCards(){
        Intent i = getIntent();
        if(i.getExtras() != null){
            String s = i.getStringExtra("Card_Title");
            cards.set(i.getIntExtra("position", 0), new CardInfo(s));
            adapter.notifyDataSetChanged();
            Log.d("SomeStuff", String.valueOf(i.getIntExtra("position", 0)));
        }
        else
            Log.d("Nothing", "Nothing there");
    }*/

}
