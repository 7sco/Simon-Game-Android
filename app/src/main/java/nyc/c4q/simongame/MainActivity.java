package nyc.c4q.simongame;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4, reset;
    private TextView score, level, sequenceText;
    private LinearLayout appBkg;
    boolean button1, button2, button3,button4;
    boolean start, wait;

    private  ArrayList<Integer>  lista = new ArrayList<>();

    private    ArrayList<Integer>  lista2 = new ArrayList<>();

    ArrayList<Integer> baseList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

    int currentNum;


    int counter;

    int count;

    int numbers;

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
        sequenceText= (TextView) findViewById(R.id.sequenceText);

        appBkg= (LinearLayout) findViewById(R.id.mainLayout);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        reset.setOnClickListener(this);

        //Add 1-4 to lista ArrayList
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

    }

    //Method that checks if user clicked the same amount of items in list than it returns either if u pressed
    //all buttons sequence right or wrong
    public void isFull(){

        if ( lista.size() ==counter){

            for(int i=0; i<lista.size();i++){


                if(lista.get(i)== lista2.get(i)){
                    score.setText("+100");
                    break;
                }
                else{
                    score.setText("END!!");
                    break;
                }

            }

        }
        //this will print in the score number the number being pressed here we can implement the changing background as
        //we discuss, every button has a different color background
        else{

            score.setText(currentNum+"");
        }

    }

public void timer(int num){

    btn1.setText("");
    btn1.setBackgroundColor(getResources().getColor(R.color.color1Off));
    btn2.setText("");
    btn2.setBackgroundColor(getResources().getColor(R.color.color2Off));
    btn3.setText("");
    btn3.setBackgroundColor(getResources().getColor(R.color.color3Off));
    btn4.setText("");
    btn4.setBackgroundColor(getResources().getColor(R.color.color4Off));


        switch (num){
            case 1:
                btn1.setText("1");
                btn1.setBackgroundColor(getResources().getColor(R.color.color1On));
                break;
            case 2:
                btn2.setText("2");
                btn2.setBackgroundColor(getResources().getColor(R.color.color2On));
                break;
            case 3:
                btn3.setText("3");
                btn3.setBackgroundColor(getResources().getColor(R.color.color3On));
                break;
            case 4:
                btn4.setText("4");
                btn4.setBackgroundColor(getResources().getColor(R.color.color4On));
                break;

        }

}


    @Override
    public void onClick(View view) {

        Button b = (Button) view;

        String txt="";

        //switch statement that acts on each click
        switch (b.getId()){

            //resets or starts the game
            case R.id.reset:


                sequenceText.setText("");
                txt="";

                //every time we reset we clear the second ArrayList, the bottom text were we are printing the sequence
                lista2.clear();
                score.setText("");
                counter=0;

                //Shuffles numbers inside main list lista
                Collections.shuffle(lista);

                // gets lista size and throws back the sequence, I am printing this at the bottom for reference

                final Queue <Integer> listarandom = new LinkedList<>();

                for(int i=0;i<lista.size();i++){

                    listarandom.offer(lista.get(i));
                    txt = txt + lista.get(i)+"-";

                    sequenceText.setText(txt);
                }




                final Handler handler = new Handler();
                count = 0;

                final Runnable runnable = new Runnable() {
                    public void run() {

                        // need to do tasks on the UI thread


                        if (count < 4) {
                            timer(listarandom.poll());
                            handler.postDelayed(this, 1500);
                            wait=true;
                        }


                        else{
                            btn1.setText("");
                            btn1.setBackgroundColor(getResources().getColor(R.color.color1Off));
                            btn2.setText("");
                            btn2.setBackgroundColor(getResources().getColor(R.color.color2Off));
                            btn3.setText("");
                            btn3.setBackgroundColor(getResources().getColor(R.color.color3Off));
                            btn4.setText("");
                            btn4.setBackgroundColor(getResources().getColor(R.color.color4Off));
                            wait=false;

                        }

                        count++;
                    }
                };
                // trigger first time
                handler.post(runnable);

                //This allows other buttons to be responsive, if user did not start the game all 4 buttons will not do anyhting
                start=true;
                break;

                //All buttons will add to the lista2 its valus to be checked with the isFull() method at the end when 4 presses have been made
            case R.id.btn1:

                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if(start && lista2.size()<=lista.size()){

                    currentNum=1;
                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                }


                //if game has not been started we are showing a toast asking the use to start the game to play
                else{
                    //toast
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;

            case R.id.btn2:
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }

                if(start&& lista2.size()<=lista.size()){
                    currentNum=2;

                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                }

                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;

            case R.id.btn3:
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if(start&& lista2.size()<=lista.size()){
                    currentNum=3;

                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                }



                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }


                break;

            case R.id.btn4:
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if(start&& lista2.size()<=lista.size()){
                    currentNum=4;

                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                }


                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;


        }

    }


}


//###################### Missing Implementations#########3


//-Timer to show case the button sequence before user can click the buttons
//-Implement the score keeping as user wins challenges,
//-If user is able to get all right, a second sequence will be shown before going to the next level
//-Add sound with sequence and as user clicks buttons
//-Bugs Fixes