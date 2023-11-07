package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchaseAmountRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int LottoCount) {
        System.out.print(LottoCount + "개를 구매했습니다.\n");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printAnswerNumberRequest() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberRequest() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResult() {
        System.out.println("당첨 통계\n---");
    }

    public static void printResults(Map<LottoResult, Integer> results) {
        for (LottoResult result : LottoResult.values()) {
            if (result != LottoResult.NON_WINNING) {
                int winCount = results.getOrDefault(result, 0);
                System.out.println(result.getResultDescription() + " - " + winCount + "개");
            }
        }
    }

    public static void printIncome(double lottoIncome) {
        System.out.print("총 수익률은 " + String.format("%.1f", lottoIncome) + "%입니다.\n");
    }

    public static void printNextLine() {
        System.out.print("\n");
    }
}
