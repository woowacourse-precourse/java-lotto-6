package lotto.domain;

import static lotto.domain.LottoRule.MAXIMUM;
import static lotto.domain.LottoRule.MINIMUM;
import static lotto.util.ErrorMessage.INPUT_NOT_IN_RANGE;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validateNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberInRange(int bonusNumber) {
        if (isNotNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_NOT_IN_RANGE.getMessage());
        }
    }

    private boolean isNotNumberInRange(int bonusNumber) {
        return bonusNumber < MINIMUM.getValue() || bonusNumber > MAXIMUM.getValue();
    }
}
