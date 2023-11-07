package lotto.domain;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;

    public BonusNumber(int number) {
        if (hasValidRange(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    private static boolean hasValidRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
