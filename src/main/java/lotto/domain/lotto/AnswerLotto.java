package lotto.domain.lotto;

import lotto.domain.Ranking;

import java.util.List;

public class AnswerLotto {

    private final Lotto lottoNumbers;
    private final BonusNumber bonusNumber;

    public AnswerLotto(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = new Lotto(lottoNumbers);
        this.bonusNumber = new BonusNumber(lottoNumbers, bonusNumber);
    }

    public Ranking calculateWinningResult(Lotto lotto) {
        int matchCount = lotto.compareToLottoNumbers(lottoNumbers);
        boolean containBonusNumber = lotto.compareToBonusNumber(bonusNumber.getBonusNumber());
        return Ranking.getRanking(matchCount, containBonusNumber);
    }
}
