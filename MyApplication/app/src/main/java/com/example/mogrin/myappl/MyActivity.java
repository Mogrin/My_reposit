package com.example.mogrin.myappl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity implements OnClickListener {

    Button btn;
    TextView txt1, txt2;
    EditText etxt, etxt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        btn = (Button) findViewById(R.id.button);
        txt1 = (TextView) findViewById(R.id.textView);
        txt2 = (TextView) findViewById(R.id.textView3);
        etxt = (EditText) findViewById(R.id.editText);
        etxt1 = (EditText) findViewById(R.id.editText1);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Double num1 = 0.0, num2 = 0.0, res = 0.0;

        if(TextUtils.isEmpty(etxt1.getText().toString()) ||
           TextUtils.isEmpty(etxt1.getText().toString()))
        {
            return;
        }

        num1 = Double.parseDouble(etxt.getText().toString());
        num2 = Double.parseDouble(etxt1.getText().toString());

        switch (v.getId()) {
            case R.id.button:
                res = num1 * num2;
                break;
        }

        txt2.setText(res.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
