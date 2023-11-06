package lotto.utils;

public class NumberUtil {
    public static String removeSpace(String number){
        return number.replaceAll(" ","");
    }
    
    public static String[] splitComma(String number){
        return number.split(",");
    }
}
