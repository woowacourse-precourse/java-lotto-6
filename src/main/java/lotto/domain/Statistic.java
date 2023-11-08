package lotto.domain;

import static lotto.constant.Number.RANK1_PRIZE;
import static lotto.constant.Number.RANK2_PRIZE;
import static lotto.constant.Number.RANK3_PRIZE;
import static lotto.constant.Number.RANK4_PRIZE;
import static lotto.constant.Number.RANK5_PRIZE;

import java.util.HashMap;
import java.util.Map;
import lotto.view.OutputHandler;

public class Statistic {

    private final Map<Integer, Integer> rankCount = new HashMap<>();

    public Statistic() {
        rankCount.put(1, 0);
        rankCount.put(2, 0);
        rankCount.put(3, 0);
        rankCount.put(4, 0);
        rankCount.put(5, 0);
    }

    public void addRank(Integer rank) throws IllegalArgumentException {
        if (rank == null) {
            return;
        }
        Integer count = rankCount.get(rank);
        if (count != null) {
            rankCount.put(rank, count + 1);
        }
        if (count == null) {
            throw new IllegalArgumentException();
        }
    }

    public int getRank(int rank) throws IllegalArgumentException {
        Integer count = rankCount.get(rank);
        if (count == null) {
            throw new IllegalArgumentException();
        }
        return count;
    }

    public void printWinningDetails() {
        OutputHandler.showWinningDetails(getRank(1), getRank(2), getRank(3), getRank(4), getRank(5));
    }

    public void printEarningRate(long paymentPrice) {
        long winningPrize = getWinningPrize();
        double rateOfReturn = (double) winningPrize / paymentPrice;
        OutputHandler.printRateOfReturn(rateOfReturn);
    }

    public long getWinningPrize() {
        return getRank(1) * (long) RANK1_PRIZE.getNumber()
                + getRank(2) * (long) RANK2_PRIZE.getNumber()
                + getRank(3) * (long) RANK3_PRIZE.getNumber()
                + getRank(4) * (long) RANK4_PRIZE.getNumber()
                + getRank(5) * (long) RANK5_PRIZE.getNumber();
    }
}
