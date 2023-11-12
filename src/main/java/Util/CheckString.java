package Util;
/*
    스트링에 관한 체크를 담는 객체
 */
public class CheckString {
    //빈 문자열 체크
    public static void checkEmptyString(String str, String errorMsg){
        if(str.isEmpty()) {
            System.out.println(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }

}
