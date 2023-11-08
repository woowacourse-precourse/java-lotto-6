package lotto.domain;

import lotto.exception.ErrorCode;

public class BonusNumber {
    private final int number;

    public BonusNumber(String number) {
        verification(number);
        this.number = Integer.parseInt(number);
    }

    public boolean bonusNumberMatch(Lotto lotto) {
        return lotto.getNumbers().contains(number);
    }

    private void verification(String number) {
        isNullBonusNumber(number);
        isValidBonusNumber(number);
        isBonusNumberInRange(number);
    }

    private void isNullBonusNumber(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.MISSING_BONUS_NUMBER.getMessage());
        }
    }

    private void isValidBonusNumber(String number) {
        if (number.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }

    private void isBonusNumberInRange(String number) {
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
            throw new IllegalArgumentException(ErrorCode.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }
}