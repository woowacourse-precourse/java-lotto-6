package lotto.domain;

import java.util.List;

public class AnswerLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public AnswerLotto(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new BonusNumber(numbers, bonusNumber);
    }

    public Ranking calculateWinningResult(Lotto userLotto) {
        int matchCount = userLotto.compareToAnswerLotto(lotto);
        boolean containBonusBall = userLotto.compareToBonusNumber(bonusNumber.getBonusNumber());

        return Ranking.getRanking(matchCount, containBonusBall);
    }
}
