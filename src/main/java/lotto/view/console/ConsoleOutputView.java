package lotto.view.console;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningResult;
import lotto.domain.WinningStatistics;
import lotto.view.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String PURCHASED_LOTTOS_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String MATCH_3_PRIZE_MESSAGE_FORMAT = "3개 일치 (%,d원) - %d개%n";
    private static final String MATCH_4_PRIZE_MESSAGE_FORMAT = "4개 일치 (%,d원) - %d개%n";
    private static final String MATCH_5_PRIZE_MESSAGE_FORMAT = "5개 일치 (%,d원) - %d개%n";
    private static final String MATCH_5_WITH_BONUS_PRIZE_MESSAGE_FORMAT = "5개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String MATCH_6_PRIZE_MESSAGE_FORMAT = "6개 일치 (%,d원) - %d개%n";
    private static final String TOTAL_PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %,.1f%%입니다.%n"; // 반올림 및 구분자


    @Override
    public void displayPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(PURCHASED_LOTTOS_COUNT_MESSAGE_FORMAT, lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> sortedLotto = lotto.getNumbers().stream().sorted().toList();
            System.out.printf("%s%n", sortedLotto);
        }
    }

    @Override
    public void displayWinningStatistics(WinningStatistics winningStatistics) {
        final WinningResult winningResult = winningStatistics.getWinningResult();
        final Map<LottoRank, Integer> resultByLottoRank = winningResult.getResultByLottoRank();
        final double profitRatio = winningStatistics.getTotalProfitRate();

        System.out.println();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDER);
        printMatchPrizeMessages(resultByLottoRank);
        System.out.printf(TOTAL_PROFIT_RATE_MESSAGE_FORMAT, profitRatio);
    }

    private void printMatchPrizeMessages(Map<LottoRank, Integer> resultByLottoRank) {
        final Map<LottoRank, String> messageFormats = new LinkedHashMap<>();
        messageFormats.put(LottoRank.FIFTH, MATCH_3_PRIZE_MESSAGE_FORMAT);
        messageFormats.put(LottoRank.FOURTH, MATCH_4_PRIZE_MESSAGE_FORMAT);
        messageFormats.put(LottoRank.THIRD, MATCH_5_PRIZE_MESSAGE_FORMAT);
        messageFormats.put(LottoRank.SECOND, MATCH_5_WITH_BONUS_PRIZE_MESSAGE_FORMAT);
        messageFormats.put(LottoRank.FIRST, MATCH_6_PRIZE_MESSAGE_FORMAT);

        messageFormats.forEach((lottoRank, messageFormat) -> {
            int count = resultByLottoRank.getOrDefault(lottoRank, 0);
            System.out.printf(messageFormat, lottoRank.getPrize(), count);
        });
    }
}
