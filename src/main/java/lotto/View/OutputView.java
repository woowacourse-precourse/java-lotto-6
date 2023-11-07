package lotto.View;

import java.util.Map;
import lotto.Model.RandomLottos;
import lotto.Model.Rank;
import lotto.Model.Result;

public class OutputView {
    private static final String COUNTING_OF_PURCHASED_RANDOM_LOTTOS = "%d개를 구매했습니다.\n";
    public static void printCounting(RandomLottos randomLottos) {
        System.out.printf(COUNTING_OF_PURCHASED_RANDOM_LOTTOS, randomLottos.getCounting());
    }

    public static void printNumbers(RandomLottos randomLottos) {
        randomLottos.getRandomLottos().forEach(System.out::println);
    }

    public static void printWinningResult(Result result) {
        newLine();
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Rank, Integer> winningResults = result.getWinningRankAndCounting();
        for (Rank winningRank : winningResults.keySet()) {
            if(isNot(winningRank)) continue;
            System.out.println(Rank.getMessage(winningRank) + " - " + winningResults.get(winningRank) + "개");
        }
    }

    public static void printWinningRate(double winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private static boolean isNot(Rank winningRank) {
        return winningRank.compareTo(Rank.NONE) == 0;
    }
}





