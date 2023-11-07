package lotto.model;

import lotto.exception.business.BusinessConditionException;

public class LottoPurchaseAmount {
    private final int amount;

    public LottoPurchaseAmount(int amount) {
        validatePositive(amount);
        validateMultipleOfThousand(amount);
        this.amount = amount;
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new BusinessConditionException("구입 금액은 양수여야 합니다.");
        }
    }

    private void validateMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new BusinessConditionException("구입 금액은 1000의 자리로 나눠 떨어져야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
