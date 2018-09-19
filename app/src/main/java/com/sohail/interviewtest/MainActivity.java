package com.sohail.interviewtest;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   RecyclerView rv, secondList, thirdList, fourthList;
   Button locationbtn;
   AddCustomAdpater addCustomAdpater;
   OfferCustomAdapter offerCustomAdapter;
    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayList<String> offerList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv= findViewById(R.id.addList);
        secondList=findViewById(R.id.secondList);
        thirdList=findViewById(R.id.thirdList);
        fourthList=findViewById(R.id.fourthList);
        locationbtn=findViewById(R.id.locationBtn);

        //data
        arrayList.add("Mutton Biryani");
        arrayList.add("chicken Biryani");
        arrayList.add("Kebab roll");
        arrayList.add("Tikka roll");
        arrayList.add("Donut");

        //second list data
        offerList.add("https://images.unsplash.com/photo-1514536338919-cd001f6dc6b3?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=48f4f1385c293d8520c1f9c3233a98d6&auto=format&fit=crop&w=800&q=60");
        offerList.add("https://images.unsplash.com/photo-1511690656952-34342bb7c2f2?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=9647d95a500b5e222258fb03ed086ed1&auto=format&fit=crop&w=1000&q=80");
        offerList.add("https://images.unsplash.com/photo-1506354666786-959d6d497f1a?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=86c8c1fd5e9e5b384696472a095c42ac&auto=format&fit=crop&w=1950&q=80");
        offerList.add("https://images.unsplash.com/photo-1505575967455-40e256f73376?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=4d17b6df4cb810b6860782351027b766&auto=format&fit=crop&w=800&q=60");
        offerList.add("https://images.unsplash.com/photo-1505253304499-671c55fb57fe?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=a194e76b2970a942dbb29ba2548d95a0&auto=format&fit=crop&w=800&q=60");
        addCustomAdpater = new AddCustomAdpater(this,arrayList);

        rv.setAdapter(addCustomAdpater);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        offerCustomAdapter = new OfferCustomAdapter(this,offerList);
        secondList.setAdapter(offerCustomAdapter);
        secondList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        thirdList.setAdapter(addCustomAdpater);
        thirdList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        fourthList.setAdapter(offerCustomAdapter);
        fourthList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        locationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this,
                                locationbtn,
                                ViewCompat.getTransitionName(locationbtn));
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }
}
