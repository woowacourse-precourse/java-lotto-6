package lotto.domain.lotto;

import static lotto.util.ExceptionEnum.NUMBER_OUT_OF_RANGE;

public class Bonus {

    private static final int STARTINCLUSIVE = 1;
    private static final int ENDINCLUSIVE = 1;

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
    return number >= STARTINCLUSIVE && number <= ENDINCLUSIVE;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
