package com.company;

public class Main {

    public static void main(String[] args) {
//        /**
//         * 数组的声明 1
//         */
//        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//        /**
//         * 数组声明 2
//         */
//        int[] scores = new int[]{100, 99, 66};
//        for (int i = 0; i < scores.length; i++) {
//            System.out.println(scores[i]);
//        }
//        //数组具有可遍历的特性
//        System.out.println("如何使用for-each呢");
//        for (int score : scores) {
//            System.out.println(score);
//        }
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
    }
}
