package com.example.inclassassignment04_yuqingw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView showTextView;
    private Button mCopyButton;
    private Button mTwiceButton;
    private Button mUpButton;
    private Button mDownButton;
    DisplayMetrics metrics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.input_text_view);
        showTextView = (TextView) findViewById(R.id.show_text_view);
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        mCopyButton = (Button)findViewById(R.id.copy_button);
        mCopyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String input = editText.getText().toString();
                showTextView.setText(input);
                showTextView.setTextSize(12);
            }
        });

        mTwiceButton = (Button)findViewById(R.id.twice_button);
        mTwiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String input = showTextView.getText().toString();
                showTextView.setText(input + input);
            }
        });

        mUpButton = (Button)findViewById(R.id.up_button);
        mUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float size = showTextView.getTextSize()/metrics.density;
                showTextView.setTextSize(size + 2);
            }
        });

        mDownButton = (Button)findViewById(R.id.down_button);
        mDownButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float size = showTextView.getTextSize()/metrics.density;
                showTextView.setTextSize(size - 2);
            }
        });
    }

    @Override
    protected void onResume(){
        Toast.makeText(MainActivity.this,"Welcome!",Toast.LENGTH_SHORT).show();
        super.onResume();
    }
}
