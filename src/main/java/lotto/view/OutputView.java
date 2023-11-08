package lotto.view;

import java.util.Map;
import lotto.domain.WinningDetails;

public class OutputView {
    public static void requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }


    public static void outputPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void outputPurchaseLottos(String lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void outputResult(Map<WinningDetails, Integer> winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningResult.get(WinningDetails.THREE_MATCH) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningResult.get(WinningDetails.FOUR_MATCH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningResult.get(WinningDetails.FIVE_MATCH) + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningResult.get(WinningDetails.FIVE_WITH_BONUS_MATCH) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningResult.get(WinningDetails.SIX_MATCH) + "개");
    }

    public static void outputProfitRatio(String profitRatio) {
        System.out.println("총 수익률은 " + profitRatio + "%입니다.");
    }

    public static void outputEmptyLine() {
        System.out.println();
    }

}