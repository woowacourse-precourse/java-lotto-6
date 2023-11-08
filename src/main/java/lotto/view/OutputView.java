package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class OutputView {

    private static final String FIRST_RANK = "6개 일치 (2,000,000,000원)";
    private static final String SECOND_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String THIRD_RANK = "5개 일치 (1,500,000원)";
    private static final String FOURTH_RANK = "4개 일치 (50,000원)";
    private static final String FIFTH_RANK = "3개 일치 (5,000원)";

    private OutputView() {
    }

    public static void purchaseLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void winningStatistics(List winningRank, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(FIFTH_RANK + " - " + winningRank.get(5) + "개");
        System.out.println(FOURTH_RANK + " - " + winningRank.get(4) + "개");
        System.out.println(THIRD_RANK + " - " + winningRank.get(3) + "개");
        System.out.println(SECOND_RANK + " - " + winningRank.get(2) + "개");
        System.out.println(FIRST_RANK + " - " + winningRank.get(1) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn * 100);
    }
}
