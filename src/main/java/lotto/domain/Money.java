package lotto.domain;

public class Money {

    private static final long AMOUNT_PER_UNIT = 1000;
    private final long value;

    public Money(long value) {
        validate(value);
        this.value = value;
    }

    public static Money from(long value) {
        return new Money(value);
    }

    private void validate(long value) {
        if (value < AMOUNT_PER_UNIT) {
            throw new IllegalArgumentException(String.format("[ERROR] 금액의 최소단위는 1000원 이상이어야 합니다. %s ", value));
        }

        if (value % AMOUNT_PER_UNIT != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 1,000원으로 나누어 떨어지지 않는 금액입니다. %s", value));
        }
    }

    public long getLottoCount() {
        return this.value / AMOUNT_PER_UNIT;
    }

    public long getAmount() {
        return this.value;
    }

}
