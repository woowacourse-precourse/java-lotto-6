package domain;

import exception.InvalidLottoNumberRangeException;
import exception.NumberDuplicateException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int WINNING_LOTTO_SIZE = 7;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);

        validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningLotto, int bonusNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningLotto);
        uniqueNumbers.add(bonusNumber);
        if (uniqueNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new NumberDuplicateException();
        }
    }

    private void validateRange(int bonusNumber) {
        if (!(MIN_RANGE <= bonusNumber && bonusNumber <= MAX_RANGE)) {
            throw new InvalidLottoNumberRangeException();
        }
    }

    public boolean hasNumber(int number) {
        return winningLotto.hasNumber(number);
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
