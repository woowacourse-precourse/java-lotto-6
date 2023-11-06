package lotto.validator;

import lotto.domain.Player;

public class PlayerInputValidator {
    private static final int CHECK_POSITIVE_NUMBER = 0;
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자만 등록 가능합니다.";
    private static final String NOT_POSITIVE_NUMBER_ERROR = "[ERROR] 금액은 0 초과이어야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + Player.LOTTO_PRICE + "단위여야 합니다.";

    public static int validate(String count) {
        int countNumber = validateNumber(count);
        validatePositive(countNumber);
        validateDivisible(countNumber);
        return countNumber;
    }

    private static int validateNumber(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    private static void validatePositive(int count) {
        if (count <= CHECK_POSITIVE_NUMBER) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR);
        }
    }

    private static void validateDivisible(int count) {
        if (count % Player.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_NUMBER_ERROR);
        }
    }
}
