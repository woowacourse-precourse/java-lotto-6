package lotto.domain;

import lotto.exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoBonusNumber {

    private static final int LOTTO_NUMBERS_MINIMUM = 1;
    private static final int LOTTO_NUMBERS_MAXIMUM = 45;

    private final int bonusNumber;

    public LottoBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateNumberRange(bonusNumber);
        validateDuplicateNumbers(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_NUMBERS_MINIMUM || number > LOTTO_NUMBERS_MAXIMUM) {
            ExceptionMessage.LOTTO_WRONG_NUMBER_RANGE.throwIllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(int bonusNumber, List<Integer> numbers) {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        copiedNumbers.add(bonusNumber);
        long distinctCount = copiedNumbers.stream()
                .distinct()
                .count();

        if (distinctCount != copiedNumbers.size()) {
            ExceptionMessage.LOTTO_DUPLICATE_NUMBERS.throwIllegalArgumentException();
        }
    }

    public boolean includesBonusNumber(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}
