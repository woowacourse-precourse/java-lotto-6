package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.exception.NumberCheck.*;
import static lotto.view.ErrorMessage.*;

public class NumberException {

    public static void numberRangeException(int num) throws IllegalArgumentException {
        if (!checkRange(num)) {
            outOfBoundExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void  duplicateException(List<Integer> numbers) throws IllegalArgumentException{
        if(!checkDuplicate(numbers)) {
            duplicatedWinningNumbers();
            throw new IllegalArgumentException();
        }
    }

    public static void duplicateException(List<Integer> numbers, int bonus) throws IllegalArgumentException{
        if(!checkDuplicate(numbers, bonus)) {
            duplicatedBonusNumber();
            throw new IllegalArgumentException();
        }
    }

}
