package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.WinnerRating;
import lotto.util.RateOfReturnCalculator;

public class OutputView {

    public static void printLottoNumbersByPurchaseAmount(List<Lotto> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getNumbersStringBySortedAsc());
        }
    }

    public static void printWinningStatistics(Map<WinnerRating, Integer> winners, int lottoPurchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winners.getOrDefault(WinnerRating.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + winners.getOrDefault(WinnerRating.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winners.getOrDefault(WinnerRating.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winners.getOrDefault(WinnerRating.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winners.getOrDefault(WinnerRating.FIRST, 0) + "개");

        Double rateOfReturn = RateOfReturnCalculator.calculateRateOfReturn(winners, lottoPurchaseAmount);
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }

}
