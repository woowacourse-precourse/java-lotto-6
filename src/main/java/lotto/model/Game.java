package lotto.model;

import java.util.List;
import java.util.Map;

public class Game {

    private Lottos lottos;

    public Lottos createLottos(int buyAmount) {
        lottos = Lottos.from(buyAmount);
        return this.lottos;
    }

    public LottoRankInfo createResult(List<Integer> winningNumbers, int bonusNumber) {
        LottoChecker lottoChecker = new LottoChecker(new WinningNumbers(winningNumbers), new BonusNumber(bonusNumber));
        return lottoChecker.createResult(lottos);
    }


    public float createProfit(float buyAmount, Map<LottoRank, Integer> lottoRankInfo) {
        Profit profit = new Profit();
        return profit.calculateProfitRate(buyAmount, lottoRankInfo);
    }


}
