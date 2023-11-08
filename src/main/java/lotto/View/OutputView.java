package lotto.View;

import java.util.HashMap;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.GameMessage;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.GameService;

public class OutputView {
    public static void printError(String message) {
        System.out.println(ErrorMessage.ERROR.getMessage() + message);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + GameMessage.BUY_COUNT.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistic() {
        System.out.println("\n" + GameMessage.RESULT.getMessage());
    }

    public static void printResult(HashMap<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            if (rank.getCount() == 0 || rank.getCount() == 1 || rank.getCount() == 2) {
                continue;
            }
            if (rank.equals(Rank.SECOND)) {
                System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(rank));
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getCount(), rank.getprizeString(), result.get(rank));
        }
    }

    public static void printRevenue(long prizeSum, int buyCount) {
        double revenue = GameService.calculateRevenue(prizeSum, buyCount * 1000);

        System.out.println("총 수익률은 " + revenue + "%입니다.");
    }
}
