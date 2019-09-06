package com.example.calculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabzero;
    private FloatingActionButton fabone;
    private FloatingActionButton fabtwo;
    private FloatingActionButton fabthree;
    private FloatingActionButton fabfour;
    private FloatingActionButton fabfive;
    private FloatingActionButton fabsix;
    private FloatingActionButton fabseven;
    private FloatingActionButton fabeight;
    private FloatingActionButton fabnine;

    private FloatingActionButton nightmodebtn;
    SharedPreferences nightmodepref;

    private FloatingActionButton fabclear;
    private FloatingActionButton fabcleare;
    private FloatingActionButton fabequal;
    private FloatingActionButton fabdot;
    private FloatingActionButton fabplus;
    private FloatingActionButton fabminus;
    private FloatingActionButton fabmultiply;
    private FloatingActionButton fabdivide;
    private FloatingActionButton fabback;


    private TextView resulttv;
    private TextView equtv;


    int nightmode = 0;
    int firstrun = 1;
    int resultpos = 0;
    int equpos = 0;
    int equflag = 1;
    double db1;
    double db2;
    double[] numberarray = new double[100];
    char[] operatorarray = new char[100];
    int napos = 0;
    int opos = 0;
    double result;
    String equ = new String("0");

    int nightmodeprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        nightmodepref = getApplicationContext()
                .getSharedPreferences("night", MODE_PRIVATE);

        final SharedPreferences.Editor editor = nightmodepref.edit();


        if (nightmodepref.getInt("night", 0) == 0 ) {

            editor.putInt("night", 0);


            editor.commit();

        }

        nightmodeprefs = nightmodepref.getInt("night",0);


        if(nightmodeprefs == 0){

            setTheme(R.style.AppTheme);

        } else if (nightmodeprefs == 1) {

            setTheme(R.style.Nighttheme);


        }





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    fabone = (FloatingActionButton) findViewById(R.id.fab1);
    fabtwo = (FloatingActionButton) findViewById(R.id.fab2);
    fabthree = (FloatingActionButton) findViewById(R.id.fab3);
    fabfour = (FloatingActionButton) findViewById(R.id.fab4);
    fabfive = (FloatingActionButton) findViewById(R.id.fab5);
    fabsix = (FloatingActionButton) findViewById(R.id.fab6);
    fabseven = (FloatingActionButton) findViewById(R.id.fab7);
    fabeight = (FloatingActionButton) findViewById(R.id.fab8);
    fabnine = (FloatingActionButton) findViewById(R.id.fab9);
        fabzero = (FloatingActionButton) findViewById(R.id.fab0);
        nightmodebtn = (FloatingActionButton) findViewById(R.id.nightmodebtn);


    fabclear = (FloatingActionButton) findViewById(R.id.fabclear);
    fabcleare = (FloatingActionButton) findViewById(R.id.fabcleare);
    fabequal = (FloatingActionButton) findViewById(R.id.fabequal);
    fabdot = (FloatingActionButton) findViewById(R.id.fabdot);
    fabplus = (FloatingActionButton) findViewById(R.id.fabplus);
    fabminus = (FloatingActionButton) findViewById(R.id.fabminus);
    fabmultiply = (FloatingActionButton) findViewById(R.id.fabmultiply);
    fabdivide = (FloatingActionButton) findViewById(R.id.fabdivide);
    fabback = (FloatingActionButton) findViewById(R.id.fabback);


        resulttv = (TextView) findViewById(R.id.resulttv);
        equtv = (TextView) findViewById(R.id.equtv);


        if (nightmodeprefs == 1) {

            nightmodebtn.setImageResource(R.drawable.ic_sunny);

        }



        fabone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('1');

            }
        });

        fabtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('2');

            }
        });


        fabthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('3');

            }
        });

        fabfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('4');

            }
        });

        fabfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('5');

            }
        });


        fabsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('6');

            }
        });

        fabseven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('7');

            }
        });

        fabeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('8');

            }
        });

        fabnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('9');

            }
        });

        fabzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('0');

            }
        });

        fabplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('+');

            }
        });

        fabminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('-');

            }
        });

        fabmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('x');

            }
        });

        fabdivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('/');

            }
        });

        nightmodebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(nightmodeprefs == 0){

                    setTheme(R.style.Nighttheme);
                    editor.putInt("night", 1);

                    editor.commit();



                } else if (nightmodeprefs == 1) {


                    setTheme(R.style.AppTheme);
                    editor.putInt("night", 0);

                    editor.commit();

                }

                Intent intent = getIntent();
                finish();
                startActivity(intent);



            }
        });

        fabback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(equ.length()!=0){

                    if( (equ.length()>resultpos) && (firstrun == 1) ) {
                equpos = equ.length();
               equ = equ.substring(0, (equpos - 1));
                equtv.setText(equ);
                    } else {

                        equ = equ.substring(0,equ.length() - 1 );
                        resulttv.setText("");
                        equtv.setText(equ);
                        firstrun = 1;


                    }


                }

            }
        });

        fabequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                equpos = equ.length();

                if( (equpos!=0)&& (equ.charAt(equpos-1)!='x') && (equ.charAt(equpos-1)!='/') && (equ.charAt(equpos-1)!='+') && (equ.charAt(equpos-1)!='-') )
                {

                    if((equpos!=0)&& (equ.charAt(0)!='x') && (equ.charAt(0)!='/') && (equ.charAt(0)!='+')) {

                        int flag = 1;

                        for (int i = 0 ; i<(equpos-1) ; i++){

                            if( (equ.charAt(i)=='+') || (equ.charAt(i)=='-') || (equ.charAt(i)=='x') || (equ.charAt(i)=='/') ){


                                if ( (equ.charAt(i+1)=='+') || (equ.charAt(i+1)=='x') || (equ.charAt(i+1)=='/') ) {

                                    flag = 0;
                                    Toast.makeText(getApplicationContext(),"Please check your equation",Toast.LENGTH_SHORT).show();

                                }


                            }



                        }



                        if(flag==1) {
                            findoperator();
                            calculator();
                        }

                    }

                    if((equ=="")) {
                        resulttv.setText("0");

                    }







                }

                equpos = equ.length();
                if((equ.charAt(0)=='x') || (equ.charAt(0)=='/') || (equ.charAt(0)=='+') || (equ.charAt(equpos-1)=='x') || (equ.charAt(equpos-1)=='/') || (equ.charAt(equpos-1)=='+') || (equ.charAt(equpos-1)=='-') ) {

                    Toast.makeText(getApplicationContext(),"Please check your equation",Toast.LENGTH_SHORT).show();

                }

            }


        });


        fabclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                equ = Double.toString(result);

                equtv.setText("");


            }
        });


        fabcleare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                equ = "";
                equtv.setText("");
                result = 0;
                resulttv.setText("");
                equflag = 1;



            }
        });

        fabdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Inserttoequ('.');


            }
        });
















    }


    public void Inserttoequ(char a) {

        if (equflag == 1) {

            equflag = 0;
            equ = "" + a;

        }

        else{

            equ = equ + a;

        }

        equtv.setText(equ);



    }

    public void findoperator() {

        int start=0;


        equpos = equ.length();



        int flag = 0;
        int firstflag = 1;
        int negativeflag = 0;


            for (int i = 0; i < equpos; i++) {

                if(equ.charAt(0)=='-' && firstflag==1){

                i++;

                negativeflag = 1;
                start = 1;
                firstflag = 0;

                }



                if ((equ.charAt(i) == '+') || (equ.charAt(i) == '-') || (equ.charAt(i) == 'x') || (equ.charAt(i) == '/')) {

                    if(equ.charAt(i+1)=='-'){

                        if (flag == 1){

                            flag = 0;

                        } else {

                            flag = 1;

                        }
                    }


                    numberarray[napos] = Double.parseDouble(equ.substring(start, i));
                    napos++;
                    operatorarray[opos] = equ.charAt(i);
                    opos++;

                    if(negativeflag == 1){

                        numberarray[napos-1] = (numberarray[napos-1] * (-1) );
                        negativeflag = 0;
                    }

                    if(flag == 0) {
                        start = (i + 1);
                    } else {

                        start = (i+2);
                        negativeflag = 1;
                        i++;

                    }


                }


            }



            numberarray[napos] = Double.parseDouble(equ.substring(start, equpos));
            if(negativeflag == 1){

                numberarray[napos] = numberarray[napos] * (-1);
            }
            napos++;




    }


    public void calculator(){






        for(int i=0; i<opos; i++) {

            if (operatorarray[i] == '/') {


                numberarray[i] = numberarray[i]/numberarray[i+1];

                reposition(i);
                i=-1;

            }

        }



        for(int i=0; i<opos; i++) {

            if (operatorarray[i] == 'x') {


                numberarray[i] = numberarray[i]*numberarray[i+1];

                reposition(i);
                i=-1;

            }

        }


        for(int i=0; i<opos; i++) {

            if (operatorarray[i] == '-') {


                numberarray[i] = numberarray[i]-numberarray[i+1];

                reposition(i);
                i=-1;

            }

        }

        for(int i=0; i<opos; i++) {

            if (operatorarray[i] == '+') {


                numberarray[i] = numberarray[i]+numberarray[i+1];

                reposition(i);

                i=-1;

            }

        }

        equ = Double.toString(numberarray[0]);
        result = numberarray[0];
        napos = 0;
        opos = 0;
        resulttv.setText(Double.toString(numberarray[0]));
        firstrun = 0;
        resultpos = equ.length();
        equtv.setText("");








    }






    public void reposition(int a){


        for(int i=(a+2); i<=napos; i++){

            numberarray[i-1] = numberarray[i];

        }




        for(int i=(a+1); i<=opos; i++){

            operatorarray[i-1] = operatorarray[i];

        }

        napos--;
        opos--;

    }











}
