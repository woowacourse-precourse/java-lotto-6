package lotto.domain;

import lotto.exception.InvalidBonusNumberFormatException;
import lotto.exception.InvalidBonusNumberRangeException;
import lotto.exception.MissingBonusNumberException;

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
            throw new MissingBonusNumberException();
        }
    }

    private void isValidBonusNumber(String number) {
        if (number.matches(".*[^0-9].*")) {
            throw new InvalidBonusNumberFormatException();
        }
    }

    private void isBonusNumberInRange(String number) {
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
            throw new InvalidBonusNumberRangeException();
        }
    }
}