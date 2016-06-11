package com.hanbit.user.myapp2.signup;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.member.MemberBean;
import com.hanbit.user.myapp2.member.MemberDAO;
import com.hanbit.user.myapp2.member.MemberService;
import com.hanbit.user.myapp2.member.MemberServiceImpl;

public class SignupActivity extends Activity implements View.OnClickListener{
    EditText etID, etPW, etName, etEmail;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etID = (EditText)findViewById(R.id.etID);
        etPW = (EditText)findViewById(R.id.etPW);
        etName = (EditText)findViewById(R.id.etName);
        etEmail = (EditText)findViewById(R.id.etEmail);
        textResult = (TextView)findViewById(R.id.textResult);

        ((Button)findViewById(R.id.btnSignup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        MemberBean member = new MemberBean(); //인스턴스(객체) 생성
        member.setId(etID.getText().toString());   //데이터 잠금
        member.setPw(etPW.getText().toString());
        member.setName(etName.getText().toString());
        member.setEmail(etEmail.getText().toString());

        //MemberService service = new MemberServiceImpl(); //인스턴스(객체) 생성
        //String msg = service.signup(member);
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        String msg = dao.signup(member);

        textResult.setText("회원가입결과: "+msg);

    }
}
