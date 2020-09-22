package cn.ilanky.sort;

import java.util.Arrays;

/**
 * @author ilanky
 * @date 2020年 09月19日 15:01:37
 * 快速排序
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        Comparable[] arr = {5,9,1,10,3,6,11,2,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a,int low,int high){

        if (high<=low){
            return;
        }

        int part = part(a, low, high);

        sort(a,low,part-1);
        sort(a,part+1,high);
    }

    public static int part(Comparable[]a,int low,int high){
        //参照点
        Comparable key = a[low];


        //右移动指针
        int left = low;

        //左移动指针
        int right = high+1;

        while (true){

            //找到比key小的
            while (a[--right].compareTo(key)>0){
                if (right==low){
                    break;
                }
            }

            //找到比key大的
            while (a[++left].compareTo(key)<=0){
                if (left==high){
                    break;
                }
            }


            if (left>=right){
                break;
            }else {
                swap(a,left,right);
            }

        }

        swap(a,low,right);

        return right;

    }

    public static void swap(Comparable[] a,int a1,int a2){
        Comparable tmp;
        tmp = a[a1];
        a[a1] = a[a2];
        a[a2] = tmp;
    }
}
