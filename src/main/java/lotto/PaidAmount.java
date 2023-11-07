package lotto;

import lotto.constants.LottoConfig;

public class PaidAmount {

    private static final int ZERO = 0;

    private final Integer paidAmount;

    public PaidAmount(final Integer paidAmount) {
        validate(paidAmount);
        this.paidAmount = paidAmount;
    }

    public Integer toNumberOfLottoTickets() {
        return paidAmount / LottoConfig.PRICE_PER_TICKET;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    private void validate(Integer paidAmount) {
        if (isZero(paidAmount)) {
            throw new IllegalArgumentException("[ERROR] " + ZERO + "원보다 큰 금액을 입력해주세요." );
        }
        if (isNotDivisibleByPrice(paidAmount)) {
            throw new IllegalArgumentException("[ERROR] 로또 금액 " + LottoConfig.PRICE_PER_TICKET + "으로 나누어떨어진 금액이어야합니다.");
        }
    }

    private boolean isZero(Integer paidAmount) {
        return paidAmount == ZERO;
    }

    private boolean isNotDivisibleByPrice(Integer paidAmount) {
        return paidAmount % LottoConfig.PRICE_PER_TICKET != 0;
    }
}
