package lotto.model;

import java.util.Arrays;
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
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchedNumber(winningNumber.getWinningNumber());
            boolean isBonus = lotto.hasNumber(winningNumber.getBonusNumber());

            rank = Rank.valueOf(matchCount);
            if (!isBonus && rank == Rank.SECOND) {
                rank = Rank.THIRD;
            }

            lottoResult.addRank(rank);
        }
        return lottoResult;
    }

    public double getYield() {
        return calculateYield();
    }

    private double calculateYield() {
        double investmentAmount = user.getPurchaseAmount();
        double totalPrize = calculateTotalPrize();
        return totalPrize / investmentAmount * 100;
    }

    private long calculateTotalPrize() {
        return Arrays.stream(Rank.values())
                .mapToLong(rank -> lottoResult.getRankCount(rank) * rank.getPrizeMoney())
                .sum();
    }
}
