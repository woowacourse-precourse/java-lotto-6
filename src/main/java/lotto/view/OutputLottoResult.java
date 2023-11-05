package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.RateOnReturn;
import lotto.domain.WinningStatistics;

import java.util.Arrays;


public class OutputLottoResult {
    private static final String LOTTO_TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String NEWLINE = "\n";

    private static final String RESULT_MESSAGE = "\n당첨 통계\n" + "---";
    private static final String MATCH_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_MATCH_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public static void printTicketCount(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + LOTTO_TICKET_COUNT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printStatistics(LottoResult lottoResult, RateOnReturn rate) {
        Arrays.stream(WinningStatistics.values())
                .filter(winningStatistics -> !winningStatistics.equals(WinningStatistics.MISS_MATCH))
                .forEach(winningStatistics -> System.out.println(printMatchResultMessage(winningStatistics, lottoResult)));
        System.out.printf((OUTPUT_RATE_OF_RETURN) + NEWLINE, rate.getRate());
    }

    public static String printMatchResultMessage(WinningStatistics winningStatistics, LottoResult lottoResult) {
        if (WinningStatistics.FIVE_MATCH_AND_BONUS == winningStatistics) {
            return String.format(BONUS_MATCH_MESSAGE,
                    winningStatistics.getMatchCount(),
                    String.format("%,d", winningStatistics.getAmount()),
                    lottoResult.getLottoResultCount(winningStatistics));
        }
        return String.format(MATCH_MESSAGE,
                winningStatistics.getMatchCount(),
                String.format("%,d", winningStatistics.getAmount()),
                lottoResult.getLottoResultCount(winningStatistics));
    }
}
