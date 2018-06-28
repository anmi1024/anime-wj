package xin.wangjue.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SortTest {
    public static void main(String[] args) {
        int[] s = new int[]{6,8,4,2,5,1,3,9,7,'a','A',4,5,6};
        System.out.print("排序前：");
        for (int i : s) {
            System.out.print(i +" ");
        }
        System.out.println();
        //bubbleSort(s);
        //selectSort(s,s.length);
        insertSort(s,s.length);
        System.out.println("排序后：");
        for (int i : s) {
            System.out.print(i +" ");
        }

        System.out.println();
        int a= 5,b=3;
        System.out.println(a+"---"+b);
        a = a^b;
        b = a^b;
        a = b^a;
        System.out.println(a+"---"+b);

    }


    public static void bubbleSort(int[] s) {
        int swap;
        boolean flag = false;
        for (int i = 0;i<s.length-1&&!flag;i++) {
            for (int j=0;j<s.length-i-1;j++) {
                if (s[j] > s[j+1]) {
                    swap = s[j];
                    s[j] = s[j+1];
                    s[j+1] = swap;
                    flag = false;
                }
            }
        }
    }

    public static void selectSort(int[] s,int length) {
        for (int i=0;i<length-1;i++) {
            int min = i;
            for (int j=i+1;j<length;j++) {
                if (s[j]<s[min]) min = j;
            }
            if (min != i) {
                int swap = s[i];
                s[i] = s[min];
                s[min] = swap;
            }
        }
    }

    public static void insertSort(int[] s,int length) {
        int swap;
        for (int i=0;i<length-1;i++) {
            for (int j=i+1;j>0;j--) {
                if (s[j] < s[j-1]) {
                    swap = s[j-1];
                    s[j-1] = s[j];
                    s[j] = swap;
                } else break;
            }
        }
    }

    public static void insertionSort(int[] s,int length) {
        int out ,in;
        for(out=1; out<length; ++out) {
            int temp = s[out];
            in = out;
            while(in>0 && temp<s[in-1]) {
                s[in] = s[in-1];
                --in;
            }
            s[in] = temp;
        }
    }

}
