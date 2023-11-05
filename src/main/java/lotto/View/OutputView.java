package lotto.View;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE_MESSAGE = "---";

    public static void printLottoAmount(int purchaseAmount) {

        System.out.println(purchaseAmount + LOTTO_AMOUNT_MESSAGE);
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printMatchingCounts(int[] matchingCounts, boolean hasBonus) {
        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(LINE_MESSAGE);

        for (int i = 3; i <= 6; i++) {
            String winningResult = matchingCountResult(i, hasBonus);
            int count = matchingCounts[i];
            System.out.printf("%s 일치 (%d개)%n", winningResult, count);
        }
    }

    private static String matchingCountResult(int matchingCount, boolean hasBonus) {

        if (matchingCount == 6) {
            return "6개";
        } else if (matchingCount == 5 && hasBonus) {
            return "5개 일치, 보너스 볼 일치";
        } else if (matchingCount == 5) {
            return "5개";
        } else if (matchingCount == 4) {
            return "4개";
        } else if (matchingCount == 3) {
            return "3개";
        }
        return "";

    }
    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.%n", profitRate);
    }
}



