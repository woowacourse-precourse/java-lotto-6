package lotto.view;

import java.util.Map;
import lotto.Lotto;
import lotto.model.Rank;

public class OutputView {
    public void exception(String message) {
        System.out.println(message);
    }

    public void lottoBuyHistory(Lotto[] lottos) {
        System.out.println(lottos.length + "개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void statistics(Map<Rank, Integer> result, double profitRate) {
        System.out.println("당첨 통계\n---");
        for(int i = Rank.values().length - 2; i > 0; i--) {
            Rank rank = Rank.values()[i];
            System.out.println(rank.getMessage() + " - " + result.get(rank) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
