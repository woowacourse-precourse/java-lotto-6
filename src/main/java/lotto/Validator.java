package lotto;


import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;
import static lotto.ErrorMessage.*;

public class Validator {

    public static void validateNotEmptyInput(String input){
        if(input.isBlank()) throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
    }

    public static int validateInputIsNumeric(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException(NOT_VALID_MONEY);
        }
    }

    public static void validatePositiveNumber(int amount){
        if(amount <= 0) throw new IllegalArgumentException(NOT_VALID_MONEY);
    }


    public static void validateNumberInRange(int number){
        if(number < minimumLottoNumber || number > maximumLottoNumber){
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
        }
    }

    public static void validateNumberCount(Integer... numbers){
        if(numbers.length != LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException(NOT_VALID_LENGTH);
        }
    }

}
