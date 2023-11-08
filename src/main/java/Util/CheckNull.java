package Util;

public class CheckNull {
    public static void check(Object o, String errorMsg){
        if(o == null)
            throw new IllegalArgumentException(errorMsg);
    }
}
