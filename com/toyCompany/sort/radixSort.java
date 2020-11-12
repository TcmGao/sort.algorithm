package com.toyCompany.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class radixSort {
    public static void main(String[] args) {
        int len = 80000000;
        Random rand = new Random(47);
        int[] arr = rand.ints(len, 0, len * 10).toArray();
        //System.out.println("排序前：" + Arrays.toString(arr));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss");
        String date1str = simpleDateFormat.format(new Date());
        System.out.println("排序前时间：" + date1str);
        radixSort.sort(arr);
        String date2str = simpleDateFormat.format(new Date());
        System.out.println("排序后时间：" + date2str);
        //System.out.println("排序后： " + Arrays.toString(arr));
    }
    /*public static void main(String[] args) {
        int len = 12;
        Random rand = new Random(47);
        int[] arr = rand.ints(len, 0, len * 10).toArray();
        System.out.println("排序前：" + Arrays.toString(arr));
        radixSort.sort(arr);
        System.out.println("排序后： " + Arrays.toString(arr));
    }*/
    public static void sort(int[] arr) {
        /**基数排序，关键字K是整数，将其拆分，个，十，百，千位作为关键字，这样基数radix=10
         * 以空间作为代价，建立二维数组作为桶集合，第一维长度就是radix，第二维长度是arr.length，
         * 即桶个数位radix，桶容量为arr.length,
         * 同时用数组bucketElementCount记录每个桶的数据个数
         * 基数排序辅助空间大，以空间换取时间，适合基数比较小的问题
         */
        int radix = 10;
        //第nIdx趟
        int nIdx = 0;
        int[][] bucket = new int[radix][arr.length];
        int[] bucketElementCount = new int[radix];
        while (bucketElementCount[0] < arr.length) {
            //每一轮开始前都需要清空桶
            for(int i = 0; i < radix; i ++) {
                bucketElementCount[i] = 0;
            }
            allocateAndCollect(arr, bucket, bucketElementCount, radix, nIdx);
            nIdx ++;
        }

    }
    //分配并收集
    public static void allocateAndCollect(int[] arr, int[][] bucket, int[] bucketElementCount, int radix, int nIdx) {
        //selection决定元素该入哪个桶
        int len = arr.length;
        int selection = 0;
        //分配
        for(int i = 0; i < len; i ++) {
            selection = select(arr[i], radix, nIdx);
            bucket[selection][bucketElementCount[selection]] = arr[i];
            bucketElementCount[selection] ++;
        }
        //收集
        for(int i = 0, j = 0; i < radix; i ++) {
            //收集第i个桶的元素
            int k = 0;
            while(k < bucketElementCount[i]) {
                arr[j] = bucket[i][k];
                j ++;
                k ++;
            }
        }
        //System.out.println(Arrays.toString(arr));
    }
    //计算元素的第i个关键字
    public static int select(int num, int radix, int nIdx) {
        for(int i = 0; i < nIdx; i ++)
            num /= radix;
        return num % radix;
    }
}
