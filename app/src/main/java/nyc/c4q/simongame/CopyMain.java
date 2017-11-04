//package nyc.c4q.simongame;
//
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * Created by ISCO on 11/2/17.
// */
//
//public class CopyMain {
//}
//
//
//
//
//package nyc.c4q.simongame;
//
//        import android.content.Intent;
//        import android.media.MediaPlayer;
//        import android.os.CountDownTimer;
//        import android.os.Handler;
//        import android.support.v7.app.AppCompatActivity;
//        import android.os.Bundle;
//        import android.util.Log;
//        import android.view.Menu;
//        import android.view.MenuInflater;
//        import android.view.MenuItem;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Button;
//        import android.widget.LinearLayout;
//        import android.widget.TextView;
//        import android.widget.Toast;
//
//        import java.util.ArrayList;
//        import java.util.Arrays;
//        import java.util.Collections;
//        import java.util.LinkedList;
//        import java.util.Queue;
//        import java.util.Random;
//        import java.util.Timer;
//        import java.util.TimerTask;
//        import java.util.concurrent.Executors;
//        import java.util.concurrent.ScheduledExecutorService;
//        import java.util.concurrent.TimeUnit;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private Button btn1, btn2, btn3, btn4, reset;
//    private Button btn1_1, btn2_1, btnmiddle_1, btnmiddle_2, btnmiddle_1_1;
//    private TextView score, level, sequenceText, response;
//    private LinearLayout appBkg;
//
//    boolean start, wait;
//
//    private ArrayList<Integer> lista = new ArrayList<>();
//    private    ArrayList<Integer> lista2 = new ArrayList<>();
//    int currentNum, counter,count, scoreKeeper;
//
//    private MediaPlayer mp;
//    private  MediaPlayer clicks;
//
//    int numbers=0;
//    int delay=1000;
//    int numero=0;
//    int maxNumbers=4;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        setContentView(R.layout.bw_theme);
//
//        //Buttons
//        btn1 =      findViewById(R.id.btn1);
//        btn2 =      findViewById(R.id.btn2);
//        btn3 =      findViewById(R.id.btn3);
//        btn4 =      findViewById(R.id.btn4);
//        reset =     findViewById(R.id.reset);
//
//        //TextView
//        score =         findViewById(R.id.score);
//        sequenceText =  findViewById(R.id.sequenceText);
//        response =      findViewById(R.id.response);
//        level =         findViewById(R.id.levelNumber);
//
//
//
//        btn1_1=(Button)findViewById(R.id.btn1_1);
//        btn2_1=(Button)findViewById(R.id.btn2_1);
//        btnmiddle_1=(Button)findViewById(R.id.btnmiddle_1);
//        btnmiddle_2=(Button)findViewById(R.id.btnmiddle_2);
//        btnmiddle_1_1=(Button)findViewById(R.id.btnmiddle_1_1);
//
//
//        //appBkg= (LinearLayout) findViewById(R.id.mainLayout);
//        appBkg = (LinearLayout) findViewById(R.id.bw_theme);
//
//        btn1.setOnClickListener(this);
//        btn2.setOnClickListener(this);
//        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);
//        reset.setOnClickListener(this);
//
//
//        btn1_1.setOnClickListener(this);
//        btn2_1.setOnClickListener(this);
//        btnmiddle_1.setOnClickListener(this);
//        btnmiddle_2.setOnClickListener(this);
//        btnmiddle_1_1.setOnClickListener(this);
//
//
//
//        btn1_1.setVisibility(View.GONE);
//        btn2_1.setVisibility(View.GONE);
//        btnmiddle_1.setVisibility(View.GONE);
//        btnmiddle_2.setVisibility(View.GONE);
//        btnmiddle_1_1.setVisibility(View.GONE);
//
//        // if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
////        if(getResources().getLayout(R.layout.leveltwo_layout) == content){
////
////        }
//
//        //Add 1-4 to lista ArrayList
//        lista.add(1);
//        lista.add(2);
//        lista.add(3);
//        lista.add(4);
//
//        mp = MediaPlayer.create(this, R.raw.click);
//        clicks = MediaPlayer.create(this, R.raw.clicks);
//
//        //sound
//
//    }
//
//
//
//    //####################  Level Menu  ################
//
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
//
//    //---------------------------------------------------
//
//    //############ method that checks user input ############
//
//    //Method that checks if user clicked the same amount of items in list than it returns either if u pressed
//    //all buttons sequence right or wrong
//    public void isFull(){
//
//        //When the lista size is equal t counter which increases with each click then this runs
//        if ( lista2.size() == counter) {
//
//            for (int i = 0; i < counter; i++) {
//
//                numbers=0;
//                if(lista2.get(i) == lista.get(i)){
//
//                    numbers= numbers+10;
//                    //score.setText(scoreKeeper+"");
//                } else{
//                    numbers= 0;
//                    onClick(reset);
//                    response.setText("Play Again");
//
//                    Toast toast = Toast.makeText(getApplicationContext(), "WRONG", Toast.LENGTH_SHORT);
//                    toast.show();
//
//                    break;
//
//                    //numbers=0;
//                }
//            }
//
//            scoreKeeper=scoreKeeper+numbers;
//
//
//
//
//            if (scoreKeeper >= 80) {
//                nextLevel(scoreKeeper);
//            }
//
//            if (lista2.size()==maxNumbers){
//                onClick(reset);
//            }
//
//
//            score.setText(scoreKeeper+"");
//
//
//        }
//
//    }
////-------------------------------------------------
//
//
//    //############ Shows button that send to new view ############
//
//    public void nextLevel(int num) {
//
//
//        if (num == 80 && numero == 0) {
//
//
//            delay -= 100;
//
//            response.setText("PlAY!");
//            level.setText("2");
//
//            btn1_1.setVisibility(View.VISIBLE);
//            btn2_1.setVisibility(View.VISIBLE);
//
//            lista.add(5);
//            lista.add(6);
//
//            maxNumbers = 6;
//
//            numero++;
//
//        }
//
//        if (num == 200 && numero == 1) {
//            delay -= 100;
//
//            response.setText("PlAY!");
//            level.setText("3");
//
//            btnmiddle_1.setVisibility(View.VISIBLE);
//            btnmiddle_2.setVisibility(View.VISIBLE);
//
//            lista.add(7);
//            lista.add(8);
//
//            maxNumbers = 8;
//
//            numero++;
//        }
//
//
//
//        if (num == 380 && numero == 2) {
//            delay -= 100;
//
//            response.setVisibility(View.GONE);
//            level.setText("4");
//
//            btnmiddle_1_1.setVisibility(View.VISIBLE);
//
//
//            lista.add(9);
//
//
//            maxNumbers = 9;
//
//            numero++;
//        }
//
//    }
//
//
////-------------------------------------------------
//
//    //############ Changes the color of buttons in intervals  ############
//    public void timer(int num){
//
//        turnOffButtonss();
//
//
//        switch (num){
//            case 1:
//                mp.start();
//                btn1.setText("1");
//                btn1.setBackgroundColor(getResources().getColor(R.color.color1On));
//
//                break;
//            case 2:
//                mp.start();
//                btn2.setText("2");
//                btn2.setBackgroundColor(getResources().getColor(R.color.color2On));
//                break;
//            case 3:
//                mp.start();
//                btn3.setText("3");
//                btn3.setBackgroundColor(getResources().getColor(R.color.color3On));
//                break;
//            case 4:
//                mp.start();
//                btn4.setText("4");
//                btn4.setBackgroundColor(getResources().getColor(R.color.color4On));
//                break;
//
//            case 5:
//                btn1_1.setText("5");
//                btn1_1.setBackgroundColor(getResources().getColor(R.color.color1_1On));
//
//                break;
//            case 6:
//                btn2_1.setText("6");
//                btn2_1.setBackgroundColor(getResources().getColor(R.color.color2_1On));
//
//                break;
//
//            case 7:
//                btnmiddle_1.setText("7");
//                btnmiddle_1.setBackgroundColor(getResources().getColor(R.color.colormiddle_1));
//
//                break;
//
//            case 8:
//                btnmiddle_2.setText("8");
//                btnmiddle_2.setBackgroundColor(getResources().getColor(R.color.colormiddle_2));
//
//                break;
//
//            case 9:
//                btnmiddle_1_1.setText("9");
//                btnmiddle_1_1.setBackgroundColor(getResources().getColor(R.color.colormiddle_1_1));
//
//                break;
//            default:
//                break;
//        }
//
//
//
//    }
////-------------------------------------------------
//
//    //############ Button click actions  ############
//
//
//    @Override
//    public void onClick(View view) {
//
//        //score.setText(scoreKeeper+"");
//
//        Button b = (Button) view;
//
//        String txt="";
//
//        //switch statement that acts on each click
//        switch (b.getId()){
//
//            //resets or starts the game
//            case R.id.reset:
//
//                mp.start();
//
////                appBkg.setBackgroundColor(getResources().getColor(R.color.mainColor));
//
//                sequenceText.setText("");
//                txt="";
//
//                //every time we reset we clear the second ArrayList, the bottom text were we are printing the sequence
//                lista2.clear();
//                //score.setText("");
//                counter=0;
//
//                //Shuffles numbers inside main list lista
//                Collections.shuffle(lista);
//
//                // gets lista size and throws back the sequence, I am printing this at the bottom for reference
//
//                final Queue<Integer> listarandom = new LinkedList<>();
//
//                for(int i=0;i<lista.size();i++){
//
//                    //******  Here Iput each number from the random array into the queue
//
//                    listarandom.offer(lista.get(i));
//                    txt = txt + lista.get(i)+"-";
//
//                    sequenceText.setText(txt);
//                }
//
//                final Handler handler = new Handler();
//                count = 0;
//
//                final Runnable runnable = new Runnable() {
//                    public void run() {
//
//                        // need to do tasks on the UI thread
//
//                        //***************   Here each number from the queue will be set as value into my method that has a switch that takes the incoming number and lights up
//                        // the button
//                        if (count < maxNumbers && listarandom.size()!= 0) {
//                            timer(listarandom.poll());
//                            //mp.stop();
//                            handler.postDelayed(this, delay);
//                            wait=true;
//                        }
//
//                        else{
//
//                            turnOffButtonss();
//
//                            wait=false;
//                        }
//                        count++;
//                    }
//                };
//                // trigger first time
//                handler.post(runnable);
//
//                //This allows other buttons to be responsive, if user did not start the game all 4 buttons will not do anyhting
//                start=true;
//
//                break;
//
//            //All buttons will add to the lista2 its valus to be checked with the isFull() method at the end when 4 presses have been made
//            case R.id.btn1:
//                turnOffButtonss();
//                //clicks.stop();
//                //mp.start();
//
//                if(wait){
//                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }
//
//                //Once 4 clicks have been made it disables the buttons response
//                if(counter==maxNumbers){
//                    start=false;
//                    break;
//                }
//
//                if(start && lista2.size()<=lista.size()&& counter<maxNumbers){
//                    btn1.animate();
//                    clicks.start();
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.color1Off));
//                    btn1.setBackgroundColor(getResources().getColor(R.color.color1On));
//                    currentNum=1;
//                    lista2.add(currentNum);
//                    counter ++;
//                    isFull();
//                }
//
//                //if game has not been started we are showing a toast asking the use to start the game to play
//                else{
//                    //toast
//                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//                break;
//
//            case R.id.btn2:
//                turnOffButtonss();
//                //clicks.stop();
//                if(wait){
//                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }
//
//                if(counter==maxNumbers){
//                    start=false;
//                    break;
//                }
//
//                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
//                    clicks.start();
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.color2Off));
//                    btn2.setBackgroundColor(getResources().getColor(R.color.color2On));
//                    currentNum=2;
//                    lista2.add(currentNum);
//                    counter ++;
//                    isFull();
//                } else{
//                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//                break;
//
//            case R.id.btn3:
//                //clicks.stop();
//                turnOffButtonss();
//                if(wait){
//                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }
//
//                if(counter==maxNumbers){
//                    start=false;
//                    break;
//                }
//
//                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
//                    clicks.start();
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.color3Off));
//                    btn3.setBackgroundColor(getResources().getColor(R.color.color3On));
//                    currentNum=3;
//                    lista2.add(currentNum);
//                    counter ++;
//                    isFull();
//                } else {
//                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//
//                break;
//
//            case R.id.btn4:
//                turnOffButtonss();
//                //clicks.stop();
//                if(wait){
//                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }
//                if(counter==maxNumbers){
//                    start=false;
//                    break;
//                }
//
//                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
//
//
//                    clicks.start();
//                    appBkg.setBackgroundColor(getResources().getColor(R.color.color4Off));
//                    btn4.setBackgroundColor(getResources().getColor(R.color.color4On));
//                    currentNum=4;
//                    lista2.add(currentNum);
//                    counter ++;
//                    isFull();
//                } else{
//                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//
//                break;
//
//
//            case R.id.btn1_1:
//                turnOffButtonss();
//                //clicks.stop();
//                if(wait){
//                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }
//                if(counter==maxNumbers){
//                    start=false;
//                    break;
//                }
//
//                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
//
//
//                    clicks.start();
//                    //appBkg.setBackgroundColor(getResources().getColor(R.color.color1_1Off));
//                    btn1_1.setBackgroundColor(getResources().getColor(R.color.color1_1On));
//                    currentNum=5;
//                    lista2.add(currentNum);
//                    counter ++;
//                    isFull();
//                } else{
//                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//
//                break;
//
//
//            case R.id.btn2_1:
//                turnOffButtonss();
//                //clicks.stop();
//                if(wait){
//                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }
//                if(counter==maxNumbers){
//                    start=false;
//                    break;
//                }
//
//                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
//
//
//                    clicks.start();
//                    //appBkg.setBackgroundColor(getResources().getColor(R.color.color1_1Off));
//                    btn2_1.setBackgroundColor(getResources().getColor(R.color.color2_1On));
//                    currentNum=6;
//                    lista2.add(currentNum);
//                    counter ++;
//                    isFull();
//                } else{
//                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//
//                break;
//
//            case R.id.btnmiddle_1:
//                turnOffButtonss();
//                //clicks.stop();
//                if(wait){
//                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }
//                if(counter==maxNumbers){
//                    start=false;
//                    break;
//                }
//
//                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
//
//
//                    clicks.start();
//                    //appBkg.setBackgroundColor(getResources().getColor(R.color.color1_1Off));
//                    btnmiddle_1.setBackgroundColor(getResources().getColor(R.color.colormiddle_1));
//                    currentNum=7;
//                    lista2.add(currentNum);
//                    counter ++;
//                    isFull();
//                } else{
//                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//
//                break;
//
//            case R.id.btnmiddle_2:
//                turnOffButtonss();
//                //clicks.stop();
//                if(wait){
//                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }
//                if(counter==maxNumbers){
//                    start=false;
//                    break;
//                }
//
//                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
//
//
//                    clicks.start();
//                    //appBkg.setBackgroundColor(getResources().getColor(R.color.color1_1Off));
//                    btnmiddle_2.setBackgroundColor(getResources().getColor(R.color.colormiddle_2));
//                    currentNum=8;
//                    lista2.add(currentNum);
//                    counter ++;
//                    isFull();
//                } else{
//                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//
//                break;
//
//            case R.id.btnmiddle_1_1:
//                turnOffButtonss();
//                //clicks.stop();
//                if(wait){
//                    Toast toast = Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }
//                if(counter==maxNumbers){
//                    start=false;
//                    break;
//                }
//
//                if(start&& lista2.size()<=lista.size()&& counter<maxNumbers){
//
//
//                    clicks.start();
//                    //appBkg.setBackgroundColor(getResources().getColor(R.color.color1_1Off));
//                    btnmiddle_1_1.setBackgroundColor(getResources().getColor(R.color.colormiddle_1_1));
//                    currentNum=9;
//                    lista2.add(currentNum);
//                    counter ++;
//                    isFull();
//                } else{
//                    Toast toast = Toast.makeText(getApplicationContext(), "Start App first", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//
//                break;
//            default:
//                break;
//        }
//    }
//    //-------------------------------------------------
//
//    //#########################  END  ################################
//
//
//
//    public void turnOffButtonss(){
//
//        btn1.setText("");
//        //btn1.setBackgroundColor(getResources().getColor(R.color.color1Off));
//        btn1.setBackgroundColor(getResources().getColor(R.color.gray));
//        btn2.setText("");
//        //btn2.setBackgroundColor(getResources().getColor(R.color.color2Off));
//        btn2.setBackgroundColor(getResources().getColor(R.color.gray));
//        btn3.setText("");
//        //btn3.setBackgroundColor(getResources().getColor(R.color.color3Off));
//        btn3.setBackgroundColor(getResources().getColor(R.color.gray));
//        btn4.setText("");
//        //btn4.setBackgroundColor(getResources().getColor(R.color.color4Off));
//        btn4.setBackgroundColor(getResources().getColor(R.color.gray));
//        btn1_1.setText("");
//        btn1_1.setBackgroundColor(getResources().getColor(R.color.gray));
//        btn2_1.setText("");
//        btn2_1.setBackgroundColor(getResources().getColor(R.color.gray));
//        btnmiddle_1.setText("");
//        btnmiddle_1.setBackgroundColor(getResources().getColor(R.color.gray));
//        btnmiddle_2.setText("");
//        btnmiddle_2.setBackgroundColor(getResources().getColor(R.color.gray));
//
//        btnmiddle_1_1.setText("");
//        btnmiddle_1_1.setBackgroundColor(getResources().getColor(R.color.gray));
//
//
//    }
//
//}
//
////###################### Missing Implementations#########3
//
//
////-Timer to show case the button sequence before user can click the buttons(DONE!)
//
////-Implement the score keeping as user wins challenges,
////-If user is able to get all right, a second sequence will be shown before going to the next level
////-Add sound with sequence and as user clicks buttons
////-Bugs Fixes
//
//
