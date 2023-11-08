package lotto.domain.lotto;

public enum LottoConstraint {
    MIN(1),
    MAX(45),
    SIZE(6);

    private final int constraint;

    LottoConstraint(int constraint) {
        this.constraint = constraint;
    }

    @Override
    public String toString() {
        return String.valueOf(constraint);
    }

    public int getConstraint() {
        return constraint;
    }

    public static boolean checkSize(int size) {
        return size == SIZE.constraint;
    }

    public static boolean inRange(int number) {
        return MIN.constraint <= number && number <= MAX.constraint;
    }
}
