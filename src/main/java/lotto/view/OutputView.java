package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    public static void showResult(Map<Rank, Integer> result, double rate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        rankResult(result);
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    private static void rankResult(Map<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            if (rank.getCount() == 0) {
                continue;
            }
            if (rank.equals(Rank.SECOND)) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                        rank.getCount(), rank.getText(), result.getOrDefault(rank, 0));
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getCount(), rank.getText(),
                    result.getOrDefault(rank, 0));
        }
    }

    public static void showBundle(List<Lotto> bundle) {
        System.out.println(bundle.size() + "개를 구매했습니다.");
        for (Lotto lotto : bundle) {
            System.out.println(lotto.toString());
        }
    }
}