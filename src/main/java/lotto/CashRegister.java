package lotto;

public class CashRegister {
    private final int LOTTO_PRICE = 1000;

    private void validate(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
