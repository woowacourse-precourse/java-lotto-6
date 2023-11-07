package lotto.View;

import java.util.Map;
import lotto.Model.RandomLottos;
import lotto.Model.Rank;
import lotto.Model.Result;

public class OutputView {

    public static void printRandomLottosNumberAndCounting(RandomLottos lottos) {
        System.out.println(lottos.getCounting() + "개를 구매했습니다.");
        lottos.getRandomLottos().forEach(System.out::println);
    }

    public static void printWinningResult(Result result) {
        Map<Rank, Integer> results = result.getRankAndCounting();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : results.keySet()) {
            if(rank.compareTo(Rank.NONE) == 0) continue;
            System.out.println(Rank.getMessage(rank) + " - " + results.get(rank) + "개");
        }
    }

    public static void printWinningRate(double winningRate) {
        System.out.println("총 수익률은 " + winningRate+"%입니다.");
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}





