package lotto.view;

import static lotto.error.ExceptionCode.INVALID_NUMBER_FORMAT;

import lotto.error.ExceptionCode;
import lotto.error.LottoException;

public class ErrorOutput {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private static final String RUNTIME_EXCEPTION_MESSAGE = "알수 없는 예외가 발생했습니다.";

    public static void printError(final ExceptionCode exceptionCode) {
        System.out.print(ERROR_PREFIX);
        System.out.println(exceptionCode.getMessage());
    }

    public static void printError(final LottoException exception) {
        System.out.print(ERROR_PREFIX);
        System.out.println(exception.getMessage());
    }

    public static void printError(final NumberFormatException exception) {
        System.out.print(ERROR_PREFIX);
        System.out.println(INVALID_NUMBER_FORMAT.getMessage());
    }

    public static void printError(final RuntimeException exception) {
        System.out.print(ERROR_PREFIX);
        System.out.println(RUNTIME_EXCEPTION_MESSAGE);
    }
}
