package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WinningNumber {
    private static final Integer DUPLICATE_CHECK_SIZE = 7;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final Lotto winningLotto;
    private final int bonusBall;

    public WinningNumber(List<Integer> winningLotto, int bonusBall) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusBall = bonusBall;
        validate(winningLotto, bonusBall);
    }

    private void validate(List<Integer> winningLotto, int bonusBall) {
        duplicateCheck(winningLotto, bonusBall);
        bonusBallValidate(bonusBall);
    }

    private void duplicateCheck(List<Integer> winningLotto, int bonusBall) {
        Set<Integer> checkSet = new HashSet<>(winningLotto);
        checkSet.add(bonusBall);
        if (checkSet.size() != DUPLICATE_CHECK_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.lottoNumberAndBonusDuplicatedException());
        }
    }

    private void bonusBallValidate(int bonusBall) {
        if (bonusBall < MIN_RANGE || bonusBall > MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.rangeException());
        }
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public boolean isContain(int number) {
        return winningLotto.isContain(number);
    }
}
