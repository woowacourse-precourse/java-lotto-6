package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Print {

    public void printPurchasedLottos(List<Lotto> lottos) {
        printNumbersOfLotto(lottos.size());
        for (Lotto lotto: lottos) {
            System.out.println(sort(lotto).toString());
        }
        System.out.println();
    }

    private void printNumbersOfLotto(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    List<Integer> sort(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        numbers.sort(null);
        return numbers;
    }

    public void printDrawResultStats(int money, Map<Rank, Integer> drawResult) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NO_RANK) {
                continue;
            }
            System.out.println(rank.getMessage() + drawResult.get(rank) + "개");
        }
        System.out.println("총 수익률은 " + calculateProfitRatio(money, drawResult) + "%입니다.");
    }

    String calculateProfitRatio(int money, Map<Rank, Integer> drawResult) {
        double profit = 0;
        for (Rank rank : Rank.values()) {
            profit += drawResult.get(rank) * rank.getCashPrize();
        }
        return String.format("%.1f", profit / money * 100);
    }
}
