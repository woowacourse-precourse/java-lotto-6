package lotto.domain;

public class Money {

    private final long amount;
    private final String ERROR = "[ERROR] ";
    private final int UNIT = 1000;

    public Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) throws IllegalArgumentException {
        if (!isPositive(amount)) {
            throw new IllegalArgumentException(ERROR + "구입금액은 양수여야 합니다");
        }
        if (canNotDivide(amount, UNIT)) {
            throw new IllegalArgumentException(ERROR + UNIT + "원 단위로 구입이 가능합니다");
        }
    }

    public boolean isPositive(long amount) {
        return amount > 0;
    }

    public boolean canNotDivide(long amount, int unit) {
        return amount % unit != 0;
    }

    public long getLottoTicketCount(int unit) {
        return amount / unit;
    }
}
