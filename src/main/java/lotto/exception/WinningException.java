package lotto.exception;

import lotto.model.WinningNumber;
import lotto.view.ErrorMessage;
import java.util.List;
import static lotto.exception.WinningCheck.checkCommaCount;
import static lotto.exception.WinningCheck.checkNumberLength;

public class WinningException extends NumberException {
    public static WinningNumber winningException(List<Integer> numbers, String inputWinning) throws IllegalArgumentException {
        winningNumberRotate(numbers);
        winningNumberLengthException(numbers);
        duplicateException(numbers);
        winningNumberCommaException(inputWinning);
        return new WinningNumber(numbers);
    }

    public static void winningNumberLengthException(List<Integer> numbers) throws IllegalArgumentException {
        if (!checkNumberLength(numbers)) {
            errorMessage = ErrorMessage.notEnoughLength.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void winningNumberCommaException(String inputWinning) throws IllegalArgumentException{
        if (!checkCommaCount(inputWinning)) {
            errorMessage = ErrorMessage.toManyComma.getErrorMessage();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void winningNumberRotate(List<Integer> winningNumbers) throws IllegalArgumentException{
        for (int number : winningNumbers) {
            numberRangeException(number);
        }
    }




}
