package lotto.domain;

public class Money {
    private final int amount;

    public Money(int amount) {
        validateModulo(amount);
        validateNegative(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validateModulo(int amount) {
        if (amount % LottoMachine.getLottoPrice() != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNegative(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
