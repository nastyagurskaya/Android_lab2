package com.example.msi.projectn;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;


public class MainActivity extends Activity {
    TextView tvInfo;
    TextView tvInfo_;
    TextView tvAmount;
    EditText etInput;
    Button bControl;
    int guess;
    int amount;
    boolean gameFinished;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView1);
        tvInfo_ = (TextView)findViewById(R.id.textView3);
        tvAmount = (TextView)findViewById(R.id.textView2);
        etInput = (EditText)findViewById(R.id.editText);
        bControl = (Button)findViewById(R.id.button1);
        guess = (int)(Math.random()*100);
        gameFinished = false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onClick(View v){
        if (!gameFinished){
            if (etInput.getText().toString().equals("") || etInput.getText() == null){
                tvInfo_.setText(getResources().getString(R.string.wrong_input));
            }
            else {
                int inp = Integer.parseInt(etInput.getText().toString());
                if (inp < 0 || inp > 100) {
                    tvInfo_.setText(getResources().getString(R.string.out_of_bounds_input));
                } else {
                    amount++;

                    tvAmount.setText(getResources().getString(R.string.try_amount) + amount);
                    if (inp < guess) {
                        tvInfo_.setText(getResources().getString(R.string.ahead));
                    }
                    if (inp > guess) {
                        tvInfo_.setText(getResources().getString(R.string.behind));
                    }
                    if (inp == guess) {
                        tvInfo_.setText(getResources().getString(R.string.hit));
                        bControl.setText(getResources().getString(R.string.play_more));
                        gameFinished = true;
                    }
                }
            }
        }
        else
        {
            guess = (int)(Math.random()*100);
            amount = 0;
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            tvAmount.setText(getResources().getString(R.string.try_amount) + amount);
            gameFinished = false;
        }
        etInput.setText("");
    }
}