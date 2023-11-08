package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    자료형의 변환을 담당하며 변환 중 생기는 error를 체크한다.
 */
public class Convert {
    public static Integer convertStringToInteger(String str, String errorMsg){
        try{
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e){
            System.out.println(errorMsg + str);
            throw new IllegalArgumentException(errorMsg + str);
        }
    }

    public static List<Integer> convertStringListToIntegerList(List<String> strList, String errorMsg){
        List<Integer> ret = new ArrayList<>();
        for(String str: strList){
            ret.add(convertStringToInteger(str, errorMsg));
        }
        return ret;
    }
}
