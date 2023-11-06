package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.PrintMessage;

import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoList(List<Lotto> lottoList, int numberOfLotto) {;
        printMessage("\n" + numberOfLotto + PrintMessage.PRINT_NUMBER_OF_PURCHASES);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> map, double yield) {
        printMessage(PrintMessage.PRINT_WINNING_STATISTICS);
        for (LottoRank rank : LottoRank.values()) {
            printRank(rank, map);
        }
        printYield(yield);
    }

    public static void printRank(LottoRank rank, Map<LottoRank, Integer> map) {
        if (rank.equals(LottoRank.SECOND_PLACE)) {
            System.out.printf(PrintMessage.PRINT_SECOND_RANK,
                    rank.getRightCnt(), rank.getAmountStr(), map.get(rank));
            return;
        }
        System.out.printf(PrintMessage.PRINT_RANK, rank.getRightCnt(), rank.getAmountStr(), map.get(rank));
    }

    public static void printYield(double yield) {
        System.out.printf(PrintMessage.PRINT_YIELD, yield);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
