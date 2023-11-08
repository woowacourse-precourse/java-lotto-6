package Util;

public class Convert {
    public Integer convertStringToInteger(String str, String errorMsg){
        try{
            return Integer.parseInt(str);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
