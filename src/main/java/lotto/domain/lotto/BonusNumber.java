package lotto.domain.lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.domain.bonusnumber.BonusNumberDuplicateException;
import lotto.exception.domain.bonusnumber.BonusNumberFormatException;
import lotto.utils.LottoValidator;

public class BonusNumber {
    private static final Pattern bonusNumberRegex = Pattern.compile("\\d+");

    private final int number;

    private BonusNumber(String bonusNumber, WinningNumbers winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.number = parseBonusNum(bonusNumber);
    }

    public static BonusNumber create(String bonusNumber, WinningNumbers winningNumbers) {
        return new BonusNumber(bonusNumber, winningNumbers);
    }

    private void validate(String bonusNumber, WinningNumbers winningNumbers) {
        validateFormat(bonusNumber);
        LottoValidator.validateRangeOfNumber(parseBonusNum(bonusNumber));
        validateDuplicateNumber(bonusNumber, winningNumbers);
    }

    private void validateFormat(String bonusNumber) {
        Matcher matcher = bonusNumberRegex.matcher(bonusNumber);
        boolean isInvalidFormat = !matcher.matches();

        if (isInvalidFormat) {
            throw new BonusNumberFormatException();
        }
    }

    private void validateDuplicateNumber(String bonusNumber, WinningNumbers winningNumbers) {
        if (isContained(bonusNumber, winningNumbers)) {
            throw new BonusNumberDuplicateException();
        }
    }

    private boolean isContained(String bonusNumber, WinningNumbers winningNumbers) {
        return winningNumbers.getNumbers().contains(parseBonusNum(bonusNumber));
    }

    private int parseBonusNum(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public int getNumber() {
        return number;
    }
}
