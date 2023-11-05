package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import lotto.constant.LottoConfig;

public class PurchaseLotto {
    public static int lottoCount(String amount) {
        int amountNum = parseAmount(amount);
        return calculateLottoCount(amountNum);
    }

    private static int parseAmount(String amount) {
        validate(amount);
        return Integer.parseInt(amount);
    }

    private static void validate(String amount) {
        validateSpace(amount);
        validateNumber(amount);
        validateFirstNumber(amount);
        validateMultipleOf1000(amount);
        validateMaxPurchase(amount);
    }

    private static void validateSpace(String amount) {
        if (amount.contains(" ")) {
            throw new IllegalArgumentException(ERROR_CONTAIN_SPACE.toString());
        }
    }

    private static void validateNumber(String amount) {
        if (!isNumeric(amount)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER.toString());
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private static void validateFirstNumber(String amount) {
        int firstNumber = amount.charAt(0) - '0';
        if (firstNumber == LottoConfig.NUMBER_ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_FIRST_ZERO.toString());
        }
    }

    private static void validateMultipleOf1000(String amount) {
        int amountNum = Integer.parseInt(amount);
        if (amountNum % LottoConfig.PURCHASE_AMOUNT_UNIT != LottoConfig.NUMBER_ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_UNIT.toString());
        }
    }

    private static void validateMaxPurchase(String amount) {
        int amountNum = Integer.parseInt(amount);
        if (amountNum > LottoConfig.PURCHASE_AMOUNT_MAX) {
            throw new IllegalArgumentException(ERROR_OVER_MAX.toString());
        }
    }

    private static int calculateLottoCount(int amount) {
        return amount / LottoConfig.PURCHASE_AMOUNT_UNIT;
    }
}