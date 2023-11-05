package lotto.domain;

public class BonusNumber {
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}