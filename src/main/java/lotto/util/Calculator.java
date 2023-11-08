package lotto.util;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.io.OutputHandler;

public class Calculator {
    RankCalculator rankCalculator;
    ProfitCalculator profitCalculator;

    public Calculator(List<Lotto> lottos) {
        rankCalculator = new RankCalculator(lottos);
        profitCalculator = new ProfitCalculator(rankCalculator, lottos);
    }


    public void printResult(Lotto winningLotto, int bonusNumber) {
        OutputHandler.printLottoResult(getLottoResult(winningLotto, bonusNumber));
        OutputHandler.printLottoProfit(profitCalculator.getLottoProfit(winningLotto, bonusNumber));
    }

    public String getLottoResult(Lotto winningLotto, int bonusNumber) {
        return getResults(winningLotto, bonusNumber);
    }


    private String getResults(Lotto winningLotto, int bonusNumber) {
        String result = "";
        Winning[] winnings = Winning.values();
        for (int i = 0; i < winnings.length; i++) {
            Winning winning = winnings[winnings.length - i - 1];
            result += getResult(winning, winningLotto, bonusNumber) + "\n";
        }
        return result;
    }

    public String getResult(Winning winning, Lotto winningLotto, Integer bonusNumber) {
        int sameNumberCount = winning.count();
        String prize = formatNumberWithCommas(winning.prize());

        int count = rankCalculator.countWinningLotto(winning, winningLotto, bonusNumber);
        if (winning == Winning.SECOND) {
            return sameNumberCount + "개 일치, 보너스 볼 일치 (" + prize + "원) - " + count + "개";
        }
        return sameNumberCount + "개 일치 (" + prize + "원) - " + count + "개";
    }

    public String formatNumberWithCommas(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
}
