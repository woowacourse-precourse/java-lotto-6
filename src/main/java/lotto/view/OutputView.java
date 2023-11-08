package lotto.view;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import lotto.domain.WinningRule;

public class OutputView {
    public static void showLottoQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void showPurchaseLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void showWinningStatisticsMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void showWinningResult(HashMap<WinningRule, Integer> results, WinningRule rank) {
        if (rank.equals(WinningRule.SECOND_PRIZE)) {
            System.out.println(rank.getMatchingNumbers() + "개 일치, 보너스 볼 일치 " + "(" + rank.getConvertPrize()+ "원) - " + results.get(rank) + "개");
            return;
        }
        System.out.println(rank.getMatchingNumbers() + "개 일치 " + "(" + rank.getConvertPrize()+ "원) - " + results.get(rank) + "개");
    }

     public static void showReturnRate(double returnRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        String formattedReturnRate = decimalFormat.format(returnRate);
        System.out.println("총 수익률은 " + formattedReturnRate + "%입니다.");
     }

     public static void printNewLine() {
        System.out.println();
     }
}
