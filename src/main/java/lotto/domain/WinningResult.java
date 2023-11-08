package lotto.domain;


import java.util.Arrays;
import java.util.List;

public class WinningResult {

    private final LottoNumbers lottoNumbers;
    private final NumberOfRanks numberOfRanks;

    public WinningResult(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.numberOfRanks = NumberOfRanks.count();
    }

    public NumberOfRanks getWinningResult(List<Lotto> drawnLottoNumbers, WinningNumber winningNumber) {
        return countRanks(drawnLottoNumbers, winningNumber);
    }

    private NumberOfRanks countRanks(List<Lotto> drawnLottoNumbers, WinningNumber winningNumber) {
        Rank rank;
        for (Lotto lotto : drawnLottoNumbers) {
            int matchCount = lotto.countMatch(winningNumber.getWinningNumber());
            boolean matchBonus = lotto.containNumber(winningNumber.getBonusNumber());
            rank = Rank.valueOf(matchCount, matchBonus);
            numberOfRanks.addRank(rank);
        }
        return numberOfRanks;
    }

    public double getReturn() {
        return calculateReturn();
    }

    private double calculateReturn() {
        double purchasedAmount = lottoNumbers.getPurchaseAmount();
        double totalPrize = calculateTotalPrize();
        return totalPrize / purchasedAmount * 100;
    }

    private long calculateTotalPrize() {
        return Arrays.stream(Rank.values())
                .mapToLong(rank -> numberOfRanks.getRankCount(rank) * rank.getPrizeMoney())
                .sum();
    }
}
