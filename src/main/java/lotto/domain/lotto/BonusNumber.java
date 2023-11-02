package lotto.domain.lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.domain.bonusnumber.BonusNumberFormatException;
import lotto.exception.domain.bonusnumber.BonusNumberRangeException;

public class BonusNumber {
    private static final Pattern bonusNumberRegex = Pattern.compile("\\d");

    private final int number;

    public static BonusNumber create(String bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getNumber() {
        return number;
    }

    private BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.number = parseBonusNum(bonusNumber);
    }

    private void validate(String bonusNumber) {
        validateFormat(bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateFormat(String bonusNumber) {
        Matcher matcher = bonusNumberRegex.matcher(bonusNumber);
        boolean isInvalidFormat = !matcher.matches();

        if (isInvalidFormat) {
            throw new BonusNumberFormatException();
        }
    }

    private void validateRange(String bonusNumber) {
        int bonusNum = parseBonusNum(bonusNumber);

        if (isInvalidRange(bonusNum)) {
            throw new BonusNumberRangeException();
        }
    }

    private int parseBonusNum(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    private boolean isInvalidRange(int bonusNum) {
        return bonusNum < 1 || bonusNum > 45;
    }
}
