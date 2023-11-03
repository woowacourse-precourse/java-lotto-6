package lotto.model;

import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_BONUS_DUPLICATE;
import static lotto.enumerate.ErrorCode.LOTTO_NUMBER_UNDER_OR_OVER;
import static lotto.util.ExceptionCodeThrow.exceptionCodeThrow;

import java.util.List;
import lotto.record.LottoNumberRecord;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchingNumbers(LottoNumberRecord lottoNumberRecord) {
        int matches = 0;
        for (int number : lottoNumberRecord.numbers()) {
            if (numbers.contains(number)) {
                matches++;
            }
        }
        return matches;
    }

    public boolean hasMatchingBonusNumber(LottoNumberRecord lottoNumberRecord) {
        return lottoNumberRecord.numbers().contains(bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        bonusNumberWinningNumberDuplicateValidate(numbers, bonusNumber);
        bonusNumberUnderOverValidate(bonusNumber);
    }

    private void bonusNumberUnderOverValidate(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            exceptionCodeThrow(LOTTO_NUMBER_UNDER_OR_OVER);
        }
    }

    private void bonusNumberWinningNumberDuplicateValidate(List<Integer> numbers, int bonusNumber) {
        if (numbers.stream().anyMatch(number -> number == bonusNumber)) {
            exceptionCodeThrow(LOTTO_NUMBER_BONUS_DUPLICATE);
        }
    }
}
