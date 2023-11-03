package lotto;

public class CashRegister {
    private final int LOTTO_PRICE = 1000;

    public int calculateLottoCount(int amount) {
        validate(amount);
        return amount / LOTTO_PRICE;
    }

    private void validate(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
