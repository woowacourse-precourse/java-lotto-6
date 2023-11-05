package lotto.domain;

public class Money {
    private final int amount;

    public Money(int amount) {
        validatePositive(amount);
        this.amount = amount;
    }

    private void validatePositive(int amount) {
        if (amount < LottoConfig.ZERO.getValue()) {
            throw new IllegalArgumentException(LottoErrorMessages.NEGATIVE_AMOUNT.getMessage());
        }
    }

    // 추가 메서드 구현
    public int getAmount() {
        return amount;
    }
}
