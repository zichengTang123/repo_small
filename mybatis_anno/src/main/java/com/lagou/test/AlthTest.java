package com.lagou.test;

public class AlthTest{
    /**
     * 打印多次
     * @param i
     */
    public static void helloWorld(int i){
        if(i == 0) return;
        System.out.println("hello world");
        helloWorld(i -1);
    }

    /**
     * 递归实现斐波拉契数列
     *
     */

    public static int feibo1(int n){
        if(n <= 1) {
            return n;
        }
        int sum = feibo1(n-1) + feibo1(n-2);
        return sum;
    }

    public static int single(int[] nums){

        int num = 0;
        while (num == 0){
            if(nums[0] == nums[1]){

            }
        }

    }

    public static void main(String[] args) {

        System.out.println(feibo1(5));
    }
}


