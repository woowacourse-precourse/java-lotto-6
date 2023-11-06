package lotto.util.validate;

import lotto.util.error.CustomError;

public class CommonValidate {

    public static void checkIsNumber(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(CustomError.INPUT_IS_NOT_NUMBER.getError());
        }
    }

    public static void checkBlank(String input){
        if(input.contains(" "))
            throw new IllegalArgumentException(CustomError.INPUT_CONTAIN_BLANK.getError());
    }
}
