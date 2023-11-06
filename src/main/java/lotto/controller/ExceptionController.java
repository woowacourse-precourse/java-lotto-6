package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.controller.InputConverter.*;
import static lotto.view.ErrorMessage.*;

public class ExceptionController {
    private static final int start = 1;
    private static final int end = 45;

    private static final int size = 6;
    private static final int minPrice = 1000;

    public static int checkExceptionPrice(String inputPrice) {
        int price = checkDigit(inputPrice);
        return price;
    }
    public static List<Integer> checkExceptionWinningNumber(String tmpWinningNumbers) throws IllegalArgumentException {
        List<Integer> winningNumbers = convertWinningNumber(tmpWinningNumbers);
        checkWinningNumbersLength(winningNumbers);
        rotateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    /*
    public static int checkExceptionBonus(List<Integer> numbers, String tmpBonusNumber) {
        int bonus = convertBonusNumber(tmpBonusNumber);
        checkRange(bonus);
        checkDuplicate(numbers, bonus);
        return bonus;
    }*/

    public static void checkWinningNumbersLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != size) {
            notEnoughLengthOfWinningNumbersExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void rotateWinningNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        for (int number : winningNumbers) {
            checkRange(number);
        }
    }

    public static void checkRange(int num) throws IllegalArgumentException{
        if ((num < start) || (num > end)) {
            outOfBoundExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicate(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.contains(bonus)) {
            duplicatedBonusNumber();
            throw new IllegalArgumentException();
        }
    }
}
