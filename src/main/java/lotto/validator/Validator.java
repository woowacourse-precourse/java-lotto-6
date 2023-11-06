package lotto.validator;

public class Validator {
    public static boolean isInteger(String inputMessage) throws IllegalArgumentException{
        Integer.parseInt(inputMessage);
        return true;
    }
    public static boolean validateNumberRange(int value, int min, int max){
        if(value<min || value>max){
            return false;
        }
        return true;
    }
}
