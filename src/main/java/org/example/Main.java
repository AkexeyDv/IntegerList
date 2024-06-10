package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ServiceInteger serviceInteger = new ServiceInteger();
        serviceInteger.add(25);
        serviceInteger.add(-8);
        serviceInteger.add(94);
        serviceInteger.add(1);
        serviceInteger.add(29);
        System.out.println(Arrays.toString(serviceInteger.sort()));



    }
}