package lotto.domain.lotto;

import lotto.domain.Ranking;

import java.util.List;

public class AnswerLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public AnswerLotto(List<Integer> lotto, int bonusNumber) {
        this.lotto = new Lotto(lotto);
        this.bonusNumber = new BonusNumber(lotto, bonusNumber);
    }

    public Ranking calculateWinningResult(Lotto userLotto) {
        int matchCount = userLotto.compareToWinningNumbers(lotto);
        boolean containBonusNumber = userLotto.compareToBonusNumber(bonusNumber.getBonusNumber());
        return Ranking.getRanking(matchCount, containBonusNumber);
    }
}
