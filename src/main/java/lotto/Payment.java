package lotto;

import lotto.utils.ErrorMessage;

import java.util.Objects;

import static lotto.utils.ErrorMessage.INVALID_LOTTO_PAYMENT;

public class Payment {

    private final int amount;

    private Payment(int amount) {
        this.amount = amount;
    }

    public static Payment of(int amount) {
        validate(amount);
        return new Payment(amount);
    }

    private static void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_LOTTO_PAYMENT.getMessage());
        }
    }

    public int getLottoCount() {
        return amount / 1000;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return amount == payment.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
