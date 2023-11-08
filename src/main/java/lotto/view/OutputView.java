package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningDetails;

public class OutputView {
    public static void outputPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void outputPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void outputResult(Map<WinningDetails, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.get(WinningDetails.THREE_MATCH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(WinningDetails.FOUR_MATCH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(WinningDetails.FIVE_MATCH) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(WinningDetails.FIVE_WITH_BONUS_MATCH) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(WinningDetails.SIX_MATCH) + "개");
    }

    public static void outputProfitRatio(String profitRatio) {
        System.out.println("총 수익률은 " + profitRatio + "% 입니다.");
    }

}