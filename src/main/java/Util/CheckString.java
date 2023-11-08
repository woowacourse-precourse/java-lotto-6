package Util;

public class CheckString {
    //빈 문자열 체크
    public static void checkEmptyString(String str, String errorMsg){
        if(str.isEmpty()) {
            System.out.println(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }

}
