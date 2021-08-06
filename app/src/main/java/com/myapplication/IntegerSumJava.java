package com.myapplication;

import java.util.List;

/**
 * Created by Shivarpit
 */


abstract class BaseNumberJava<T> {
    abstract T add(T a, T b);

    final void printSum(T a, T b) {
        System.out.println(add(a, b).toString());
    }
}

class IntegerSumJava extends BaseNumberJava<Integer> {

    @Override
    Integer add(Integer a, Integer b) {
        return a + b;
    }

}

class FloatSumJava extends BaseNumberJava<Float> {

    @Override
    Float add(Float a, Float b) {
        return a + b;
    }
}

class StringSumJava extends BaseNumberJava<String> {

    @Override
    String add(String a, String b) {
        return a + b;
    }
}
