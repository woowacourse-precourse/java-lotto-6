package lotto.validator;

import lotto.exception.ErrorMessage;
public class Validator {
    public static boolean isInteger(String inputMessage) {
        try{
            Integer.parseInt(inputMessage);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
        }
        return true;
    }
    public static boolean validateNumberRange(int value, int min, int max){
        if(value<min || value>max){
            return false;
        }
        return true;
    }
}
