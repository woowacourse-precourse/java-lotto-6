package lotto.domain;

import java.util.List;

public class LottoResult {
    private int match;
    private boolean bonusMatch;

    public LottoResult(List<Integer> winnerNumbers, BonusNumber bonusNumber, List<Integer> buyLotto) {
        this.match = countSameNumber(winnerNumbers, buyLotto);
        this.bonusMatch = countBonusNumber(bonusNumber, buyLotto);
    }

    private int countSameNumber(List<Integer> winnerNumbers, List<Integer> buyLotto) {
        for (int winnerNumber : winnerNumbers) {
            if (buyLotto.contains(winnerNumber)) {
                match++;
            }
        }
        return match;
    }

    private boolean countBonusNumber(BonusNumber bonusNumber, List<Integer> buyLotto) {
        return buyLotto.contains(bonusNumber.getBonusNumber());
    }

    public int getMatch() {
        return this.match;
    }

    public boolean hasBonusMatch() {
        return this.bonusMatch;
    }
}
