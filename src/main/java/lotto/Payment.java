package lotto;

import java.util.Objects;

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
            throw new IllegalArgumentException("로또 구입 금액은 1000원 이상이어야 합니다.");
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
