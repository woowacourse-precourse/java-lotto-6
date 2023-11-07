package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.MatchResult;
import lotto.model.OutputByRank;
import lotto.model.PurchasePrice;

public class OutputView {
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final int ADJUST_EARNING_RATE = 100;

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLottos(Lottos lottos) {
        printEmptyLine();
        System.out.printf("%d개를 구매했습니다.\n",lottos.count());
        for (Lotto lotto : lottos.get()) {
            System.out.println(lotto.getSortedNumbers());
        }
        printEmptyLine();
    }

    public static void printMatchResult(MatchResult matchResult) {
        OutputByRank[] outputByRanks = OutputByRank.values();
        printEmptyLine();
        System.out.println(RESULT_MESSAGE);
        System.out.println(DIVIDING_LINE);
        for (int idx = 0; idx < outputByRanks.length; idx++) {
            System.out.print(outputByRanks[idx].getOutput());
            System.out.printf("%d개",matchResult.getMatchCountByRank()[idx]);
            printEmptyLine();
        }
    }

    public static void printEarningsRate(MatchResult matchResult, PurchasePrice purchasePrice) {
        double earningRate = matchResult.getSumOfPrizeMoney()/purchasePrice.getPrice()*ADJUST_EARNING_RATE;
        System.out.printf("총 수익률은 %.1f%%입니다",earningRate);
    }
}
