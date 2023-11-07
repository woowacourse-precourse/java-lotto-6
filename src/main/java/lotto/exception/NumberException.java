package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.view.ErrorMessage.*;

public class NumberException {
    private static final int start = 1;
    private static final int end = 45;

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

    public static void checkDuplicateException(List<Integer> numbers, int bonus) throws IllegalArgumentException{
        if(!checkDuplicate(numbers, bonus)) {
            duplicatedBonusNumber();
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkRange(int num)  {
        if ((num < start) || (num > end)) {
            return false;
        }
        return true;
    }

    public static boolean checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            return false;
        }
        return true;
    }

    public static boolean checkDuplicate(List<Integer> numbers, int bonus) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.contains(bonus)) {
            return false;
        }
        return true;
    }


}
