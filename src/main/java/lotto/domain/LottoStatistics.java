package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {
    private final List<Integer> rankCounter;
    private int winningMoney;

    public LottoStatistics(LottosPurchased lottosPurchased, Lotto winningLotto, LottoBonus lottoBonus) {
        rankCounter = new ArrayList<>();
        winningMoney = 0;
        int numberOfLottosPurchased = lottosPurchased.getNumberOfLottos();

        for (int i = 0; i < 6; i++) {
            rankCounter.add(0);
        }

        for (int i = 0; i < numberOfLottosPurchased; i++) {
            Lotto lotto = lottosPurchased.getLotto(i);
            int winningInLotto = lotto.countMatchingWith(winningLotto);
            boolean bonusInLotto = lotto.contains(lottoBonus);
            int rank = getRank(winningInLotto, bonusInLotto);

            rankCounter.set(rank, rankCounter.get(rank) + 1);
        }
    }

    private int getRank(int winningInLotto, boolean bonusInLotto) {
        if (winningInLotto == 6) {
            return 1;
        } else if (winningInLotto == 5 && bonusInLotto) {
            return 2;
        } else if (winningInLotto == 5) {
            return 3;
        } else if (winningInLotto == 4) {
            return 4;
        } else if (winningInLotto == 3) {
            return 5;
        }
        return 0;
    }
}
