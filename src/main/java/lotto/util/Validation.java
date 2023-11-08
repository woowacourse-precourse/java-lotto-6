package lotto.util;

import static lotto.exception.LottoErrorMsg.NEGATIVE_INT;
import static lotto.exception.LottoErrorMsg.UNABLE_TO_DIVIDE;
import static lotto.exception.LottoErrorMsg.UNABLE_TO_PARSE_INT;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoException;

public class Validation {
    public static List<Integer> validateList(String input){
        List<Integer> numbers = new ArrayList<>();
        try {
            String[] numberStrings = input.split(",");
            for (String string:numberStrings){
                numbers.add(validateInt(string));
            }
        } catch (IllegalArgumentException e){
            throw LottoException.triggeredBy(UNABLE_TO_PARSE_INT);
        }
        return numbers;
    }
    public static int validateInt(String input){
        int inputToInteger;
        try {
            inputToInteger = Integer.parseInt(input);
            validatePositiveInteger(inputToInteger);
        }catch (IllegalArgumentException e){
            throw LottoException.triggeredBy(UNABLE_TO_PARSE_INT);
        }
        return inputToInteger;
    }
    public static int validateDivide(int dividend,int divisor){
        if (dividend % divisor !=0){
            throw LottoException.triggeredBy(UNABLE_TO_DIVIDE);
        }
        return dividend / divisor;
    }

    public static void validatePositiveInteger(int input){
        if(input <= 0){
            throw LottoException.triggeredBy(NEGATIVE_INT);
        }
    }

}
