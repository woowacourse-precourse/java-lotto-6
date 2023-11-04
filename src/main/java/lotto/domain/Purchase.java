package lotto.domain;

import lotto.utility.PurchaseErrorMessage;

// 입력하는 구입금액
public class Purchase {
    private final int amount;

    public Purchase(int amount) {
        validatePositiveInteger(amount);
        validateThousandUnit(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    // 구입 금액 양의 정수인지 검증
    private void validatePositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(PurchaseErrorMessage.NOT_POSITIVE_ERROR.getMessage());
        }
    }

    // 구입 금액 1000원 단위인지 검증
    private void validateThousandUnit(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(PurchaseErrorMessage.OUT_UNIT_ERROR.getMessage());
        }
    }
}
