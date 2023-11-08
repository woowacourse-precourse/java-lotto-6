package lotto.service;

import lotto.domain.ErrorMessage;
import lotto.domain.LottoConstants;

public class Validator {

    private static final String COMMA = ",";

    public static void validateIsNumber(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(COMMA);
        for (String splitNumber : splitNumbers) {
            checkAndThrowIfNotNumeric(splitNumber);
        }
    }

    public static void checkAndThrowIfNotNumeric(String splitNumber) {
        try {
            Integer.parseInt(splitNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getMessage());
        }
    }

    public static void validateNullOrBlank(String winningNumbers) {
        if (isNullOrBlank(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_OR_BLANK.getMessage());
        }
    }

    private static boolean isNullOrBlank(String winningNumbers) {
        return winningNumbers == null || winningNumbers.isBlank();
    }

    public static void validateFallingApart(int amount) {
        if (amount % LottoConstants.THOUSAND.getValue() != LottoConstants.ZERO.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FALLING_APART.getMessage());
        }
    }
}
