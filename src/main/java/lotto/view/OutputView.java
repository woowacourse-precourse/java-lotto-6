package lotto.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import lotto.domain.Rank;

public class OutputView {
    public static void buyAmount(final long amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void showResult(HashMap<Rank, Integer> result) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            System.out.println(rank.getMessage() + result.get(rank) + "개");
        }
    }

    public static void showRateOfReturn(Double rate) {
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}
