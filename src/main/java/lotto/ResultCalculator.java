package lotto;

import java.util.List;

public class ResultCalculator {
    public WinningResult calculateWinningResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchNumbers(winningLotto);
            boolean matchBonus = lotto.contains(bonusNumber);
            result.addWinningTicket(matchCount, matchBonus);
        }
        return result;
    }

    public double calculateEarningsRate(WinningResult result, int lottoCount) {
        long totalPrize = calculateTotalPrize(result);
        long investMoney = calculateInvestMoney(lottoCount);
        return (double) totalPrize / investMoney;
    }

    private long calculateTotalPrize(WinningResult result) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;
            totalPrize += rank.getWinningMoney() * result.getCount(rank);
        }
        return totalPrize;
    }

    private long calculateInvestMoney(int lottoCount) {
        return 1000 * lottoCount;
    }
}
