package lotto.view;

import lotto.domain.Rank;

public class ResultView {
    public static void printResultView() {
        for (Rank rank : Rank.values()) {
            if (rank.name().equals("LOSE")) {
                continue;
            }
            System.out.println(rank.getMessage() + rank.getCount() + "개");
        }
    }

    public static void printRateView(String rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
