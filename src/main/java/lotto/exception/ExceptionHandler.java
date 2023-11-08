package lotto.exception;

import lotto.validation.InputFormatValidator;
import lotto.view.Printer;

public class ExceptionHandler {
    public static ExceptionStatus handleMoneyInputException(String purchaseAmount) {
        try {
            InputFormatValidator.validateMoneyFormat(purchaseAmount);
            InputFormatValidator.validateMoneyIsMultipleOfLottoPrice(purchaseAmount);
        } catch (IllegalArgumentException e) {
            Printer.printExceptionMessage(e.getMessage());
            return ExceptionStatus.OCCURRED;
        }

        return ExceptionStatus.NOT_OCCURRED;
    }

    public static ExceptionStatus handleWinningNumberInputException(String winningNumbers) {
        try {
            InputFormatValidator.validateWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            Printer.printExceptionMessage(e.getMessage());
            return ExceptionStatus.OCCURRED;
        }

        return ExceptionStatus.NOT_OCCURRED;
    }
}
