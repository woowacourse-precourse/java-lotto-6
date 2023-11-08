package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ResultPrinter {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0%");

    public void printPurchasedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(WinningStats winningStats) {
        System.out.println("--- 당첨 통계 ---");
        System.out.println("3개 일치 (5,000원) - " + winningStats.getThreeMatchCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + winningStats.getFourMatchCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningStats.getFiveMatchCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningStats.getFiveAndBonusMatchCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningStats.getSixMatchCount() + "개");
    }

    public void printTotalEarningRate(double totalEarningRate) {
        System.out.println("총 수익률은 " + DECIMAL_FORMAT.format(totalEarningRate) + "입니다.");
    }

    public void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
