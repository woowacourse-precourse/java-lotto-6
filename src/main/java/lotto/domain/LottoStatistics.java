package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {
    private final List<Integer> rankCounter;
    private long winningMoney;
    private double rateOfReturn;

    public LottoStatistics(LottosPurchased lottosPurchased, Lotto winningLotto, LottoBonus lottoBonus, Amount amount) {
        rankCounter = new ArrayList<>();
        winningMoney = 0;

        for (int i = 0; i < 6; i++) {
            rankCounter.add(0);
        }

        makeResult(lottosPurchased, winningLotto, lottoBonus);
        rateOfReturn = getRateOfReturn(amount);
    }

    private void makeResult(LottosPurchased lottosPurchased, Lotto winningLotto, LottoBonus lottoBonus) {
        int numberOfLottosPurchased = lottosPurchased.getNumberOfLottos();

        for (int i = 0; i < numberOfLottosPurchased; i++) {
            int rank = getRank(lottosPurchased.getLotto(i), winningLotto, lottoBonus);

            rankCounter.set(rank, rankCounter.get(rank) + 1);
            winningMoney += getMoney(rank);
        }
    }

    private int getRank(Lotto lotto, Lotto winningLotto, LottoBonus lottoBonus) {
        int winningInLotto = lotto.countMatchingWith(winningLotto);
        boolean bonusInLotto = lotto.contains(lottoBonus);

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

    private int getMoney(int rank) {
        if (rank == 1) {
            return 2000000000;
        } else if (rank == 2) {
            return 30000000;
        } else if (rank == 3) {
            return 1500000;
        } else if (rank == 4) {
            return 50000;
        } else if (rank == 5) {
            return 5000;
        }
        return 0;
    }

    private double getRateOfReturn(Amount amount) {
        return 100.0 * winningMoney / amount.getAmount();
    }
}
