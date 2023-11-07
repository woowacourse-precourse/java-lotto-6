package lotto.domain.result;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;

public class LottoResult {
    private int match;
    private boolean hasBonus;

    public LottoResult(LottoGame lottoGame, Lotto buyLotto) {
        this.match = countSameNumber(lottoGame, buyLotto);
        this.hasBonus = countBonusNumber(lottoGame, buyLotto);
    }

    private int countSameNumber(LottoGame lottoGame, Lotto buyLotto) {
        List<Integer> winnerNumbers = lottoGame.getWinningNumbers();
        for (int winnerNumber : winnerNumbers) {
            if (buyLotto.contains(winnerNumber)) {
                match++;
            }
        }
        return match;
    }

    private boolean countBonusNumber(LottoGame lottoGame, Lotto buyLotto) {
        int bonusNumber = lottoGame.getBonusNumber();
        return buyLotto.contains(bonusNumber);
    }

    public int getMatch() {
        return this.match;
    }

    public boolean hasBonusMatch() {
        return this.hasBonus;
    }

    public WinningRank calculateRank() {
        return WinningRank.getRank(match, hasBonus);
    }
}
