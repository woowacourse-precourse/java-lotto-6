package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constants.RankMessage;
import lotto.domain.Lotto;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE= "%d개를 구매했습니다.\n";
    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String STATISTICS_SEPARATOR = "---";
    private static final String WINNING_STATISTICS = "%d개 일치 (%,d원) - %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printTicketCount(int ticketCount) {
        String sentence = String.format(PURCHASE_COUNT_MESSAGE, ticketCount);
        System.out.println(sentence);
    }

    public void printTickets(List<Lotto> lottoTickets) {
        lottoTickets.stream()
                .map(this::sortByAscending)
                .forEach(System.out::println);
        System.out.println();
    }

    private List<Integer> sortByAscending(Lotto ticket) {
        return ticket.getNumbers().stream().sorted().collect(Collectors.toList());
    }

    public void printWinningStatistics(Map<RankMessage, Integer> winningResult) {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(STATISTICS_SEPARATOR);
        System.out.println(makeWinningStatisticsText(winningResult));
    }

    private String makeWinningStatisticsText(Map<RankMessage, Integer> winningResult) {
        return winningResult.entrySet().stream()
                .map(entry -> String.format(WINNING_STATISTICS, entry.getKey().getMessage(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }

    public void printProfitRate(double profitRate) {
        String sentence = String.format(PROFIT_RATE_MESSAGE, profitRate);
        System.out.println(sentence);
    }
}