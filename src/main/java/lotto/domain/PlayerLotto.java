package lotto.domain;

import java.util.List;
import lotto.exception.NumberOutOfRangeException;
import lotto.exception.DuplicateNumberException;

public class PlayerLotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Integer bonusNumber;
    private final Lotto lotto;

    public PlayerLotto(List<Integer> playerLotto, Integer bonusNumber) {
        lotto = new Lotto(playerLotto);
        validateBonusNumber(playerLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    private void validateBonusNumber(List<Integer> playerLotto, Integer bonusNumber) {
        validateBonusRange(bonusNumber);
        validateDuplicateBonus(playerLotto, bonusNumber);
    }
    private void validateBonusRange(Integer bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new NumberOutOfRangeException();
        }
    }
    private void validateDuplicateBonus(List<Integer> playerLotto, Integer bonusNumber) {
        if (playerLotto.contains(bonusNumber)) {
            throw new DuplicateNumberException();
        }
    }
}
