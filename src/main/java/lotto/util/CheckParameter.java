package lotto.util;

public class CheckParameter {
    public static boolean checkIsNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException error){
            return false;
        }
    }
}
