package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Util;
import lotto.model.Rank;

public class OutputView {
    public void exception(String message) {
        System.out.println(message);
    }

    public void lottoBuyHistory(List<Lotto> lottos) {
        Util util = new Util();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            util.sortNaturalOrder(numbers);
            System.out.println(numbers);
        }
    }

    public void statistics(Map<Rank, Integer> result, double profitRate) {
        System.out.println("당첨 통계\n---");
        for (int i = Rank.values().length - 2; i >= 0; i--) {
            Rank rank = Rank.values()[i];
            System.out.println(rank.getMessage() + " - " + result.get(rank) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
