package lotto;

import java.text.DecimalFormat;
import java.util.List;

public class LottoView {

    public void displayPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void displayPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getNumbers());
        }
    }

    public void displayWinnerNumsInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void displayBonusNumInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult(List<Integer> results, double earningRate) {
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Result.THREE.getMatchCount() + "개 일치 (" + df.format(Result.THREE.getEarnings()) + "원) - " + results.get(Result.THREE.ordinal()) + "개");
        System.out.println(Result.FOUR.getMatchCount() + "개 일치 (" + df.format(Result.FOUR.getEarnings()) + "원) - " + results.get(Result.FOUR.ordinal()) + "개");
        System.out.println(Result.FIVE.getMatchCount() + "개 일치 (" + df.format(Result.FIVE.getEarnings()) + "원) - " + results.get(Result.FIVE.ordinal()) + "개");
        System.out.println(Result.FIVE_BONUS.getMatchCount() + "개 일치, 보너스 볼 일치 (" + df.format(Result.FIVE_BONUS.getEarnings()) + "원) - " + results.get(Result.FIVE_BONUS.ordinal()) + "개");
        System.out.println(Result.SIX.getMatchCount() + "개 일치 (" + df.format(Result.SIX.getEarnings()) + "원) - " + results.get(Result.SIX.ordinal()) + "개");
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
