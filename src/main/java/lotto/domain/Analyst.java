package lotto.domain;

import static lotto.domain.LottoRank.*;

public class Analyst {
    private final int lottoSize;
    private int totalIncome;

    public Analyst(int lottoSize) {
        this.lottoSize = lottoSize;
        this.totalIncome = 0;
    }

    public void addLottoResult(int winningCount, boolean bonusCount) {
        LottoRank rk = findRank(winningCount, bonusCount);
        int prize = rk.getPrize();
        rk.increaseCount();
        totalIncome += prize;
    }

    public double revenueLotto() {
        double result = ((double) totalIncome / (double) (lottoSize * LottoRole.LOTTO_PRICE.getNumber())) * 100;
        return result;
    }

    private LottoRank findRank(int winningCount, boolean bonusCount) {
        if (winningCount == 3) {
            return RANK5;
        } else if (winningCount == 4) {
            if (!bonusCount) {
                return RANK4;
            } else if (bonusCount) {
                return RANK3;
            }
        } else if (winningCount == 5) {
            return RANK2;
        } else if (winningCount == 6) {
            return RANK1;
        }
        return RANK6;
    }
}
