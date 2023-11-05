package lotto.domain;

import static lotto.utils.validator.LottoNumberValidator.validateDuplicateNumbers;
import static lotto.utils.validator.LottoNumberValidator.validateOutOfRange;

import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validateDuplicateNumbers(winningNumber);
        validateOutOfRange(winningNumber);
        this.winningNumber = winningNumber;
    }

    public int calculateCorrectNumberCount(Lotto lotto) {
        int count = 0;
        for (int number : winningNumber) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
