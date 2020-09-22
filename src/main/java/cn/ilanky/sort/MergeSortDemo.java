package cn.ilanky.sort;

import java.util.Arrays;

/**
 * @author ilanky
 * @date 2020年 09月19日 14:28:03
 * 归并排序
 */
public class MergeSortDemo {

    private static Comparable[] assist;

    public static void main(String[] args) {
        Comparable[] arr = {5,9,1,10,3,6,11,2,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] a){
        assist = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a,int low,int high){
        //递归的临界条件
        if (low>=high){
            return;
        }
        int mid = low+(high-low)/2;

        sort(a,low,mid);
        sort(a,mid+1,high);

        merge(a,low,mid,high);
    }

    public static void merge(Comparable[] a,int low,int mid,int high){
        //辅助数组的指针p
        int p = low;
        //左数组的指针p1;
        int p1 = low;
        //右数组的指针p2;
        int p2 = mid+1;

        while (p1<=mid && p2<=high){

            //左比右小,则assist放入左的值并右移一位
            if (a[p1].compareTo(a[p2])<=0){
                assist[p++] = a[p1++];
            }else {
                assist[p++] = a[p2++];
            }
        }

        //判断是否走完了全程
        while (p1<=mid){
            assist[p++] = a[p1++];
        }

        while (p2<=high){
            assist[p++] = a[p2++];
        }

        //赋值原数组
        for (int i = low;i<=high;i++){
            a[i] = assist[i];
        }
    }
}
