package lotto.domain.lotto;

import static lotto.domain.lotto.LottoRule.MAXIMUM;
import static lotto.domain.lotto.LottoRule.MINIMUM;
import static lotto.util.ErrorMessage.NOT_IN_RANGE;

public class Bonus {
    private final int bonusNumber;

    public Bonus(final int bonusNumber) {
        validateNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberInRange(final int bonusNumber) {
        if (isNotNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getMessage());
        }
    }

    private boolean isNotNumberInRange(final int bonusNumber) {
        return bonusNumber < MINIMUM.getValue() || bonusNumber > MAXIMUM.getValue();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
