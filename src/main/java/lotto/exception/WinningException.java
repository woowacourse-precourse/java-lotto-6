package lotto.exception;

import lotto.model.WinningNumber;

import java.util.List;

import static lotto.view.ErrorMessage.duplicatedWinningNumbers;
import static lotto.view.ErrorMessage.notEnoughLengthOfWinningNumbersExceptionMessage;

public class WinningException extends NumberException {
    public static WinningNumber winningException(List<Integer> winningNumbers) throws IllegalArgumentException {
        try {
            winningNumRangeRotate(winningNumbers);
            winningNumLengthException(winningNumbers);
            duplicateException(winningNumbers);
            //winningNumDuplicate(winningNumbers);
            return new WinningNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void winningNumLengthException(List<Integer> winningNumbers) throws IllegalArgumentException {
        try {
            WinningNumber.checkNumberLength(winningNumbers);
        } catch (IllegalArgumentException e) {
            notEnoughLengthOfWinningNumbersExceptionMessage();
            throw new IllegalArgumentException();
        }
    }
/*
    private static void winningNumDuplicate(List<Integer> winningNumbers) throws IllegalArgumentException{
        try {
            WinningNumber.checkDuplicate(winningNumbers);
        } catch (IllegalArgumentException e) {
            duplicatedWinningNumbers();
            throw new IllegalArgumentException();
        }
    }*/

    private static void winningNumRangeRotate(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            numberRangeException(number);
        }
    }
}
