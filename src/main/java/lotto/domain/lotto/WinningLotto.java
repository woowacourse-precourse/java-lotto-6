package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ExceptionMessage;

public class WinningLotto extends Lotto {
    private BonusNumber bonusNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
        validateDuplication(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        if (bonusNumber.isContains(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATION_BONUS_NUMBER_MESSAGE.getErrorMessage());
        }
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        Set<Integer> winningNumbers = new HashSet<>(getNumbers());
        Set<Integer> numbers = new HashSet<>(otherLotto.getNumbers());

        winningNumbers.retainAll(numbers);

        return winningNumbers.size();
    }

    public boolean isMatchBonusNumber(Lotto otherLotto) {
        return bonusNumber.isContains(otherLotto.getNumbers());
    }
}
