package lotto.model;

import java.util.HashMap;
import java.util.List;

public class LottoResult {

    private User user;
    private WinningNumber winningNumber;
    private RankCounter lottoResult;

    public LottoResult(User user, WinningNumber winningNumber) {
        this.user = user;
        this.winningNumber = winningNumber;
        this.lottoResult = RankCounter.create();
    }

    public RankCounter getLottoResult(List<Lotto> purchasedLottos, WinningNumber winningNumber) {
        return countRank(purchasedLottos, winningNumber);
    }

    private RankCounter countRank(List<Lotto> purchasedLottos, WinningNumber winningNumber) {
        Rank rank;
        for (int i=0; i<purchasedLottos.size(); i++) {
            int matchCount = countMatchedNumber(purchasedLottos.get(i), winningNumber.getWinningNumber());
            boolean isBonus = purchasedLottos.get(i).hasNumber(winningNumber.getBonusNumber());
            rank = Rank.valueOf(matchCount);
            if (!isBonus && rank == Rank.SECOND) {
                rank = Rank.THIRD;
            }
            lottoResult.addRank(rank);
        }
        return lottoResult;
    }

    private int countMatchedNumber(Lotto lotto, Lotto winningNumber) {
        int count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumber.hasNumber(number)) {
                count++;
            }
        }
        return count;
    }

    public double getYield() {
        return calculateYield();
    }

    private double calculateYield() {
        double investmentAmount = user.getPurchaseAmount();
        double totalPrize = (double) calculateTotalPrize();
        return totalPrize / investmentAmount * 100;
    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += lottoResult.getRankCount(rank) * rank.getPrizeMoney();
        }
        return totalPrize;
    }
}
