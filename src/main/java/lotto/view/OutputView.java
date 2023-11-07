package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.enums.OutputMessage;
import lotto.enums.WinningRank;

public class OutputView {
    public static void printPaySuccessMessageMessage(int lotteCount) {
        System.out.println();
        System.out.println(lotteCount + OutputMessage.PAY_SUCCESS_MESSAGE.getMessage());
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            System.out.print("[");
            lotto.printNumbers();
            System.out.println("]");
        });

    }

    public static void printWinningStatisticsMessage() {
        System.out.println(OutputMessage.WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println("---");
    }

    public static void printWinningStatistics(HashMap<WinningRank, Integer> winningStatistics) {
        System.out.println(
                OutputMessage.WINNING_RANK_FIFTH_MESSAGE.getMessage() + winningStatistics.get(WinningRank.FIFTH)
                        + OutputMessage.COUNT_UNIT_MESSAGE.getMessage());
        System.out.println(
                OutputMessage.WINNING_RANK_FOURTH_MESSAGE.getMessage() + winningStatistics.get(WinningRank.FOURTH)
                        + OutputMessage.COUNT_UNIT_MESSAGE.getMessage());
        System.out.println(
                OutputMessage.WINNING_RANK_THIRD_MESSAGE.getMessage() + winningStatistics.get(WinningRank.THIRD)
                        + OutputMessage.COUNT_UNIT_MESSAGE.getMessage());
        System.out.println(
                OutputMessage.WINNING_RANK_SECOND_MESSAGE.getMessage() + winningStatistics.get(WinningRank.SECOND)
                        + OutputMessage.COUNT_UNIT_MESSAGE.getMessage());
        System.out.println(
                OutputMessage.WINNING_RANK_FIRST_MESSAGE.getMessage() + winningStatistics.get(WinningRank.FIRST)
                        + OutputMessage.COUNT_UNIT_MESSAGE.getMessage());
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
