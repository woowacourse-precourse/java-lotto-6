package lotto.service;

import lotto.GameUtils;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.RankStatistics;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameService {
    private PurchaseAmount purchaseAmount;
    private RankStatistics rankStatistics;

    public int getPurchaseNumber() {
        return purchaseAmount.getPurchaseNumber();
    }

    public String getRankStatisticsOutput() {
        return rankStatistics.toString();
    }

    public double getProfitRate() {
        return (double) rankStatistics.getTotalProfit() / purchaseAmount.getAmount();
    }

    public void initPurchaseAmount(String input) {
        this.purchaseAmount = new PurchaseAmount(input);
    }

    public void initRankStatistics(Map<Rank, Integer> statistics) {
        this.rankStatistics = new RankStatistics(statistics);
    }

    public List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseAmount.getPurchaseNumber(); count++) {
            lottos.add(GameUtils.createRandomLotto(Lotto.LOTTO_SIZE));
        }
        return lottos;
    }
}
