package lotto.validator;

import lotto.game.ErrorMessage;
public class Validator {
    public static boolean isInteger(String inputMessage) {
        try{
            Integer.parseInt(inputMessage);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.REQUEST_INTEGER_MESSAGE.getMessage());
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
