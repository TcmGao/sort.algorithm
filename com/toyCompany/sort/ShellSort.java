package com.toyCompany.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
        int len = 8000000;
        Random rand = new Random(47);
        int[] arr = rand.ints(len, 0, len * 10).toArray();
        //System.out.println("排序前：" + Arrays.toString(arr));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss");
        String date1str = simpleDateFormat.format(new Date());
        System.out.println("排序前时间：" + date1str);
        ShellSort.sort(arr);
        String date2str = simpleDateFormat.format(new Date());
        System.out.println("排序后时间：" + date2str);
        //System.out.println("排序后： " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            for (int j = 0; j < gap; j ++) {
                InsertSort(arr, j, gap, len);
                /*int start = j;
                for (int i = start; i  < len; i += gap) {
                    int temp = arr[i];
                    int k;
                    for (k = i; k > start; k -= gap) {
                        if (arr[k - gap] > temp) {
                            arr[k] = arr[k - gap];
                        } else
                            break;
                    }
                    arr[k] = temp;
                }*/
            }
        }
    }
    private  static void InsertSort(int[] arr, int start, int gap, int len) {

        for (int i = start; i  < len; i += gap) {
            int temp = arr[i];
            int j;
            for (j = i; j > start; j -= gap) {
                if (arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                } else
                    break;
            }
            arr[j] = temp;
        }
    }

    /*public static void sort1(int[] data) {
        // 按数组下标增量分组
        for (int gap = data.length / 2; gap > 0; gap /= 2) {
            // 从增量的索引位置开始进行插入排序
            for (int i = gap; i < data.length; i++) {
                int curr = data[i];
                int j = i - gap;
                // 将i处的元素插入到正确的位置
                while (j >= 0 && data[j] > curr) {
                    data[j + gap] = data[j];
                    j -= gap;
                }
                data[j + gap] = curr;
            }
        }

    }*/

}
