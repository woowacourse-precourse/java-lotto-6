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
}
