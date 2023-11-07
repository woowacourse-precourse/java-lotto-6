package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningChecker;
import lotto.domain.WinningNumber;

public class WinningPrizeOutputView {
    public static void printTotalPrize(List<Lotto> lottos, WinningNumber winningNumber, int purchaseAmount) {
        long totalPrize = LottoWinningChecker.calculateTotalPrize(lottos, winningNumber);
        double totalPrizeRate = (double) totalPrize / purchaseAmount;
        double roundedTotalPrizeRate = Math.round(totalPrizeRate * 10.0) / 10.0;
        System.out.println("총 수익률은 " + roundedTotalPrizeRate + "%입니다.");
    }
}
