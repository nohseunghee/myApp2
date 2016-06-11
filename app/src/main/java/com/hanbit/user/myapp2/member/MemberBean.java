package com.hanbit.user.myapp2.member;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberBean {
    private String id, pw, name, email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[회원정보]" +
                "ID='" + id + '\'' +
                ", 비미리번호='" + pw + '\'' +
                ", 이름='" + name + '\'' +
                ", 이메일='" + email + '\'' ;
    }
}
