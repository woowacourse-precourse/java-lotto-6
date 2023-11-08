package Util;

public class CheckNull {
    public static void check(Object o, String errorMsg){
        if(o == null) {
            System.out.println(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
