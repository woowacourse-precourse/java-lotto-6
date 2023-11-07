package lotto.exception;

import lotto.utility.TypeConverter;
import lotto.validation.InputFormatValidator;
import lotto.view.Printer;

public class ExceptionHandler {
    public static ExceptionStatus handleMoneyException(String purchaseAmount) {
        ExceptionStatus exceptionStatus = handleMoneyFormatException(purchaseAmount);
        if (exceptionStatus.isOccurred()) {
            return exceptionStatus;
        }

        exceptionStatus = handleMoneyNotMultipleException(TypeConverter.convertStringToInt(purchaseAmount));

        return exceptionStatus;
    }

    public static ExceptionStatus handleMoneyFormatException(String purchaseAmount) {
        try {
            InputFormatValidator.validateMoneyFormat(purchaseAmount);
        } catch (IllegalArgumentException e) {
            Printer.printMoneyFormatExceptionMessage();
            return ExceptionStatus.OCCURRED;
        }

        return ExceptionStatus.NOT_OCCURRED;
    }

    public static ExceptionStatus handleMoneyNotMultipleException(final int purchaseAmount) {
        try {
            InputFormatValidator.validateMoneyIsMultipleOfLottoPrice(purchaseAmount);
        } catch (IllegalArgumentException e) {
            Printer.printMoneyNotMultipleExceptionMessage();
            return ExceptionStatus.OCCURRED;
        }

        return ExceptionStatus.NOT_OCCURRED;
    }
}
