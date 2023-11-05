package lotto.View;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class ConsoleOutput {
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.print("[");
            for (int i = 0; i < numbers.size(); i++) {
                System.out.print(numbers.get(i));
                if (i < numbers.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void printWinningResults(List<Rank> ranks, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");

        String[] prizeNames = {
                "3개 일치 (5,000원)",
                "4개 일치 (50,000원)",
                "5개 일치 (1,500,000원)",
                "5개 일치, 보너스 볼 일치 (30,000,000원)",
                "6개 일치 (2,000,000,000원)"
        };

        for (int i = 0; i < ranks.size(); i++) {
            Rank rank = ranks.get(i);
            if (rank.getCount() > 0) {
                System.out.printf("%s - %d개%n", prizeNames[i], rank.getCount());
            }
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public static void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
