package lotto.domain;

import lotto.utils.StringValidator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, Lotto lotto) {
        validate(bonusNumber, lotto);
        this.bonusNumber = convertToInt(bonusNumber);
    }

    private int convertToInt(String number) {
        return Integer.parseInt(number);
    }

    private void validate(String bonusNumber, Lotto lotto) {
        if (StringValidator.isBlank(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionStatus.BONUS_NUMBER_EMPTY.getMessage());
        }
        if (!isValidFormat(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionStatus.BONUS_NUMBER_INVALID.getMessage());
        }
        if (!isNumber(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionStatus.BONUS_NUMBER_INVALID.getMessage());
        }
        if (!isValidRange(convertToInt(bonusNumber))) {
            throw new IllegalArgumentException(ExceptionStatus.BONUS_NUMBER_INVALID.getMessage());
        }
        if (isDuplicated(convertToInt(bonusNumber), lotto)) {
            throw new IllegalArgumentException(ExceptionStatus.LOTTO_COMMON_DUPLICATE.getMessage());
        }
    }

    private boolean isNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private boolean isValidFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionStatus.BONUS_NUMBER_INVALID.getMessage());
        }
        return true;
    }

    private boolean isValidRange(int number) {
        return number >= LottoPolicy.LOTTO_START_NUMBER && number <= LottoPolicy.LOTTO_END_NUMBER;
    }

    private boolean isDuplicated(int bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
