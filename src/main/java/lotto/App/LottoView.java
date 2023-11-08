package lotto.App;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Domain.Lotto;
import lotto.Enum.WinningType;

public class LottoView {

    public void inputBudgets() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedCnt(String purchaseCnt) {
        System.out.println("\n" + purchaseCnt + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void inputWinningLottoNormalNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void inputWinningLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningResults(Map<WinningType, Integer> winningResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        List<Map.Entry<WinningType, Integer>> results = new ArrayList<>(winningResult.entrySet());
        for (int i = results.size() - 1; i >= 0; i--) {
            Map.Entry<WinningType, Integer> entry = results.get(i);
            WinningType type = entry.getKey();
            if (type == WinningType.NONE) {
                continue;
            }
            int count = entry.getValue();
            System.out.println(type + "- " + count + "개");
        }
    }

    public void printReturnRate(double returnRate) {
        String rate = String.format("%.1f", returnRate * 100);
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
