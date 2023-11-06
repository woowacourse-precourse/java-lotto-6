package lotto.domain;

import lotto.exception.ExceptionMessage;

public class Bonus {
    private final int bonusNumber;

    private Bonus(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static Bonus from(int inputToNumber) {
        return new Bonus(inputToNumber);
    }

    public boolean hasSameNumberInLotto(Lotto generatedRandomLotto) { // 보너스 번호로 맞은 경우 
        return generatedRandomLotto.hasSameNumber(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > Lotto.MAX_VALUE || bonusNumber < Lotto.MIN_VALUE) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_NUMBER.getErrorDescription());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
