package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Player;

public class OutputView {
    public static void printAmount(int amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }

    public static void printLotteries(Player player) {
        for (Lotto lotto : player.generateLotteries()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult() {
        System.out.println("\n당첨 통계\n---");
    }

    public static void printTotalRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
