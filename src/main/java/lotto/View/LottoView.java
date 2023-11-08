package lotto.View;

import lotto.Model.Lotto;

import java.util.List;
import java.util.Map;

public class LottoView {
    public void displayLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayWinningStatistics(Map<Integer, Integer> statistics, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.getOrDefault(5000, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.getOrDefault(50000, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.getOrDefault(1500000, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.getOrDefault(30000000, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.getOrDefault(2000000000, 0) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }


    public void displayError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
