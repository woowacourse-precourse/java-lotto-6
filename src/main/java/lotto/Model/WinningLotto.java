package lotto.Model;

import lotto.Util.Rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);

        validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningLotto, Integer bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        validateRange(bonusNumber);
    }
    private void validateDuplicate(List<Integer> winningLotto, Integer number) {
        Set<Integer> NotDuplicateNumbers = new HashSet<>(winningLotto);
        NotDuplicateNumbers.add(number);
        if(NotDuplicateNumbers.size() != Rule.MAX_LENGTH) {
            throw new IllegalArgumentException(Rule.LOTTO_NUM_SIZE_ERROR);
        }
    }
    private void validateRange(Integer number) {
        if(!(Rule.MIN_NUMBER <= number && number <= Rule.MAX_NUMBER)) {
            throw new IllegalArgumentException(Rule.LOTTO_NUM_RANGE);
        }
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
    public boolean isContain(int number) {
        return winningLotto.isContain(number);
    }
}
