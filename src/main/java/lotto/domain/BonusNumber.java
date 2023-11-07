package lotto.domain;

public class BonusNumber {

    private int bonusNumber;
    private static final String NUMBER_RANGE_EXCEPTION = "1 부터 45 까지의 숫자를 입력해 주세요.";

    public BonusNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
        }
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
