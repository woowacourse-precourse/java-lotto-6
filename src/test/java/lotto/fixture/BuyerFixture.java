package lotto.fixture;

import lotto.domain.lottery.Buyer;

public enum BuyerFixture {
    VALID(30000),
    NEGATIVE_INTEGER(-1000),
    SMALLER_THAN_UNIT_PRICE(300),
    ZERO(0),
    CANT_DIVISIBLE_BY_UNIT_PRICE(3500),
    TOO_BIG(100000000);

    private final int paymentInput;

    BuyerFixture(int paymentInput) {
        this.paymentInput = paymentInput;
    }

    public Buyer toEntity() {
        return Buyer.from(paymentInput);
    }

    public int getPaymentInput() {
        return paymentInput;
    }
}
