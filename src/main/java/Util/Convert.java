package Util;

public class Convert {
    public static Integer convertStringToInteger(String str, String errorMsg){
        try{
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
