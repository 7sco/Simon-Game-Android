package nyc.c4q.simongame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
    //Buttons
    private Button btn1, btn2, btn3, btn4, reset;
    private Button btn1_1, btn2_1, btnmiddle_1, btnmiddle_2, btnmiddle_1_1;

    private int levels=0;

    //Textview
    private TextView score, level, sequenceText, response;

    //Linear Layout
    private LinearLayout appBkg;

    boolean start, wait;

    //Lists
    private  ArrayList<Integer> lista   = new ArrayList<>();
    private  ArrayList<Integer> lista2  = new ArrayList<>();


    int currentNum, counter,count, scoreKeeper;
    int numbers     =   0;
    int delay       =   1000;
    int numero      =   0;
    int maxNumbers  =   4;
    int q=0;
    //Media player(Sounds)
    private  MediaPlayer mp;
    private  MediaPlayer clicks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.bw_theme);

        //Buttons
        btn1            = findViewById(R.id.btn1);
        btn2            = findViewById(R.id.btn2);
        btn3            = findViewById(R.id.btn3);
        btn4            = findViewById(R.id.btn4);
        btn1_1          = findViewById(R.id.btn1_1);
        btn2_1          = findViewById(R.id.btn2_1);
        btnmiddle_1     = findViewById(R.id.btnmiddle_1);
        btnmiddle_2     = findViewById(R.id.btnmiddle_2);
        btnmiddle_1_1   = findViewById(R.id.btnmiddle_1_1);

        //reset button
        reset           = findViewById(R.id.reset);

        //TextView
        score           =   findViewById(R.id.score);
        sequenceText    =   findViewById(R.id.sequenceText);
        response        =   findViewById(R.id.response);
        level           =   findViewById(R.id.levelNumber);


        //appBkg= (LinearLayout) findViewById(R.id.mainLayout);
        appBkg = (LinearLayout) findViewById(R.id.bw_theme);


        //Button Listeners
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn1_1.setOnClickListener(this);
        btn2_1.setOnClickListener(this);
        btnmiddle_1.setOnClickListener(this);
        btnmiddle_2.setOnClickListener(this);
        btnmiddle_1_1.setOnClickListener(this);
        reset.setOnClickListener(this);


        //Hide Buttons
        btn1_1.setVisibility(View.GONE);
        btn2_1.setVisibility(View.GONE);
        btnmiddle_1.setVisibility(View.GONE);
        btnmiddle_2.setVisibility(View.GONE);
        btnmiddle_1_1.setVisibility(View.GONE);

        //Add first 4 number to array list(represnt the buttons available)
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        //Media Player initialization
        mp       = MediaPlayer.create(this, R.raw.click);
        clicks   = MediaPlayer.create(this, R.raw.clicks);

    }

    //####################  Level Menu  ################

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_levels, menu);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.levelOne:
//
//                //setContentView(R.layout.activity_main);
//                delay-=100;
//
//                //Log.e(TAG, "setting was clicked");
//                break;
//            case R.id.levelTwo:
//
//                //setContentView(R.layout.leveltwo_layout);
//                setContentView(R.layout.bw_theme);
//                break;
//
//            case R.id.levelThree:
//
//                //setContentView(R.layout.leveltwo_layout);
//                setContentView(R.layout.activity_main);
//                break;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//        return true;
//
//    }

    //---------------------------------------------------

    //############ method that checks user input ############

    //Method that checks if user clicked the same amount of items in list than it returns either if u pressed
    //all buttons sequence right or wrong
    public void isFull(){

        int saved=0;
        //When the lista size is equal t counter which increases with each click then this runs
        if ( lista2.size() == counter) {

            for (int i = 0; i < counter; i++) {

                numbers=0;
                if(lista2.get(i) == lista.get(i)){

                    numbers= numbers+10;

                } else{
                    levelsHide(levels);

                    numbers = numbers;

                    response.setText("Play Again");
                    Toast toast = Toast.makeText(getApplicationContext(), "WRONG", Toast.LENGTH_SHORT);
                    toast.show();
                    response.setText("Wrong !!!");

                    final Handler handler6 = new Handler();
                    handler6.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 100ms

                            levelsShow(levels);
                        }
                    }, 2000);

                    final Handler handler5 = new Handler();
                    handler5.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 100ms

                            response.setText("Play !!!");

                            reset();
                        }
                    }, 2500);

                    turnOffButtonss();

                    break;
                }
            }
            scoreKeeper=scoreKeeper+numbers;

            score.setText(scoreKeeper+"");

            if (scoreKeeper >= 80) {
                nextLevel(scoreKeeper);
            }
        }

        if (lista2.size()==maxNumbers){

            reset();
        }
    }

    public void reset(){
        final Handler handler4 = new Handler();
        handler4.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                onClick(reset);
            }
        }, 2000);
    }
//-------------------------------------------------

    //SET VISIBILITY  INVISIBLE

    public void levelsHide(int num){

        if (num==0){
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);
        }

        else if(num==1){
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);
            btn1_1.setVisibility(View.INVISIBLE);
            btn2_1.setVisibility(View.INVISIBLE);
        }

        else if(num==2){
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);
            btn1_1.setVisibility(View.INVISIBLE);
            btn2_1.setVisibility(View.INVISIBLE);
            btnmiddle_1.setVisibility(View.INVISIBLE);
            btnmiddle_2.setVisibility(View.INVISIBLE);
        }

        else if(num==3){
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);
            btn3.setVisibility(View.INVISIBLE);
            btn4.setVisibility(View.INVISIBLE);
            btn1_1.setVisibility(View.INVISIBLE);
            btn2_1.setVisibility(View.INVISIBLE);
            btnmiddle_1.setVisibility(View.INVISIBLE);
            btnmiddle_2.setVisibility(View.INVISIBLE);
            btnmiddle_1_1.setVisibility(View.INVISIBLE);
        }
    }

    //SET VISIBILITY  VISIBLE

    public void levelsShow(int num){

        if (num==0){
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
        }

        else if(num==1){
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
            btn1_1.setVisibility(View.VISIBLE);
            btn2_1.setVisibility(View.VISIBLE);
        }

        else if(num==2){
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
            btn1_1.setVisibility(View.VISIBLE);
            btn2_1.setVisibility(View.VISIBLE);
            btnmiddle_1.setVisibility(View.VISIBLE);
            btnmiddle_2.setVisibility(View.VISIBLE);

        }
        else if(num==3){
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
            btn1_1.setVisibility(View.VISIBLE);
            btn2_1.setVisibility(View.VISIBLE);
            btnmiddle_1.setVisibility(View.VISIBLE);
            btnmiddle_2.setVisibility(View.VISIBLE);
            btnmiddle_1_1.setVisibility(View.VISIBLE);
        }
    }

    //############ Displays buttons for levels ############

    public void nextLevel(int num) {


        if (num == 80 && numero == 0) {
            response.setText("Next Level..!!");
            levelsHide(levels);
            final Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 100ms
                    levelsShow(levels);

                    delay -= 200;
                    //response.setText("Click t Start");
                    level.setText("2");
                    btn1_1.setVisibility(View.VISIBLE);
                    btn2_1.setVisibility(View.VISIBLE);
                    lista.add(5);
                    lista.add(6);
                    maxNumbers = 6;
                    numero++;
                    levels=1;

                }
            }, 1000);



        }

        if (num == 200 && numero == 1) {
            response.setText("Next Level..!!");
            levelsHide(levels);
            final Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
             @Override
             public void run() {
                 levelsShow(levels);
                 delay -= 200;
                 response.setText("PlAY!");
                 level.setText("3");
                 btnmiddle_1.setVisibility(View.VISIBLE);
                 btnmiddle_2.setVisibility(View.VISIBLE);
                 lista.add(7);
                 lista.add(8);
                 maxNumbers = 8;
                 numero++;
                 levels=2;
             }
            }, 1000);

        }

        if (num == 360 && numero == 2) {




            response.setText("Next Level..!!");
            levelsHide(levels);
            final Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    levelsShow(levels);
                    delay -= 200;
                    response.setText("PlAY!");
                    response.setVisibility(View.GONE);
                    level.setText("4");
                    btnmiddle_1_1.setVisibility(View.VISIBLE);
                    lista.add(9);
                    maxNumbers = 9;
                    numero++;
                    levels=3;
                }
            }, 1000);

        }

        }


//-------------------------------------------------

    //############ Changes the color of buttons in intervals  ############
public void timer(int num){

        turnOffButtonss();


        switch (num){
            case 1:
                mp.start();
                btn1.setText("1");
                btn1.setBackgroundColor(getResources().getColor(R.color.color1On));

                break;
            case 2:
                mp.start();
                btn2.setText("2");
                btn2.setBackgroundColor(getResources().getColor(R.color.color2On));
                break;
            case 3:
                mp.start();
                btn3.setText("3");
                btn3.setBackgroundColor(getResources().getColor(R.color.color3On));
                break;
            case 4:
                mp.start();
                btn4.setText("4");
                btn4.setBackgroundColor(getResources().getColor(R.color.color4On));
                break;

            case 5:
                mp.start();
                btn1_1.setText("5");
                btn1_1.setBackgroundColor(getResources().getColor(R.color.color1_1On));

                break;
            case 6:
                mp.start();
                btn2_1.setText("6");
                btn2_1.setBackgroundColor(getResources().getColor(R.color.color2_1On));

                break;

            case 7:
                mp.start();
                btnmiddle_1.setText("7");
                btnmiddle_1.setBackgroundColor(getResources().getColor(R.color.colormiddle_1));

                break;

            case 8:
                mp.start();
                btnmiddle_2.setText("8");
                btnmiddle_2.setBackgroundColor(getResources().getColor(R.color.colormiddle_2));

                break;

            case 9:
                mp.start();
                btnmiddle_1_1.setText("9");
                btnmiddle_1_1.setBackgroundColor(getResources().getColor(R.color.colormiddle_1_1));

                break;
            default:
                break;
        }
}
//-------------------------------------------------

//############ Turn Off Buttons  ############

    public void turnOffButtonss(){

        btn1.setText("");
        //btn1.setBackgroundColor(getResources().getColor(R.color.color1Off));
        btn1.setBackgroundColor(getResources().getColor(R.color.gray));
        btn2.setText("");
        //btn2.setBackgroundColor(getResources().getColor(R.color.color2Off));
        btn2.setBackgroundColor(getResources().getColor(R.color.gray));
        btn3.setText("");
        //btn3.setBackgroundColor(getResources().getColor(R.color.color3Off));
        btn3.setBackgroundColor(getResources().getColor(R.color.gray));
        btn4.setText("");
        //btn4.setBackgroundColor(getResources().getColor(R.color.color4Off));
        btn4.setBackgroundColor(getResources().getColor(R.color.gray));
        btn1_1.setText("");
        btn1_1.setBackgroundColor(getResources().getColor(R.color.gray));
        btn2_1.setText("");
        btn2_1.setBackgroundColor(getResources().getColor(R.color.gray));
        btnmiddle_1.setText("");
        btnmiddle_1.setBackgroundColor(getResources().getColor(R.color.gray));
        btnmiddle_2.setText("");
        btnmiddle_2.setBackgroundColor(getResources().getColor(R.color.gray));
        btnmiddle_1_1.setText("");
        btnmiddle_1_1.setBackgroundColor(getResources().getColor(R.color.gray));
    }

    //-------------------------------------------------


    //############ Button click actions  ############


    @Override
    public void onClick(View view) {

        Button b = (Button) view;
        String txt="";

        //switch statement that acts on each click
        switch (b.getId()){

            //resets or starts the game
            case R.id.reset:
                response.setText("Remeber!!");

                levelsShow(levels);
                mp.start();

            //appBkg.setBackgroundColor(getResources().getColor(R.color.mainColor));

                sequenceText.setText("");
                txt="";

                //every time we reset we clear the second ArrayList, the bottom text were we are printing the sequence
                lista2.clear();
                //score.setText("");
                counter=0;

                //Shuffles numbers inside main list lista
                Collections.shuffle(lista);

                // gets lista size and throws back the sequence, I am printing this at the bottom for reference

                final Queue <Integer> listarandom = new LinkedList<>();

                for(int i=0;i<lista.size();i++){

                    //******  Here Iput each number from the random array into the queue

                    listarandom.offer(lista.get(i));
                    txt = txt + lista.get(i)+"-";

                    sequenceText.setText(txt);
                }

                final Handler handler = new Handler();
                count = 0;

                final Runnable runnable = new Runnable() {
                    public void run() {


//***************   Here each number from the queue will be set as value into my method that has a switch that takes the incoming number and lights up
                        // the button
                        if (count < maxNumbers && listarandom.size()!= 0) {
                            timer(listarandom.poll());
                            //mp.stop();
                            handler.postDelayed(this, delay);
                            wait=true;
                        }

                        else{

                            turnOffButtonss();
                            response.setText("Play!!");

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

            //==================  Button 1 -------------
            case R.id.btn1:
                turnOffButtonss();

                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }

                //Once 4 clicks have been made it disables the buttons response
                if(counter==maxNumbers){
                    start=false;
                    break;
                }

                if(start && lista2.size()<=lista.size()&& counter<maxNumbers){
                   // btn1.animate();
                    clicks.start();
                    btn1.setBackgroundColor(getResources().getColor(R.color.color1On));
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

            //==================  Button 2 -------------
            case R.id.btn2:
                turnOffButtonss();
                //clicks.stop();
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }

                if(counter==maxNumbers){
                    start=false;
                    break;
                }

                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
                    clicks.start();
                    btn2.setBackgroundColor(getResources().getColor(R.color.color2On));
                    currentNum=2;
                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                } else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;

            //==================  Button 3 -------------
            case R.id.btn3:
                //clicks.stop();
                turnOffButtonss();
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }

                if(counter==maxNumbers){
                    start=false;
                    break;
                }

                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
                    clicks.start();
                    btn3.setBackgroundColor(getResources().getColor(R.color.color3On));
                    currentNum=3;
                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;

            //==================  Button 4 -------------
            case R.id.btn4:
                turnOffButtonss();
                //clicks.stop();
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if(counter==maxNumbers){
                    start=false;
                    break;
                }

                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){


                    clicks.start();
                    btn4.setBackgroundColor(getResources().getColor(R.color.color4On));
                    currentNum=4;
                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                } else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;

            //==================  Button 5 -------------
            case R.id.btn1_1:
                turnOffButtonss();
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if(counter==maxNumbers){
                    start=false;
                    break;
                }

                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){

                    clicks.start();
                    btn1_1.setBackgroundColor(getResources().getColor(R.color.color1_1On));
                    currentNum=5;
                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                } else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;

            //==================  Button 6 -------------
            case R.id.btn2_1:
                turnOffButtonss();
                //clicks.stop();
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if(counter==maxNumbers){
                    start=false;
                    break;
                }

                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){

                    clicks.start();
                    btn2_1.setBackgroundColor(getResources().getColor(R.color.color2_1On));
                    currentNum=6;
                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                } else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;

            //==================  Button 7 -------------
            case R.id.btnmiddle_1:

                turnOffButtonss();
                //clicks.stop();
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if(counter==maxNumbers){
                    start=false;
                    break;
                }

                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){

                    clicks.start();
                    btnmiddle_1.setBackgroundColor(getResources().getColor(R.color.colormiddle_1));
                    currentNum=7;
                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                } else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;

            //==================  Button 8 -------------
            case R.id.btnmiddle_2:
                turnOffButtonss();
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if(counter==maxNumbers){
                    start=false;
                    break;
                }

                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){


                    clicks.start();
                    btnmiddle_2.setBackgroundColor(getResources().getColor(R.color.colormiddle_2));
                    currentNum=8;
                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                } else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;

            //==================  Button 9 -------------
            case R.id.btnmiddle_1_1:
                turnOffButtonss();
                if(wait){
                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if(counter==maxNumbers){
                    start=false;
                    break;
                }

                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){

                    clicks.start();
                    btnmiddle_1_1.setBackgroundColor(getResources().getColor(R.color.colormiddle_1_1));
                    currentNum=9;
                    lista2.add(currentNum);
                    counter ++;
                    isFull();
                } else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
                    toast.show();
                }

                break;
            default:
                    break;
        }

    }
    //-------------------------------------------------

}
    //#########################  END  ################################
