package lotto.domain.lotto;

import java.util.Objects;
import java.util.StringJoiner;

import static lotto.utils.ErrorMessage.INVALID_LOTTO_PAYMENT;

public final class Payment {

    private static final int ZERO = 0;
    private static final int DIVISION = 1000;
    private final int amount;

    private Payment(int amount) {
        this.amount = amount;
    }

    public static Payment of(int amount) {
        validate(amount);
        return new Payment(amount);
    }

    private static void validate(int amount) {
        if (amount % DIVISION != ZERO) {
            throw new IllegalArgumentException(INVALID_LOTTO_PAYMENT.getMessage());
        }
    }

    public int getLottoCount() {
        return amount / DIVISION;
    }

    public int getAmount() {
        return amount;
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

    /**
     * 로또를 구매한 만큼의 개수를 출력한다.
     * ex) payment가 3000원이면
     * 8개를 구매했습니다.
     * 라는 문구를 출력한다.
     */
    @Override
    public String toString() {
        return new StringJoiner(" ")
                .add(getLottoCount() + "개를 구매했습니다.")
                .toString();
    }
}
