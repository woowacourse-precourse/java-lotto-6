package lotto.domain;

import lotto.constant.LottoRank;

import java.util.HashMap;
import java.util.List;

public class LottoStatistics {
    private final HashMap<LottoRank, Integer> rankCounter;
    private final long winningMoney;
    private final double winningRate;

    public LottoStatistics(List<Lotto> purchasedLottos, Lotto winningLotto, int lottoBonus, int amount) {
        rankCounter = new HashMap<>();
        initRankCounter();
        countRanks(purchasedLottos, winningLotto, lottoBonus);
        winningMoney = calculateWinningMoney();
        winningRate = calculateWinningRate(amount);
    }

    public HashMap<LottoRank, Integer> getRankCounter() {
        return rankCounter;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public double getWinningRate() {
        return winningRate;
    }

    private void initRankCounter() {
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCounter.put(lottoRank, 0);
        }
    }

    private void countRanks(List<Lotto> purchasedLottos, Lotto winningLotto, int lottoBonus) {
        for (int i = 0; i < purchasedLottos.size(); i++) {
            Lotto lotto = purchasedLottos.get(i);
            int winningInLotto = lotto.countMatchingWith(winningLotto);
            boolean bonusInLotto = lotto.contains(lottoBonus);
            LottoRank rank = LottoRank.getRank(winningInLotto, bonusInLotto);

            rankCounter.put(rank, rankCounter.get(rank) + 1);
        }
    }

    private long calculateWinningMoney() {
        long winningMoney = 0;

        for (LottoRank lottoRank : LottoRank.values()) {
            winningMoney += lottoRank.getMoney() * rankCounter.get(lottoRank);
        }
        return winningMoney;
    }

    private double calculateWinningRate(int amount) {
        return 100.0 * winningMoney / amount;
    }
}
