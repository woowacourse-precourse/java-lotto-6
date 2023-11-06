package lotto.View;

import java.util.Map;
import lotto.Model.Lottos;
import lotto.Model.RandomLotto;
import lotto.Model.Rank;
import lotto.Model.Rate;
import lotto.Model.Result;

public class OutputView {

    public static void printLottoPurChaseMessage(RandomLotto randomLotto) {
        System.out.println();
        System.out.println(randomLotto.getCount() + "개를 구매했습니다.");
    }

    public static void printRandomLottoNumbers(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
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
}





