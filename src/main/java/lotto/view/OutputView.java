package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_BUY_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String OUTPUT_STATISTICS_MESSAGE = "당첨 통계\n---\n";

    public static void printBuyLotto(int buyCount, List<Lotto> lottos){
        System.out.println("\n"+String.format(OUTPUT_BUY_COUNT_MESSAGE, buyCount));
        for (Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }

    public static void printWinStatistics(String statistics){
        System.out.println(OUTPUT_STATISTICS_MESSAGE);
    }
}
