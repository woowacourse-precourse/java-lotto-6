package lotto.util;

public class MakeStringToInteger {
    public static Integer stringToInteger(String str){
        try{
            return Integer.parseInt(str);

        } catch(NumberFormatException error){
            throw new IllegalArgumentException();
        }
    }
}
