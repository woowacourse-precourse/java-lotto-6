package Util;

public class CheckInteger {
    public static void checkNumMultipleOfDivider(Integer num, Integer divider, String errorMsg){
        if(num % divider != 0)
            throw new IllegalArgumentException(errorMsg);
    }

    public static void NotZero(Integer num, String errorMsg){
        if(num.equals(0))
            throw  new IllegalArgumentException(errorMsg);
    }
}
