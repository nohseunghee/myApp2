package com.hanbit.user.myapp2.kaup;

/**
 * Created by USER on 2016-06-04.
 */
public class KaupBean {
    private double weight, height;  //외부에서 바로 접속 불가
    private String result, name;

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getResult() {
        return result;
    }

    public String getName() {
        return name;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setName(String name) {
        this.name = name;
    }
}
