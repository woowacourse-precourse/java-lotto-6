package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.wrapper.LottoNumber;
import lotto.domain.wrapper.PurchaseAmout;
import lotto.utils.Prize;

public class PrizeManager {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private Lottos playerLottos;

    public PrizeManager(List<Integer> winningNumbers, int bonusNumber, Lottos playerLottos) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
        this.playerLottos = playerLottos;
    }

    public double getProfitRate(PurchaseAmout purchaseAmout) {
        return purchaseAmout.calculateProfitRate(getAllPrizeProfit());
    }

    private long getAllPrizeProfit() {
        Map<Prize, Integer> prizeCounts = playerLottos.getPrizeCounts(winningLotto, bonusNumber);
        long allPrizeProfit = 0;
        for (Prize prize : prizeCounts.keySet()) {
            long prizeProfit = (long) prize.getPrizeProfit() * prizeCounts.get(prize);
            allPrizeProfit += prizeProfit;
        }
        return allPrizeProfit;
    }
}
