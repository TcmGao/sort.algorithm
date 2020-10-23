package com.toyCompany.sort;

import java.text.SimpleDateFormat;
import java.util.*;
public class BubbleSort {
    public static void main(String[] args) {
        int len = 80000;
        int[] arr = new int[len];
        Random rand = new Random(47);
        for (int i = 0; i < len; i ++) {
            arr[i] = rand.nextInt(len * 10);
        }
        //System.out.println("原始数组：" + Arrays.toString(arr));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss");
        String date1str = simpleDateFormat.format(new Date());
        System.out.println("排序前时间：" + date1str);
        BubbleSort.sort(arr);
        String date2str = simpleDateFormat.format(new Date());
        System.out.println("排序后时间：" + date2str);
        //System.out.println("排序后：" + Arrays.toString(arr));

    }

    //冒泡排序函数
    public static void sort(int[] arr) {
        //用flags作为标志，若某一趟排序中没有发生交换，则flags为0，排序完成，可节省时间；
        boolean flags = false;
        int len = arr.length;
        int temp = 0;

        for (int i = 0; i < len - 1; i ++) {
            flags = false;
            for (int j = 0; j < len - 1 - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flags = true;
                }
            }
            //System.out.println(i + ":" + Arrays.toString(arr));
            //若某一趟排序中没有发生交换，则flags为0,退出循环;
            if (flags == false)
                break;
        }
    }
}
