package lotto.domain;

import lotto.domain.constant.Rank;

public class ResultRepository {
    final private int numberOfCorrect;
    final private boolean hitBonusNumber;

    public ResultRepository(WinningLotto winningLotto, Lotto lotto) {
        numberOfCorrect = lotto.compareTo(winningLotto.winningLotto);
        hitBonusNumber = lotto.contains(winningLotto.bonusNumber);
    }

    public Rank getRank() {
        return Rank.getRank(numberOfCorrect, hitBonusNumber);
    }
}
