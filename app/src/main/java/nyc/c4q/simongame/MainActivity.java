package nyc.c4q.simongame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, reset;
    private TextView score, level;
    private LinearLayout appBkg;
    boolean button1, button2, button3,button4;



    ArrayList<Integer> baseList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

    int scoreNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        btn4= (Button) findViewById(R.id.btn4);
        reset= (Button) findViewById(R.id.reset);
        score= (TextView) findViewById(R.id.score);

        appBkg= (LinearLayout) findViewById(R.id.mainLayout);



        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        reset.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        Button b = (Button) view;

        ArrayList<Integer>  lista = new ArrayList<>();




        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);


//
        ArrayList<Integer>  lista2 = new ArrayList<>();





        switch (b.getId()){

            case R.id.reset:


                Collections.shuffle(lista);

                for(int i=0; i < lista.size(); i++){

                    lista2.add(lista.get(i));
                }


                if(reset.getText().equals("Start")){
                    reset.setText("Reset");
                }
                else{
                    reset.setText("Start");
                }

                btn1.setText(lista2.get(0)+"");
                btn2.setText(lista2.get(1)+"");
                btn3.setText(lista2.get(2)+"");
                btn4.setText(lista2.get(3)+"");

                break;


            case R.id.btn1:

                int currentNum=1;

//                if (currentNu!= lista2.get(0)){
//
//                }

//                if(btn1.getText().equals("Clicked")){
//                    btn1.setText("Click");
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//
//                }
//                else{
//                    btn1.setText("Clicked");
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//
//                }
//
//                scoreNum=baseList.get(0);
//
//                score.setText(scoreNum+"");


                break;

            case R.id.btn2:

//                if(btn2.getText().equals("Clicked")){
//                    btn2.setText("Click");
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//
//                }
//                else{
//                    btn2.setText("Clicked");
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//
//                }
//
//                scoreNum=baseList.get(1);
//
//                score.setText(scoreNum+"");

                break;

            case R.id.btn3:

//                if(btn3.getText().equals("Clicked")){
//                    btn3.setText("Click");
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//
//                }
//                else{
//                    btn3.setText("Clicked");
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//
//                }
//                scoreNum=baseList.get(2);
//
//                score.setText(scoreNum+"");

                break;

            case R.id.btn4:


//                if(btn4.getText().equals("Clicked")){
//                    btn4.setText("Click");
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//
//                }
//                else{
//                    btn4.setText("Clicked");
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//
//                }
//                scoreNum=baseList.get(3);
//
//                score.setText(scoreNum+"");
                break;


        }



    }
}
