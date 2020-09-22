package cn.ilanky.sort;

/**
 * @author ilanky
 * @date 2020年 09月19日 13:41:54
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int tmp;
        int[] arr = {5,9,1,10,3,6,11,2,5};

        for (int i = 1;i<arr.length;i++){

            //最基础的插入排序法就是 第i个元素要进行插入 那么就与其前一个进行比较
            //如果前一个已经比他小了 因为前面的都是已经排序好了的。因此就不用动
            //如果前一个比他大 则与其交换 以此类推
            for (int j = i;j>0;j--){
                if (arr[j-1]>arr[j]){
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }else {
                    break;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
