package org.example;

public class Main {
    public static void main(String[] args) {
        ServiceInteger serviceInteger = new ServiceInteger();
        System.out.println(serviceInteger.add(8));
        System.out.println(serviceInteger.add(25));
        System.out.println(serviceInteger.add(1, 44));
        System.out.println(serviceInteger.add(2, -8));
        System.out.println(serviceInteger.add(0, 12));

        System.out.println(serviceInteger.set(2, 10));
        System.out.println(serviceInteger.toString());
        System.out.println(serviceInteger.remove(0));

        System.out.println(serviceInteger.toString());
        System.out.println(serviceInteger.contains(25));
        System.out.println(serviceInteger.lastIndexOf(-8));
        System.out.println(serviceInteger.get(2));
        ServiceInteger newArray = new ServiceInteger();
        newArray.add(8);
        newArray.add(10);
        newArray.add(-8);
        newArray.add(25);
        System.out.println(serviceInteger.toString());
        System.out.println(newArray.toString());
        System.out.println(serviceInteger.equals(newArray));
        serviceInteger.clear();
        System.out.println(serviceInteger.toString());
        System.out.println(serviceInteger.isEmpty());

    }
}