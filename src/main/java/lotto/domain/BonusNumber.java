package lotto.domain;

public class BonusNumber {

    private final Integer number;

    public BonusNumber(Integer number) {
        validateInRange(number);
        this.number = number;
    }

    private void validateInRange(Integer number) {
        if (notInRange(number)) {
            throw new IllegalArgumentException("1~45사이의 값만 입력해주세요.");
        }
    }

    private static boolean notInRange(Integer number) {
        return !LottoConstraint.inRange(number);
    }
}
