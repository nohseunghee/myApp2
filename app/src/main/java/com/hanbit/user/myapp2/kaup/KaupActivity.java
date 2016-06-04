package com.hanbit.user.myapp2.kaup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.main.MainActivity;

public class KaupActivity extends Activity  implements View.OnClickListener  {
    EditText etWeight, etHeight, etName;
    TextView resultCalc;
    Button btnCalc;

    String name, resultText;
    double weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaup);


        etWeight = (EditText)findViewById(R.id.weight);
        etHeight = (EditText)findViewById(R.id.height);
        etName = (EditText)findViewById(R.id.name);
        resultCalc = (TextView)findViewById(R.id.resultCalc);
        btnCalc = (Button)findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(this);

        ((Button)findViewById(R.id.btnMain)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnMain:
                //finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnCalc:
                //액티비시명, 메시지,
                Toast tMsg = Toast.makeText(KaupActivity.this, "토스트 연습",Toast.LENGTH_LONG);
                tMsg.show();
                name = etName.getText().toString();
                height = Double.parseDouble(etHeight.getText().toString());
                weight = Double.parseDouble(etWeight.getText().toString());
                /*
                height = Integer.parseInt(etHeight.getText().toString());
                weight = Integer.parseInt(etWeight.getText().toString());
                */

                //getKaup
                KaupService service = new KaupServiceImpl();
                resultText = service.getKaup(weight, height);

                Log.d(resultText, "카우프 지수");
                resultCalc.setText(name+"님의 계산결과: " + resultText);

                break;

        }



    }
}
