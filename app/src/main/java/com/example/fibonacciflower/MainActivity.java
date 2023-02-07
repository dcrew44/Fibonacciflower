package com.example.fibonacciflower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ImageView> allPetals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.mainlayout);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Button buttonAddPink = (Button) findViewById(R.id.button);
        Button buttonAddGold = (Button) findViewById(R.id.button2);
        Button clearPetals = (Button) findViewById(R.id.button3);

        Flower flower = new Flower();
        flower.setxCenter(metrics.widthPixels/2);
        flower.setyCenter(metrics.heightPixels/2);

        allPetals = new ArrayList<ImageView>();
        buttonAddGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView petalView = (ImageView) layoutInflater.inflate(R.layout.petal_gold,null);
                petalView.setX(flower.getxCenter());
                petalView.setY(flower.getyCenter());
                petalView.setPivotY(0);
                petalView.setPivotX(100);
                petalView.setScaleX(flower.getScaleX());
                petalView.setScaleY(flower.getScaleY());
                petalView.setRotation(flower.getRotate());

                myLayout.addView(petalView,0);
                allPetals.add(petalView);
                flower.updatePetalValues();

            }
        });

        buttonAddPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView petalView = (ImageView) layoutInflater.inflate(R.layout.petal_pink,null);

                petalView.setX(flower.getxCenter());
                petalView.setY(flower.getyCenter());
                petalView.setPivotY(0);
                petalView.setPivotX(100);
                petalView.setScaleX(flower.getScaleX());
                petalView.setScaleY(flower.getScaleY());
                petalView.setRotation(flower.getRotate());

                myLayout.addView(petalView,0);
                allPetals.add(petalView);
                flower.updatePetalValues();

            }
        });

        clearPetals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < allPetals.size(); i++) {
                    ImageView petal = allPetals.get(i);
                    myLayout.removeView(petal);
                }
                allPetals.clear();
                flower.initialize();

            }
        });



    }


}