package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.controller.InputConverter.convertBonusNumber;
import static lotto.controller.InputConverter.convertWinningNumber;

public class exceptionController {
    private static final int start = 1;
    private static final int end = 45;

    private static final int size = 6;

    public static List<Integer> checkExceptionWinningNumber(String tmpWinningNumbers) throws IllegalArgumentException {
        List<Integer> winningNumbers = convertWinningNumber(tmpWinningNumbers);
        checkWinningNumbersLength(winningNumbers);
        rotateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public static int checkExceptionBonus(List<Integer> numbers, String tmpBonusNumber) {
        int bonus = convertBonusNumber(tmpBonusNumber);
        checkRange(bonus);
        checkDuplicate(numbers, bonus);
        return bonus;
    }

    public static void checkWinningNumbersLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != size) {
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
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicate(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }
}
