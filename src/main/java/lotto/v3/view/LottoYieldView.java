package lotto.v3.view;

import lotto.v3.model.LottoRank;

import java.util.Map;

public class LottoYieldView {

    public void displayResults(Map<LottoRank, Integer> matchCounts, double yield) {
        matchCounts.forEach((rank, count) -> {
            if (count > 0) {
                System.out.println(rank.name() + " (" + rank.getPrizeMoney() + "원) - " + count + "개");
            }
        });

        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}

