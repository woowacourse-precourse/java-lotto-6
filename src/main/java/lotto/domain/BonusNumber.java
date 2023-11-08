package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, Lotto lotto) {
        validate(bonusNumber, lotto);
        this.bonusNumber = toInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int toInt(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber, Lotto lotto) {
        if (isEmpty(bonusNumber)) {
            ErrorMessage.INPUT_IS_EMPTY.throwIllegalArgumentException();
        }
        if (!isNumeric(bonusNumber)) {
            ErrorMessage.BONUS_NUMBER_IS_NO_NUMBER.throwNumberFormatException();
        }
        if (!isInRange(bonusNumber)) {
            ErrorMessage.BONUS_NUMBER_IS_OUT_OF_RANGE.throwIllegalArgumentException();
        }
        if (isContain(bonusNumber, lotto)) {
            ErrorMessage.BONUS_NUMBER_CONTAIN_LOTTO.throwIllegalArgumentException();
        }
    }

    private boolean isEmpty(String bonusNumber) {
        return bonusNumber == null || bonusNumber.isBlank();
    }

    private boolean isNumeric(String bonusNumber) {
        return bonusNumber.chars().allMatch(Character::isDigit);
    }

    private boolean isInRange(String bonusNumber) {
        int number = toInt(bonusNumber);
        return number >= LottoConstant.LOTTO_START_RANGE && number <= LottoConstant.LOTTO_END_RANGE;
    }

    private boolean isContain(String bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(toInt(bonusNumber));
    }
}
