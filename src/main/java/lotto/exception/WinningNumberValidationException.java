package lotto.exception;

import java.util.List;

import lotto.constant.ExceptionConstant;

public class WinningNumberValidationException extends IllegalArgumentException {

    public WinningNumberValidationException(String message) {
        super(message);
    }

    public static void checkLottoNumberFormat(String input) {
        if (!input.matches(ExceptionConstant.NUMBER_FORMAT_PATTERN)) {
            throw new WinningNumberValidationException(ExceptionConstant.FORMAT_ERROR_MESSAGE);
        }
    }

    public static void checkWinningNumberLength(List<Integer> winningNumber) {
        if (winningNumber.size() != ExceptionConstant.LOTTO_NUMBER_COUNT) {
            throw new WinningNumberValidationException(ExceptionConstant.LENGTH_ERROR_MESSAGE);
        }
    }

    public static void checkDuplicateWinningNumbers(List<Integer> winningNumber) {
        if (winningNumber.stream().distinct().count() != ExceptionConstant.LOTTO_NUMBER_COUNT) {
            throw new WinningNumberValidationException(ExceptionConstant.DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void checkBoundaryOfWinningNumbers(List<Integer> winningNumber) {
        if (winningNumber.stream().anyMatch(number -> number < ExceptionConstant.MIN_LOTTO_NUMBER || number > ExceptionConstant.MAX_LOTTO_NUMBER)) {
            throw new WinningNumberValidationException(ExceptionConstant.BOUNDARY_ERROR_MESSAGE);
        }
    }
}
