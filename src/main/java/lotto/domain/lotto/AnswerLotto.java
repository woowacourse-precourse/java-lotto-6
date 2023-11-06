package lotto.domain.lotto;

import lotto.domain.Ranking;

import java.util.List;

public class AnswerLotto {

    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    public AnswerLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new BonusNumber(winningNumbers, bonusNumber);
    }

    public Ranking calculateWinningResult(Lotto userLotto) {
        int matchCount = userLotto.compareToWinningNumbers(winningNumbers);
        boolean containBonusNumber = userLotto.compareToBonusNumber(bonusNumber.getBonusNumber());
        return Ranking.getRanking(matchCount, containBonusNumber);
    }
}
