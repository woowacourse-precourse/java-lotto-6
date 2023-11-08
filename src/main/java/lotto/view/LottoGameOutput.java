package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.view.enums.LottoInterfaceMessage;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class LottoGameOutput {
    private static final String CASH_PRIZE_REGEX = "###,###";

    public static void printPurchaseLottos(List<Lotto> lottos) {
        String message = String.format(LottoInterfaceMessage.PURCHASE_COMPLETE.getMessage(), lottos.size());
        System.out.println(message);
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printWinningStatistics(LottoStatistics lottoStatistics) {
        System.out.println(LottoInterfaceMessage.WINNING_STATS_STRING.getMessage());

        StringBuilder statistics = new StringBuilder();
        Map<LottoRank, Integer> map = lottoStatistics.getWinningStatistics();
        for (LottoRank rank : LottoRank.getLottoRank()) {
            String message = String.format(LottoInterfaceMessage.WINNING_STATS.getMessage(),
                    rank.getDisplay(),
                    formatCashPrize(rank.getAmount()),
                    map.get(rank));

            statistics.append(message);
        }

        System.out.println(statistics);
    }

    private static String formatCashPrize(int prize) {
        DecimalFormat df = new DecimalFormat(CASH_PRIZE_REGEX);
        return df.format(prize);
    }
}
