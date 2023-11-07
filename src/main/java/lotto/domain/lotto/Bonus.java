package lotto.domain.lotto;

import static lotto.util.ExceptionEnum.NUMBER_OUT_OF_RANGE;

public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        throwIfBonusNumberOutOfRange(bonusNumber);
    }

    private void throwIfBonusNumberOutOfRange(int bonusNumbers) {
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.message());
        }
    }

    private boolean isInRange(int number) {
        return number >= 1 && number <= 45;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
