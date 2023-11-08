package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.constant.Rank;

public class OutputView {

    private static final String PURCHASE_NUM_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String NEWLINE = "\n";
    private static final String WINNING_STATISTIC_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String BONUS_RANK_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String DEFAULT_RANK_MESSAGE_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String TOTAL_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static void printMessage() {
        System.out.println();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoCollection = lottos.getLottoCollection();
        printMessage(String.format(PURCHASE_NUM_MESSAGE_FORMAT, lottoCollection.size()));
        lottoCollection.forEach(Lotto::printLotto);
        OutputView.printMessage();
    }


    public static void printLottoResults(LottoResults lottoResults, Money money) {
        printMessage(WINNING_STATISTIC_MESSAGE);
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NOTHING))
                .forEach(rank -> printEachResult(rank, lottoResults));
        printMessage(String.format(TOTAL_RATE_MESSAGE_FORMAT, lottoResults.getRevenueRate(money)));
    }

    private static void printEachResult(Rank rank, LottoResults lottoResults) {
        if (rank.isHasBonus()) {
            printMessage(String.format(BONUS_RANK_MESSAGE_FORMAT,
                    rank.getMatchCount(), rank.getPrice(), lottoResults.getRankCount(rank)));
            return;
        }
        printMessage(String.format(DEFAULT_RANK_MESSAGE_FORMAT,
                rank.getMatchCount(), rank.getPrice(), lottoResults.getRankCount(rank)));
    }
}
