package com.hanbit.user.myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText etWeight, etHeight, etName;
    TextView resultCalc;
    Button btnCalc;

    String name, resultText;
    double weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWeight = (EditText)findViewById(R.id.weight);
        etHeight = (EditText)findViewById(R.id.height);
        etName = (EditText)findViewById(R.id.name);
        resultCalc = (TextView)findViewById(R.id.resultCalc);
        btnCalc = (Button)findViewById(R.id.btnCalc);





        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                name = etName.getText().toString();
                height = Double.parseDouble(etHeight.getText().toString());
                weight = Double.parseDouble(etWeight.getText().toString());
                //Integer.parseInt(~~~~) :: 정수 casting

                //getKaup
                kaupService service = new kaupService();
                resultText = service.getKaup(weight, height);

                resultCalc.setText(name+"님의 계산결과: " + resultText);
            }
        });

    }
}
