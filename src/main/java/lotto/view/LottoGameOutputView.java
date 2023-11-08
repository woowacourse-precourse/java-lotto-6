package lotto.view;

import lotto.constant.LottoGameConfig;
import lotto.constant.OutputViewMessages;
import lotto.constant.PrizeCalculator;
import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottoGameOutputView {
    private static final String HEADER = OutputViewMessages.LOTTO_WINNING_STATS_HEADER;
    private static final String DASH_SEPARATOR = OutputViewMessages.DASH_SEPARATOR;
    private static final String TOTAL_PROFIT_MARGIN_FORMAT = OutputViewMessages.TOTAL_PROFIT_MARGIN_FORMAT;
    private static final String WINNING_RANK_BONUS_COUNT_FORMAT = OutputViewMessages.WINNING_RANK_BONUS_COUNT_FORMAT;
    private static final String WINNING_RANK_COUNT_FORMAT = OutputViewMessages.WINNING_RANK_COUNT_FORMAT;

    public void printPurchaseLotto(User user) {
        printPurchaseLottoAmount(user.getMoney());
        printLottoNumbers(user.getLottoList());
        System.out.println();
    }

    private void printPurchaseLottoAmount(int money) {
        int ticketCount = money / LottoGameConfig.LOTTO_TICKET_PRICE_UNIT.getNumber();
        System.out.printf("%d%s%n", ticketCount, OutputViewMessages.PURCHASED_LOTTO_TICKETS);
    }

    private void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void printTotalLottoResult(Map<Integer, Integer> rankCounts, double profitMargin) {
        System.out.println(HEADER);
        System.out.println(DASH_SEPARATOR);
        printRankResults(rankCounts);
        System.out.printf(TOTAL_PROFIT_MARGIN_FORMAT, profitMargin);
    }

    private void printRankResults(Map<Integer, Integer> rankCounts) {
        for (Integer rank : rankCounts.keySet()) {
            Optional<Long> prizeMoney = PrizeCalculator.findPrizeMoney(rank);
            int rankCount = rankCounts.get(rank);
            if (rank == 50) {
                rank = 5;
                System.out.printf(WINNING_RANK_BONUS_COUNT_FORMAT,
                        rank, prizeMoney.orElse(0L), rankCount);
                continue;
            }
            System.out.printf(WINNING_RANK_COUNT_FORMAT,
                    rank, prizeMoney.orElse(0L), rankCount);
        }
    }
}
