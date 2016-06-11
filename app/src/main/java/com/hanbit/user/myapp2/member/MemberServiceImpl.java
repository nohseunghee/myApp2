package com.hanbit.user.myapp2.member;

import android.app.Activity;
import android.content.Context;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberServiceImpl extends Activity implements MemberService {
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }



    @Override
    public String signup(MemberBean member) {//데이터 저장
        return dao.signup(member);
    }

    @Override
    public MemberBean login(MemberBean member) {
        return dao.login(member);
    }

    @Override
    public MemberBean update(MemberBean member) {
        return dao.update(member);
    }

    @Override
    public String delete(MemberBean member) {
        return dao.delete(member);
    }
}
