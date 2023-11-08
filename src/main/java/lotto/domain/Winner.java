package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ErrorMessage;

public class Winner {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer WINNING_LOTTO_SIZE = 7;
    private final Lotto winner;
    private final Integer bonusnumber;

    public Winner(List<Integer> winner, Integer bonusnumber){
        this.winner = new Lotto(winner);

        validateBonusNumber(winner, bonusnumber);
        this.bonusnumber = bonusnumber;
    }

    private void validateBonusNumber(List<Integer> winningLotto, Integer bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningLotto, Integer number) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningLotto);
        nonDuplicateNumbers.add(number);
        if (nonDuplicateNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getMessage());
        }
    }
    private void validateRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_ERROR.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusnumber;
    }

    public boolean isContain(int number) {
        return winner.isContain(number);
    }
}
