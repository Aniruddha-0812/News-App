package com.example.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Content_Selection extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content__selection);


        CardView business = findViewById(R.id.business);
        CardView entertain = findViewById(R.id.entertainment);
        CardView science = findViewById(R.id.science);
        CardView health = findViewById(R.id.health);
        CardView sports= findViewById(R.id.sports);
        CardView tech = findViewById(R.id.technology);

        business.setOnClickListener(this);
        entertain.setOnClickListener(this);
        science.setOnClickListener(this);
        health.setOnClickListener(this);
        sports.setOnClickListener(this);
        tech.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.business:

                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.putExtra("URL_TAG","https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=e3ab28da04ac436ebd3ec7aa0d54127a");
                startActivity(intent1);
                break;

            case R.id.entertainment:
                Intent intent = new Intent(this , MainActivity.class);
                intent.putExtra("URL_TAG","https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=e3ab28da04ac436ebd3ec7aa0d54127a");
                startActivity(intent);
                break;

            case R.id.health:
                Intent intent2 = new Intent(this , MainActivity.class);
                intent2.putExtra("URL_TAG","https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=e3ab28da04ac436ebd3ec7aa0d54127a");
                startActivity(intent2);
                break;
            case R.id.science:
                Intent intent3 = new Intent(this , MainActivity.class);
                intent3.putExtra("URL_TAG","https://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=e3ab28da04ac436ebd3ec7aa0d54127a");
                startActivity(intent3);
                break;

            case  R.id.sports:
                Intent intent4 = new Intent(this , MainActivity.class);
                intent4.putExtra("URL_TAG","https://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=e3ab28da04ac436ebd3ec7aa0d54127a");
                startActivity(intent4);
                break;

            case R.id.technology:
                Intent intent5 = new Intent(this , MainActivity.class);
                intent5.putExtra("URL_TAG","https://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=e3ab28da04ac436ebd3ec7aa0d54127a");
                startActivity(intent5);
                break;

            default:
                break;

        }

    }

}
