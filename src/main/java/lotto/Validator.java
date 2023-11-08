package lotto;


import java.util.List;

import static lotto.Constant.*;
import static lotto.view.ErrorMessage.*;

public class Validator {

    public static void validateNotEmptyInput(String input){
        if(input.isBlank()) throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
    }

    public static int validateInputIsNumeric(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException(NOT_PARSE_INTEGER);
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

    public static void validateNumberLength(List<Integer> numbers){
        if(numbers.size() != 6) throw new IllegalArgumentException(NOT_VALID_LENGTH);
    }

    public static void validateComposedOfUniqueNumbers(List<Integer> numbers){
        long unique_number = numbers.stream().distinct().count();
        if(unique_number < numbers.size()){
            throw new IllegalArgumentException(NOT_COMPOSED_OF_UNIQUE_NUMBERS);
        }
    }

}
