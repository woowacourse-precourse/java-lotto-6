package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.domain.WinningResult;

public class OutputView {
    private static final String PURCHASED_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String BOUNDARY_LINE = "---";
    private static final String WINNING_RESULT = "%d개 일치 (%s원)";
    private static final String SECOND_PRIZE_DESCRIPTION = "%d개 일치, 보너스 볼 일치 (%s원)";
    private static final String EARNING_RATE = "총 수익률은 %.1f%%입니다.";

    private OutputView() {
    }

    public static void printTickets(List<LottoTicket> tickets) {
        System.out.println();
        System.out.println(String.format(PURCHASED_LOTTO_COUNT, tickets.size()));
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket);
        }
        System.out.println();
    }

    public static void printResult(WinningResult winningResult) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(BOUNDARY_LINE);
        printPrizes(winningResult);
        System.out.println();
        System.out.println(String.format(EARNING_RATE, winningResult.getEarningRate()));
    }

    private static void printPrizes(WinningResult winningResult) {
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                printPrizeResult(prize, winningResult.searchWinningCountForPrize(prize));
            }
        }
    }

    private static void printPrizeResult(Prize prize, int count) {
        String description = generatePrizeDescription(prize);
        System.out.println(description + " - " + count + "개");
    }

    private static String generatePrizeDescription(Prize prize) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        String formattedPrizeMoney = numberFormat.format(prize.getPrizeMoney());
        String description = String.format(WINNING_RESULT, prize.getMatchedNumbers(), formattedPrizeMoney);
        if (prize == Prize.SECOND) {
            description = String.format(SECOND_PRIZE_DESCRIPTION, prize.getMatchedNumbers(), formattedPrizeMoney);
        }
        return description;
    }
}
