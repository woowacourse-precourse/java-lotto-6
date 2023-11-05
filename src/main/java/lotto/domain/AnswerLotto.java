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
        // 당첨 번호에서 비교
        int matchCount = userLotto.compareToAnswerLotto(lotto);

        // 보너스 번호 비교
        boolean containBonusBall = userLotto.compareToBonusNumber(bonusNumber.getBonusNumber());

        return Ranking.getRanking(matchCount, containBonusBall);
    }
}
