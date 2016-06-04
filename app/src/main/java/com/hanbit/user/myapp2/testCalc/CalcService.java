package com.hanbit.user.myapp2.testCalc;

/**
 * Created by USER on 2016-06-04.
 * type을 interface로 지정
 */
public interface CalcService {
    public int plus(int num1, int num2);
    public int minus(int num1, int num2);
    public int multi(int num1, int num2);
    public int divide(int num1, int num2);
    public int nmg(int num1, int num2); //나머지
}
