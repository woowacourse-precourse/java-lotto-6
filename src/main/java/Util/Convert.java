package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
