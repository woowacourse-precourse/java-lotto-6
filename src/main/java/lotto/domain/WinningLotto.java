package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ErrorMessage;

public class WinningLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int WINNING_LOTTO_SIZE = 7;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_NUMBER);
        }
    }

    private void validateDuplicateNumber(Lotto winningLotto, int bonusNumber) {
        List<Integer> numbers = winningLotto.getNumbers();
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        lottoNumbers.add(bonusNumber);
        boolean hasDuplicates = lottoNumbers.size() != WINNING_LOTTO_SIZE;
        if (hasDuplicates) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_DUPLICATE_NUMBER);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
