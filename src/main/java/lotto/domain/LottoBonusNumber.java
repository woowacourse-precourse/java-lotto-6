package lotto.domain;

public class LottoBonusNumber {

    private static final int START_NUMBER_IN_RANGE = 1;
    private static final int END_NUMBER_IN_RANGE = 45;

    private final int number;

    public LottoBonusNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (!isNumberInRange(number)) {
            throw new IllegalArgumentException("유효하지 않은 보너스 번호입니다.");
        }
    }

    private boolean isNumberInRange(int number) {
        return number >= START_NUMBER_IN_RANGE && number <= END_NUMBER_IN_RANGE;
    }

    public int getNumber() {
        return number;
    }
}
