package lotto.domain;

import static lotto.constant.ErrorMessage.*;
import lotto.constant.LottoConfig;

public class PurchaseLotto {
    private static final int NUMBER_ZERO = 0;

    private final int lottoCount;

    public PurchaseLotto(String amount) {
        int amountNum = parseAmount(amount);
        this.lottoCount = calculateLottoCount(amountNum);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private int parseAmount(String amount) {
        validate(amount);
        return Integer.parseInt(amount);
    }

    private void validate(String amount) {
        validateSpace(amount);
        validateNumber(amount);
        validateFirstNumber(amount);
        validateMultipleOf1000(amount);
        validateMaxPurchase(amount);
    }

    private void validateSpace(String amount) {
        if (amount.contains(" ")) {
            throw new IllegalArgumentException(ERROR_CONTAIN_SPACE.toString());
        }
    }

    private void validateNumber(String amount) {
        if (!isNumeric(amount)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER.toString());
        }
    }

    private boolean isNumeric(String str) {
        return str.matches(LottoConfig.IS_NUMBER);
    }

    private void validateFirstNumber(String amount) {
        int firstNumber = amount.charAt(0) - '0';
        if (firstNumber == NUMBER_ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_FIRST_ZERO.toString());
        }
    }

    private void validateMultipleOf1000(String amount) {
        int amountNum = Integer.parseInt(amount);
        if (amountNum % LottoConfig.PURCHASE_AMOUNT_UNIT != NUMBER_ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_UNIT.toString());
        }
    }

    private void validateMaxPurchase(String amount) {
        int amountNum = Integer.parseInt(amount);
        if (amountNum > LottoConfig.PURCHASE_AMOUNT_MAX) {
            throw new IllegalArgumentException(ERROR_OVER_MAX.toString());
        }
    }

    private int calculateLottoCount(int amount) {
        return amount / LottoConfig.PURCHASE_AMOUNT_UNIT;
    }
}