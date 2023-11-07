package lotto.domain;

import static lotto.constants.LottoConstant.LOTTO_PRICE_UNIT;

public class Money {
    private final long amount;

    public Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) throws IllegalArgumentException {
        if (!isPositive(amount)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수여야 합니다");
        }
        if (canNotDivide(amount, LOTTO_PRICE_UNIT)) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_PRICE_UNIT + "원 단위로 구입이 가능합니다");
        }
    }

    public boolean isPositive(long amount) {
        return amount > 0;
    }

    public boolean canNotDivide(long amount, int unit) {
        return amount % unit != 0;
    }

    public long getLottoTicketCount(int unit) {
        return amount / unit;
    }
}
