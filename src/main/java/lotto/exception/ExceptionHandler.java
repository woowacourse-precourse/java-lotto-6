package lotto.exception;

import lotto.validation.InputFormatValidator;
import lotto.view.Printer;

public class ExceptionHandler {
    public static ExceptionStatus handleMoneyFormatException(String purchaseAmount) {
        try {
            InputFormatValidator.validateMoneyFormat(purchaseAmount);
        } catch (IllegalArgumentException e) {
            Printer.printMoneyFormatExceptionMessage();
            return ExceptionStatus.OCCURRED;
        }

        return ExceptionStatus.NOT_OCCURRED;
    }
}
