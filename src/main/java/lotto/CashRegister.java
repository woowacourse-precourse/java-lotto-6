package lotto;

public class CashRegister {
    private static final int LOTTO_PRICE = 1000;
    private int amount;

    public int calculateLottoCount(int amount) {
        validate(amount);
        this.amount = amount;
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
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
