package cn.ilanky.sort;

/**
 * @author ilanky
 * @date 2020年 09月19日 14:04:09
 * 希尔排序
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        int tmp;
        int[] arr = {5,9,1,10,3,6,11,2,5};

        //找到h的初始值
        int h = 1;
        while (h<arr.length/2){
            h = h*2+1;
        }

        while (h>=1){

            //根据分组规则 每隔h的元素为一组 假设h = 3 那么就是0 3 6 9 为一组 而0默认是有序的
            //因此其实总结出规律 第一个需要排序的元素是下标为h的元素
            //其他组则通过h累加即可
            for (int i = h;i<arr.length;i++){

                //j是待排序的元素 其临界值应该是h 因为当j = h时，j-h不至于是负数
                for (int j = i;j>=h;j-=h){
                    if (arr[j-h]>arr[j]){
                        tmp = arr[j-h];
                        arr[j-h] = arr[j];
                        arr[j] = tmp;
                    }else {
                        break;
                    }
                }
            }
            h = h/2;
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
