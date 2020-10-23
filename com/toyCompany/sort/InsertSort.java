package com.toyCompany.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {
        int len = 80000;
        Random rand = new Random(47);
        int[] arr = rand.ints(len, 0, len * 10).toArray();
        //System.out.println("排序前：" + Arrays.toString(arr));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss");
        String date1str = simpleDateFormat.format(new Date());
        System.out.println("排序前时间：" + date1str);
        InsertSort.sort1(arr);
        String date2str = simpleDateFormat.format(new Date());
        System.out.println("排序后时间：" + date2str);
    }
    /*public static void main(String[] args) {
        int len = 10;
        Random rand = new Random(47);
        int[] arr = rand.ints(len, 0, len * 10).toArray();
        System.out.println("排序前：" + Arrays.toString(arr));
        InsertSort.sort1(arr);
        System.out.println("排序后： " + Arrays.toString(arr));
    }*/

    //交换法，每发现一个arr[j - 1] > arr[j]，就将两个数交换;
    public static  void sort(int[] arr) {
        int len = arr.length;
        int temp;
        for (int i = 0; i < len; i ++) {
            for (int j = i; j > 0; j --) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;

                } else
                    break;
            }
        }
    }

    //移位法，由于前面的数组已经有序，每发现一个arr[j] > temp(待插入数据)，arr[j] = arr[j - 1],继续寻找，直到找到位置
    public static  void sort1(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i ++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0; j --) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                } else
                    break;
            }
            //循环退出时,为temp找到了位置
            arr[j] = temp;

        }
    }
}
