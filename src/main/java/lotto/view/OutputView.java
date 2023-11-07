package lotto.view;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {
    private static final String PURCHASED_LOTTIES_MENT = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MENT = "%s (%s원) - %d개\n";
    private static final String PROFITABILITY_MENT = "총 수익률은 %.1f%%입니다.\n";

    public void printPurchasedLotties(List<Lotto> lotties) {
        System.out.printf(PURCHASED_LOTTIES_MENT, lotties.size());
        for (int i = 0; i < lotties.size(); i++) {
            System.out.println(lotties.get(i).toString());
        }
    }

    public void printWinningStatistics(EnumMap<Rank, Integer> enumMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for (Rank rank : Rank.values()) {
            String correctNumberCount = rank.getDescription();
            int winning = rank.getPrize();
            int matchLottoCount = enumMap.getOrDefault(rank, 0);
            String winningWithComma = decimalFormat.format(winning);
            System.out.printf(WINNING_STATISTICS_MENT, correctNumberCount
                    , winningWithComma, matchLottoCount);
        }

    }

    public void printProfitability(double profitabliity) {
        System.out.println(String.format(PROFITABILITY_MENT, profitabliity));
    }
}
