package lotto.model;

import lotto.common.Constant;
import lotto.common.ErrorMessage;

public class WinningNumbers {

    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningNumbers(Lotto lotto, Number bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }

    public static WinningNumbers createWinningNumbers(Lotto lotto, String bonusNumber) {
        Number number = parseAndValidateBonusNumber(bonusNumber);
        return new WinningNumbers(lotto, number);
    }

    private static Number parseAndValidateBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        return Number.of(Integer.parseInt(bonusNumber));
    }

    private void validate(Lotto lotto, Number bonusNumber) {
        if (isContainsBonusNumber(lotto, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.get());
        }
    }

    private boolean isContainsBonusNumber(Lotto lotto, Number bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private static void validateBonusNumber(String bonusNumber) {
        isNullBonusNumber(bonusNumber);
        isContainsBlank(bonusNumber);
        isNotOneBonusNumber(bonusNumber);
    }

    private static void isNotOneBonusNumber(String bonusNumber) {
        String[] bonusNumbers = bonusNumber.split(Constant.COMMA.getCharValue());
        if (bonusNumbers.length != 1 || bonusNumbers[0].isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IS_NOT_ONE.get());
        }
    }

    private static void isNullBonusNumber(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NULL.get());
        }
    }

    private static void isContainsBlank(String bonusNumber) {
        if (bonusNumber.contains(Constant.BLANK.getCharValue())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_CONTAINS_BLANK.get());
        }
    }
}
