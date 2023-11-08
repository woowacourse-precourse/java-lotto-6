package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.BonusNumberException;
import lotto.exception.LottoRangeException;

public class WinNumber {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer WINNING_NUMBER_SIZE = 7;

    private final Lotto winNumber;
    private final Integer bonusNumber;

    public WinNumber(List<Integer> winNumber, Integer bonusNumber) {
        this.winNumber = new Lotto(winNumber);
        validateBonusNumber(winNumber, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winNumber, Integer bonusNumber) {
        validateBonus(winNumber, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateBonus(List<Integer> winNumber, Integer bonusNumber) {
        Set<Integer> beforeNumbers = new HashSet<>(winNumber);
        beforeNumbers.add(bonusNumber);
        if (beforeNumbers.size() != WINNING_NUMBER_SIZE) {
            try {
                throw new BonusNumberException();
            } catch (BonusNumberException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void validateRange(Integer bonusNumber) {
        if (bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new LottoRangeException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
