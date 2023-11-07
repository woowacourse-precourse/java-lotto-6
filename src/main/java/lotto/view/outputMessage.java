package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class outputMessage {
    public static void buyMessage(List<Lotto> Lotteries) {
        int amount = Lotteries.size();
        System.out.println(Lotteries.size() + "개를 구매했습니다.");
        for (int i = 0; i < amount; i++) {
            Lotto lotto = Lotteries.get(i);
            System.out.println(lotto.numbers);
        }
    }

    public static void rankMessage(HashMap<Rank, Integer> map) {
        for (Rank rank : map.keySet()) {
            showRankResult(rank, map.getOrDefault(rank, 0));
        }
    }

    private static void showRankResult(Rank rank, int count) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        if (rank.equals(Rank.NONE)) {
            return;
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    rank.getCount(), decFormat.format(rank.getMoney()), count);
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getCount(), decFormat.format(rank.getMoney()), count);
    }

}
