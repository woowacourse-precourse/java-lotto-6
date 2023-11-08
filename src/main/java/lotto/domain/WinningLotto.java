package lotto.domain;

import lotto.exception.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer REQUIRED_LOTTO_SIZE = 7;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        validateBonusDuplicate(winningLotto, bonusNumber);
        validateBonusRange(bonusNumber);
    }

    private void validateBonusDuplicate(List<Integer> winningLotto, int bonusNumber) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningLotto);
        nonDuplicateNumbers.add(bonusNumber);
        if (nonDuplicateNumbers.size() != REQUIRED_LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.DuplicateError);
        }
    }

    private void validateBonusRange(int bonusNumber) {
        if (bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.RangeError);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isContain(int bonusNumber) {
        return winningLotto.isContain(bonusNumber);
    }
}

