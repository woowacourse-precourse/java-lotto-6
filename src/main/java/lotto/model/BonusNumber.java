package lotto.model;

import static lotto.enumerate.ConfigInteger.LOTTO_END_NUMBER;
import static lotto.enumerate.ConfigInteger.LOTTO_START_NUMBER;
import static lotto.enumerate.ErrorCode.BONUS_NUMBER_IS_NOT_INTEGER;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_BONUS_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(LottoNumbers lottoNumbers, String bonusNumber) {
        int bonus = convertBonus(bonusNumber);
        validateBonusNumber(lottoNumbers, bonus);
        this.bonusNumber = bonus;
    }

    private static int convertBonus(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            exceptionCodeThrow(BONUS_NUMBER_IS_NOT_INTEGER);
        }
        return 0;
    }

    private void validateBonusNumber(LottoNumbers numbers, int bonusNumber) {
        bonusNumberWinningNumberDuplicateValidate(numbers, bonusNumber);
        bonusNumberUnderOverValidate(bonusNumber);
    }

    private void bonusNumberUnderOverValidate(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUMBER.getInt() || bonusNumber > LOTTO_END_NUMBER.getInt()) {
            exceptionCodeThrow(LOTTO_NUMBER_UNDER_OR_OVER);
        }
    }

    private void bonusNumberWinningNumberDuplicateValidate(LottoNumbers numbers, int bonusNumber) {
        if (numbers.getLottoNumbers().stream().anyMatch(number -> number == bonusNumber)) {
            exceptionCodeThrow(LOTTO_NUMBER_BONUS_DUPLICATE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
