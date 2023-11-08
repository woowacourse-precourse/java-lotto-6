package lotto.util;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;

public class ProfitCalculator {
    private static final int UNIT = 1000;
    RankCalculator rankCalculator;
    List<Lotto> lottos;

    public ProfitCalculator(RankCalculator rankCalculator, List<Lotto> lottos) {
        this.rankCalculator = rankCalculator;
        this.lottos = lottos;
    }

    public String getLottoProfit(Lotto winningLotto, int bonusNumber) {
        double profit = calculateProfitPercentage(winningLotto, bonusNumber);

        return formatProfitPercentage(profit);
    }

    public double calculateProfitPercentage(Lotto winningLotto, int bonusNumber) {
        int lottoReturn = 0;
        Winning[] winnings = Winning.values();
        for (int i = 0; i < winnings.length; i++) {
            Winning winning = winnings[winnings.length - i - 1];
            int winningCount = rankCalculator.countWinningLotto(winning, winningLotto, bonusNumber);
            lottoReturn += winningCount * winning.prize();
        }
        int price = lottos.size() * UNIT;

        return (double) lottoReturn / price;
    }

    public String formatProfitPercentage(double profit) {
        double profitPercent = profit;
        DecimalFormat decimalFormat = new DecimalFormat("0.0%");
        return decimalFormat.format(profitPercent);
    }
}
