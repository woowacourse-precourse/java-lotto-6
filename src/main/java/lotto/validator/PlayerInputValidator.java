package lotto.validator;

import lotto.domain.Player;

public class PlayerInputValidator {
    private static final int CHECK_POSITIVE_NUMBER = 0;
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자만 등록 가능합니다.";
    private static final String NOT_POSITIVE_NUMBER_ERROR = "[ERROR] 금액은 0 초과이어야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + Player.LOTTO_PRICE + "단위여야 합니다.";

    public static int validateNumber(String count) {
        if (!isNumeric(count)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
        if (!isPositive(Integer.parseInt(count))) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR);
        }
        if (!isDivisible(Integer.parseInt(count))) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_NUMBER_ERROR);
        }

        return Integer.parseInt(count);
    }

    public static boolean isNumeric(String count) {
        try {
            Integer.parseInt(count);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositive(int count) {
        if (count <= CHECK_POSITIVE_NUMBER) {
            return false;
        }
        return true;
    }

    private static boolean isDivisible(int count) {
        if (count % Player.LOTTO_PRICE != 0) {
            return false;
        }
        return true;
    }
}
