package lotto.domain;

import java.util.List;
import java.util.HashSet;

public class WinningLotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int WINNING_LOTTO_SIZE = 7;

    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);

        isDuplicateValidate(winningLotto, bonusNumber);
        isNumberRangeValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void isDuplicateValidate(List<Integer> winningLotto, Integer bonusNumber) {
        HashSet<Integer> numberSet = new HashSet<>(winningLotto);
        numberSet.add(bonusNumber);
        if (!(numberSet.size() == WINNING_LOTTO_SIZE)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    private void isNumberRangeValidate(int number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new IllegalArgumentException("[ERROR] 숫자가 범위를 벗어났습니다.");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public boolean isContain(int number) {
        return winningLotto.isContain(number);
    }
}
