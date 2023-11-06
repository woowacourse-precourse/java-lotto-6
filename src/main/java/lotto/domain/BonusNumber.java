package lotto.domain;

public class BonusNumber {
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 1 ~ 45 범위의 숫자만 입력 가능합니다.";

    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public boolean isEqual(int number) {
        return this.number == number;
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}
