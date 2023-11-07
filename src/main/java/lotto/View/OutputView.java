package lotto.View;

import java.util.Map;
import lotto.Model.RandomLottos;
import lotto.Model.Rank;
import lotto.Model.Result;

public class OutputView {
    private static final String COUNTING_OF_PURCHASED_RANDOM_LOTTOS = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "\n당첨 통계";
    private static final String IS = "---";
    private static final String WINNING_RESULT = "%s - %d개\n";
    private static final String TOTAL_WINNING_RATE = "총 수익률은 %.1f%%입니다.";

    public static void printCounting(RandomLottos randomLottos) {
        System.out.printf(COUNTING_OF_PURCHASED_RANDOM_LOTTOS, randomLottos.getCounting());
    }

    public static void printNumbers(RandomLottos randomLottos) {
        randomLottos.getRandomLottos().forEach(System.out::println);
    }

    public static void printWinningResult(Result result) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(IS);
        Map<Rank, Integer> winningRankAndCounting = result.getWinningRankAndCounting();
        for (Rank winningRank : winningRankAndCounting.keySet()) {
            if(isNone(winningRank)) continue;
            System.out.printf(WINNING_RESULT, Rank.getMessage(winningRank), winningRankAndCounting.get(winningRank));
        }
    }

    public static void printWinningRate(double winningRate) {
        System.out.printf(TOTAL_WINNING_RATE, winningRate);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private static boolean isNone(Rank winningRank) {
        return winningRank == Rank.NONE;
    }
}





