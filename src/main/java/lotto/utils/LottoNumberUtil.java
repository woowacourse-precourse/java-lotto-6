package lotto.utils;

public class LottoNumberUtil {
    public static String removeSpace(String number){
        return number.replaceAll(" ","");
    }
    public static String[] splitComma(String number){
        return number.split(",");
    }
}
