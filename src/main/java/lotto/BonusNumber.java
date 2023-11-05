package lotto;

import constants.ErrorMessage;
import constants.NumberType;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, AnswerLotto answerLotto) {
        validateBonusNumber(bonusNumber, answerLotto);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, AnswerLotto answerLotto) {
        validateBonusNumberInAnswerLotto(bonusNumber, answerLotto);
        validateInRange(bonusNumber);
    }

    private void validateBonusNumberInAnswerLotto(int bonusNumber, AnswerLotto answerLotto) {
        if (checkBonusNumberInAnswerLotto(bonusNumber, answerLotto)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IN_ANSWER_LOTTO_ERROR.getMessage());
        }
    }

    private boolean checkBonusNumberInAnswerLotto(int bonusNumber, AnswerLotto answerLotto) {
        return answerLotto.hasNumber(bonusNumber);
    }

    private void validateInRange(int bonusNumber) {
        if (!checkBonusNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.BONUS_NUMBER_RANGE_ERROR.getMessage(),
                    NumberType.MIN_LOTTO_NUMBER.getValue(), NumberType.MAX_LOTTO_NUMBER.getValue()));
        }
    }

    private boolean checkBonusNumberInRange(int bonusNumber) {
        return bonusNumber >= NumberType.MIN_LOTTO_NUMBER.getValue()
                && bonusNumber <= NumberType.MAX_LOTTO_NUMBER.getValue();
    }
}
