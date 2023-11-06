package lotto.domain;

public record LottoNumber(int number) implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public LottoNumber {
        validate(number);
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
