package com.toyCompany.sort;

import java.util.*;
public class SelectSort {
    public static void main(String[] args) {
        int len = 10;
        Random rand = new Random(47);
        int[] arr = rand.ints(len, 0, len * 10).toArray();
        System.out.println("排序前：" + Arrays.toString(arr));
        SelectSort.sort(arr);
        System.out.println("排序后： " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i ++) {
            int temp = arr[i];
            for (int j = i + 1; j < len; j ++) {
                if (temp > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                    temp = arr[i];
                }
            }
        }
    }
}
