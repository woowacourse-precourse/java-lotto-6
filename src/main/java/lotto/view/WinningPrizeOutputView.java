package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningChecker;
import lotto.domain.WinningNumber;

public class WinningPrizeOutputView {
    private static final String WINNING_PRIZE_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printTotalPrize(List<Lotto> lottos, WinningNumber winningNumberWithBonusNumber,
                                       int purchaseAmount) {
        long totalPrize = LottoWinningChecker.calculateTotalPrize(lottos, winningNumberWithBonusNumber);
        double totalPrizeRate = (double) totalPrize / purchaseAmount * 100;
        double roundedTotalPrizeRate = Math.round(totalPrizeRate * 10.0) / 10.0;
        System.out.printf(WINNING_PRIZE_RATE_MESSAGE, roundedTotalPrizeRate);
    }
}
