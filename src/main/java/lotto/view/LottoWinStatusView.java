package lotto.view;

import java.util.List;

public class LottoWinStatusView {

    public static void displayLottoPrize(List<Integer> prize) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prize.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + prize.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prize.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prize.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prize.get(0) + "개");
    }
    public static void displayTotalProfit(long totalPrice, int buyingPrice) {
        double profit = ((double) totalPrice / buyingPrice) * 100;
        profit = Math.round(profit * 100.0) / 100.0;

        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
