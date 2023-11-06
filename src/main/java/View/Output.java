package View;

import lotto.Lotto;
import lotto.Rank;
import lotto.Result;

import java.util.List;

public class Output {
    public static void printCreatedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistic(int[] rankCounter) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = Rank.FIFTH.getNumber(); i >= Rank.FIRST.getNumber(); i--) {
            System.out.printf("%s - %d개%n", Rank.of(i).getDescription(), rankCounter[i]);
        }
    }

    public static void printTotalProfit(String totalProfit) {
        System.out.printf("총 수익률은 %s%%입니다.%n", totalProfit);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
