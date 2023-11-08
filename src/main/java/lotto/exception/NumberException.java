package lotto.exception;

import lotto.view.ErrorMessage;

import java.util.List;
import static lotto.exception.NumberCheck.*;

public class NumberException {
    protected static String errorMessage;
    public static void numberRangeException(int num) throws IllegalArgumentException {
        if (!checkRange(num)) {
            errorMessage = ErrorMessage.outOfBound.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void  duplicateException(List<Integer> numbers) throws IllegalArgumentException{
        if(!checkDuplicate(numbers)) {
            errorMessage = ErrorMessage.duplicateWinning.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void duplicateException(List<Integer> numbers, int bonus) throws IllegalArgumentException{
        if(!checkDuplicate(numbers, bonus)) {
            errorMessage = ErrorMessage.duplicateBonus.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
