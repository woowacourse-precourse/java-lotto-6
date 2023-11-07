package lotto.view;

import lotto.domain.model.Lotto;

import java.util.List;

public class OutputView {

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        for (int i = 0; i < purchasedLotto.size(); i++) {
            System.out.println(purchasedLotto.get(i).getLotto());
        }
    }

    public static void printTotalResult(int fifth, int fourth, int third, int second, int first) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }
}
