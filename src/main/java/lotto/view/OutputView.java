package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningYield;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void displayLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void displayWinningDetails(List<Rank> ranks, WinningYield winningYield) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        List<Rank> reversedRanks = new ArrayList<>(Arrays.asList(Rank.values()));
        Collections.reverse(reversedRanks);


        for (Rank rank : reversedRanks) {
            long count = ranks.stream().filter(r -> r == rank).count();
            int matchingNumbers = rank.getMatchingNumbers();

            if (!rank.name().equals("NONE")) {
                String prizeAmountFormatted = NumberFormat.getIntegerInstance().format(rank.getPrizeAmount());
                System.out.println(matchingNumbers + "개 일치 (" + prizeAmountFormatted + "원) - " + count + "개");
            }
        }

        double yield = winningYield.getYield();
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
