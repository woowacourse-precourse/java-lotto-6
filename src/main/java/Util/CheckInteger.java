package Util;

import java.util.List;

public class CheckInteger {
    public static void checkNumMultipleOfDivider(Integer num, Integer divider, String errorMsg){
        if(num % divider != 0) {
            System.out.println(errorMsg + num);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public static void notZero(Integer num, String errorMsg){
        if(num.equals(0)) {
            System.out.println(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public static void intOutOfRange(int num, int start, int end, String errorMsg){
        if(num < start || num > end){
            System.out.println(errorMsg + num);
            throw new IllegalArgumentException(errorMsg + num);
        }
    }
}
