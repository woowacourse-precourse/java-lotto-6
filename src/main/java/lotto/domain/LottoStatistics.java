package lotto.domain;

import java.util.HashMap;

public class LottoStatistics {
    private final HashMap<LottoRank, Integer> rankCounter;
    private final long winningMoney;
    private final double rateOfReturn;

    public LottoStatistics(LottosPurchased lottosPurchased, Lotto winningLotto, LottoBonus lottoBonus, Amount amount) {
        rankCounter = new HashMap<>();
        initRankCounter();
        countRanks(lottosPurchased, winningLotto, lottoBonus);
        winningMoney = calculateWinningMoney();
        rateOfReturn = calculateRateOfReturn(amount);
    }

    private void initRankCounter() {
        for (LottoRank lottoPrize : LottoRank.values()) {
            rankCounter.put(lottoPrize, 0);
        }
    }

    private void countRanks(LottosPurchased lottosPurchased, Lotto winningLotto, LottoBonus lottoBonus) {
        int numberOfLottosPurchased = lottosPurchased.getNumberOfLottos();

        for (int i = 0; i < numberOfLottosPurchased; i++) {
            Lotto lotto = lottosPurchased.getLotto(i);
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

    private double calculateRateOfReturn(Amount amount) {
        return 100.0 * winningMoney / amount.getAmount();
    }
}
