package lotto;


import static lotto.Constant.unitOfMoney;
import static lotto.Message.EMPTY_INPUT_ERROR;
import static lotto.Message.NOT_VALID_NUMBER;

public class Validator {

    public static void validateNotEmptyInput(String input){
        if(input.isBlank()) throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
    }

    public static int validateInputIsNumeric(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException(NOT_VALID_NUMBER);
        }
    }

    public static void validatePositiveNumber(int amount){
        if(amount <= 0) throw new IllegalArgumentException(NOT_VALID_NUMBER);
    }

    public static void validateNotHasRemainder(int amount){
        if(amount % unitOfMoney != 0) throw new IllegalArgumentException(NOT_VALID_NUMBER);
    }


}
