package lotto.domain;

import lotto.exception.ExceptionMessage;

public class Bonus {
    private final int bonusNumber;

    private Bonus(int bonusNumber, Lotto lotto) {
        validateRange(bonusNumber);
        validateSameNumberInLotto(lotto);
        this.bonusNumber = bonusNumber;
    }

    public static Bonus from(int inputToNumber, Lotto lotto) {
        return new Bonus(inputToNumber, lotto);
    }

    public boolean hasSameNumberInGeneratedLotto(Lotto generatedRandomLotto) { // 보너스 번호로 맞은 경우
        return generatedRandomLotto.hasSameNumber(bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > Lotto.MAX_VALUE || bonusNumber < Lotto.MIN_VALUE) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_BONUS_NUMBER.getErrorDescription());
        }
    }

    private void validateSameNumberInLotto(Lotto lotto) {
        if (hasSameNumberInGeneratedLotto(lotto)) {
            throw new IllegalArgumentException(ExceptionMessage.SAME_NUMBER_WITH_LOTTO_NUMBER.getErrorDescription());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
