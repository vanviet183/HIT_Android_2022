package com.vitvn183.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    TextView note;
    TextView nb1;
    TextView result;
    TextView nb2;
    TextView nb3;
    TextView nb4;
    TextView nb5;
    TextView nb6;
    TextView nb7;
    TextView nb8;
    TextView nb9;
    TextView nb0;
    TextView btnDot;
    TextView btnAdd;
    TextView btnMul;
    TextView btnMod;
    ImageView btnDel;
    ImageView btnDiv;
    TextView btnSub;
    TextView btnC;
    TextView btnCE;
    TextView btnEqual;
    private static float a;
    private static float b;

    Boolean isDel = false;
    Boolean isCalculator = false;
    Boolean isSub = false;
    Boolean isAdd = false;
    Boolean isDiv = false;
    Boolean isMul = false;
    Boolean isMod = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nb1();
        nb2();
        nb3();
        nb4();
        nb5();
        nb6();
        nb7();
        nb8();
        nb9();
        nb0();
        btnDot();
        btnDel();
        btnCE();
        btnC();
        btnSub();
        btnAdd();
        btnMul();
        btnDiv();
        btnMod();
        btnEqual();

    }


    public void updateNumber(String strAdd) {
        String currentResult = getResult();
        if (currentResult.equals("0")) {
            currentResult = strAdd;
            result.setText(strAdd);
        } else {
            String newResult = currentResult + strAdd;
            result.setText(newResult);
        }
    }

    public String getResult() {
        result = findViewById(R.id.result);
        String currentResult = result.getText().toString();
        return currentResult;
    }

    public void nb1() {
        nb1 = findViewById(R.id.nb_1);
        nb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("1");
            }
        });

    }

    public void nb2() {
        nb2 = findViewById(R.id.nb_2);
        nb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("2");
            }
        });

    }

    public void nb3() {
        nb3 = findViewById(R.id.nb_3);
        nb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("3");
            }
        });

    }

    public void nb4() {
        nb4 = findViewById(R.id.nb_4);
        nb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("4");
            }
        });

    }

    public void nb5() {
        nb5 = findViewById(R.id.nb_5);
        nb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("5");
            }
        });

    }

    public void nb6() {
        nb6 = findViewById(R.id.nb_6);
        nb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("6");
            }
        });

    }

    public void nb7() {
        nb7 = findViewById(R.id.nb_7);
        nb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("7");
            }
        });

    }

    public void nb8() {
        nb8 = findViewById(R.id.nb_8);
        nb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("8");
            }
        });

    }

    public void nb9() {
        nb9 = findViewById(R.id.nb_9);
        nb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("9");
            }
        });

    }

    public void nb0() {
        nb0 = findViewById(R.id.nb_0);
        nb0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("0");
            }
        });

    }

    public void btnDot() {
        btnDot = findViewById(R.id.btn_dot);
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber(".");
            }
        });

    }

    public void btnC() {
        result = findViewById(R.id.result);
        note = findViewById(R.id.note);

        btnC = findViewById(R.id.btn_c);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = (float) 0;
                b = (float) 0;
                note.setText("");
                isCalculator = false;
                result.setText("0");
            }
        });
    }

    public void btnCE() {
        result = findViewById(R.id.result);
        note = findViewById(R.id.note);

        btnCE = findViewById(R.id.btn_ce);
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCalculator) {
                    result.setText("0");
                } else {
                    note.setText("");
                    isCalculator = false;
                    result.setText("0");
                }
            }
        });
    }

    public void btnDel() {
        result = findViewById(R.id.result);
        note = findViewById(R.id.note);

        btnDel = findViewById(R.id.btn_del);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = getResult();
                    if (str.length() > 0 && (str.equals("0") == false)) {
                        str = str.substring(0, str.length() - 1);
                        result.setText(str);
                    } else {
                        result.setText(str);
                    }
                    if (str.equals("")) {
                        result.setText("0");
                    }
            }
        });
    }

    public void btnSub() {
        result = findViewById(R.id.result);
        note = findViewById(R.id.note);

        btnSub = findViewById(R.id.btn_sub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Float.parseFloat(getResult());
                isCalculator = true;
                isSub = true;
                note.setText(a + " - ");
                result.setText("0");
            }
        });
    }

    public void btnAdd() {
        result = findViewById(R.id.result);
        note = findViewById(R.id.note);

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Float.parseFloat(getResult());
                isCalculator = true;
                isAdd = true;
                note.setText(a + " + ");
                result.setText("0");
            }
        });
    }

    public void btnMul() {
        result = findViewById(R.id.result);
        note = findViewById(R.id.note);

        btnMul = findViewById(R.id.btn_mul);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a = Float.parseFloat(getResult());
                isCalculator = true;
                isMul = true;
                note.setText(a + " x ");
                result.setText("0");
            }
        });
    }

    public void btnDiv() {
        result = findViewById(R.id.result);
        note = findViewById(R.id.note);

        btnDiv = findViewById(R.id.btn_div);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a = Float.parseFloat(getResult());
                isCalculator = true;
                isDiv = true;
                note.setText(a + " / ");
                result.setText("0");
            }
        });
    }

    public void btnMod() {
        result = findViewById(R.id.result);
        note = findViewById(R.id.note);

        btnMod = findViewById(R.id.btn_mod);
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a = Float.parseFloat(getResult());
                isCalculator = true;
                isMod = true;
                note.setText(a + " % ");
                result.setText("0");
            }
        });
    }

    public void btnEqual() {
        result = findViewById(R.id.result);
        note = findViewById(R.id.note);

        btnEqual = findViewById(R.id.btn_equal);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = Float.parseFloat(getResult());
                note.setText(note.getText().toString() + b + " = ");

                if(isSub) {
                    float x = a - b;
                    result.setText(String.valueOf(x));
                    isSub = false;
                } else if(isAdd) {
                    float x = a + b;
                    result.setText(String.valueOf(x));
                    isAdd = false;
                } else if(isMul) {
                    float x = a * b;
                    result.setText(String.valueOf(x));
                    isMul = false;
                } else if(isDiv) {
                    float x = a / b;
                    result.setText(String.valueOf(x));
                    isDiv= false;
                } else if(isMod) {
                    float x = a % b;
                    result.setText(String.valueOf(x));
                    isMod = false;
                }

                isCalculator = false;
                a = (float) 0;
                b = (float) 0;
            }
        });
    }

}