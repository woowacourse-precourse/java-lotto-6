package lotto.domain;

import static lotto.domain.policy.LottoNumberGeneratePolicy.MAX_NUM;
import static lotto.domain.policy.LottoNumberGeneratePolicy.MIN_NUM;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number, WinningNumbers winningNumbers) {
        validateRange(number);
        validateDuplicate(number, winningNumbers);
        this.number = number;
    }

    private void validateDuplicate(int number, WinningNumbers winningNumbers) {
        if (winningNumbers.hasDuplicate(number)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_NUM || number > MAX_NUM;
    }

    public boolean match(int number) {
        return this.number == number;
    }

}
