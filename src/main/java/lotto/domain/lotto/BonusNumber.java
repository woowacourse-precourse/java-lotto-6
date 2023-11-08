package lotto.domain.lotto;

import java.util.List;
import lotto.util.ExceptionMessage;
import lotto.util.LottoConstants;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberRange(int bonusNumber) {
        if (!LottoConstants.isNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.OVER_LOTTO_NUMBER_RANGE_MESSAGE.getErrorMessage());
        }
    }

    public boolean isContains(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
