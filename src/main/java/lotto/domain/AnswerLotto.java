package lotto.domain;

import java.util.List;

public class AnswerLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public AnswerLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.lotto = new Lotto(winningNumbers);
        this.bonusNumber = new BonusNumber(winningNumbers, bonusNumber);
    }

    public Ranking calculateWinningResult(Lotto userLotto) {
        int matchCount = userLotto.compareToAnswerLotto(lotto);
        boolean containBonusNumber = userLotto.compareToBonusNumber(bonusNumber.getBonusNumber());

        return Ranking.getRanking(matchCount, containBonusNumber);
    }
}
