package lotto.model;

import lotto.constant.ErrorMessage;

public class Purchase {

    private static final int PURCHASE_MONEY_UNIT = 1000;
    public static final int ZERO = 0;

    private final int lottoAmount;

    public Purchase(int purchaseMoney) {
        validate(purchaseMoney);

        this.lottoAmount = purchaseMoney / PURCHASE_MONEY_UNIT;
    }

    private void validate(int purchaseMoney) {
        validateBiggerThanZero(purchaseMoney);
        validateMultipleOf1000(purchaseMoney);
    }

    private void validateBiggerThanZero(int purchaseMoney) {
        if (purchaseMoney <= ZERO) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MONEY_NOT_BIGGER_THAN_ZERO.get());
        }
    }

    private void validateMultipleOf1000(int purchaseMoney) {
        if (purchaseMoney % PURCHASE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MONEY_NOT_MULTIPLE_OF_1000.get());
        }
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}