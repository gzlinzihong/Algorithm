package cn.ilanky.sort;

/**
 * @author ilanky
 * @date 2020年 09月19日 13:13:51
 * 冒泡排序
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int tmp;
        int[] arr = {5,9,1,10,3,6,11,2,5};
        for (int i = 0;i<arr.length-1;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
