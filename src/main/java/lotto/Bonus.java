package lotto;

public class Bonus {
    private static final String DUPLICATE_ERROR = "[ERROR] 보너스 번호는 로또 번호와 중복되지 않습니다.";
    private static final String WRONG_RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final int number;

    Bonus(int number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
    }

    private void validate(int number, Lotto lotto) {
        validateDuplicate(number, lotto);
        validateMinToMax(number);
    }

    private void validateDuplicate(int number, Lotto lotto) {
        if (lotto.hasNumber(number)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private void validateMinToMax(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(WRONG_RANGE_ERROR);
        }
    }

    public int getNumber() {
        return number;
    }
}
