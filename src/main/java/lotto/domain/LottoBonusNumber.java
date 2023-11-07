package lotto.domain;

import lotto.exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoBonusNumber {

    private final int bonusNumber;

    public LottoBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateDuplicateNumbers(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
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

    public int getBonusNumber() {
        return bonusNumber;
    }
}
