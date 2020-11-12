package com.toyCompany.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int len = 8 * ((int) Math.pow(10, 7));
        Random rand = new Random(47);
        int[] arr = rand.ints(len, 0, len * 10).toArray();
        //System.out.println("排序前：" + Arrays.toString(arr));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss");
        String date1str = simpleDateFormat.format(new Date());
        System.out.println("排序前时间：" + date1str);
        MergeSort.sort(arr);
        String date2str = simpleDateFormat.format(new Date());
        System.out.println("排序后时间：" + date2str);
    }

    public static void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort1(arr, 0, arr.length - 1, tmp);
    }
    private static void sort1(int[] arr, int low, int high, int[] tmp) {
        if(low < high) {
            int midPos = (high + low) / 2;
            sort1(arr, low, midPos, tmp);
            sort1(arr, midPos + 1, high, tmp);
            //归并, 用tmp做中转数组
            merge(arr, low, midPos, high, tmp);
        }
    }
    //归并,用tmp做中转数组
    private static void merge(int[] arr, int low, int midPos, int high, int[] tmp) {
        int i = low, j = midPos + 1, k = 0;
        while(i <= midPos && j <= high) {
            if (arr[i] > arr[j]) {
                tmp[k] = arr[j];
                j ++;
                k ++;
            } else {
                tmp[k] = arr[i];
                i ++;
                k ++;
            }
        }
        while (i <= midPos) {
            tmp[k] = arr[i];
            i ++;
            k ++;
        }
        while (j <= high) {
            tmp[k] = arr[j];
            j ++;
            k ++;
        }
        for (int t = 0; low < high; t ++, low ++)
            arr[low] = tmp[t];
    }
}
