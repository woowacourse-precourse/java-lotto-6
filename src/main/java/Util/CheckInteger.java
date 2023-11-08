package Util;

import java.util.List;
/*
    Integer에 대한 여러 체크를 담당하는 객체
 */
public class CheckInteger {
    //해당 num이 divider의 배수인지 확인
    public static void checkNumMultipleOfDivider(Integer num, Integer divider, String errorMsg){
        if(num % divider != 0) {
            System.out.println(errorMsg + num);
            throw new IllegalArgumentException(errorMsg);
        }
    }
    //해당 num이 0인지 아닌지 확인
    public static void notZero(Integer num, String errorMsg){
        if(num.equals(0)) {
            System.out.println(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }
    //해당 num이 범위를 벗어낫는지 아닌지 판단.
    public static void intOutOfRange(int num, int start, int end, String errorMsg){
        if(num < start || num > end){
            System.out.println(errorMsg + num);
            throw new IllegalArgumentException(errorMsg + num);
        }
    }
}
