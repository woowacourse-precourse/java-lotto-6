package lotto.exception;

import lotto.model.Number;
import lotto.model.WinningNumber;

import java.util.List;

import static lotto.view.ErrorMessage.duplicatedWinningNumbers;
import static lotto.view.ErrorMessage.notEnoughLengthOfWinningNumbersExceptionMessage;

public class WinningCommonException extends CommonException {
    public static WinningNumber checkWinningNumberException(List<Integer> winningNumbers) throws IllegalArgumentException {
        try {
            checkWinningNumberRangeRotate(winningNumbers);
            checkWinningNumberLengthException(winningNumbers);
            checkWinningNumbersDuplicate(winningNumbers);
            return new WinningNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkWinningNumberLengthException(List<Integer> winningNumbers) throws IllegalArgumentException {
        try {
            WinningNumber.checkNumberLength(winningNumbers);
        } catch (IllegalArgumentException e) {
            notEnoughLengthOfWinningNumbersExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    private static void checkWinningNumbersDuplicate(List<Integer> winningNumbers) throws IllegalArgumentException{
        try {
            WinningNumber.checkDuplicate(winningNumbers);
        } catch (IllegalArgumentException e) {
            duplicatedWinningNumbers();
            throw new IllegalArgumentException();
        }
    }

    private static void checkWinningNumberRangeRotate(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            checkNumberException(number);
        }
    }
}
