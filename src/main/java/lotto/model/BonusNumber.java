package lotto.model;

import static lotto.constant.ErrorMessage.ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.LOTTODUPLICATEDNUMBER;
import static lotto.constant.ErrorMessage.LOTTONUMBERRANGEOVER;
import static lotto.constant.Numbers.LOTTONUMBEREND;
import static lotto.constant.Numbers.LOTTONUMBERSTART;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber, Lotto answerLotto) {
        validate(bonusNumber, answerLotto);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Integer bonusNumber, Lotto answerLotto) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicated(bonusNumber, answerLotto);
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (bonusNumber > LOTTONUMBEREND.getIntValue() || bonusNumber < LOTTONUMBERSTART.getIntValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + LOTTONUMBERRANGEOVER.getValue());
        }
    }

    private void validateBonusNumberDuplicated(Integer bonusNumber, Lotto answerLotto) {
        if (answerLotto.getLotto().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + LOTTODUPLICATEDNUMBER.getValue());
        }
    }
}
