package lotto.view;

import lotto.model.Lotto;

import java.math.BigDecimal;
import java.util.List;

public class InterfaceView {
    public static void priceInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void purchaseCheckingMessage(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void winningNumberInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(List<Integer> matchCounts) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + matchCounts.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts.get(4) + "개");
    }

    public static void printProfitRate(BigDecimal profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate.doubleValue());
    }
}
