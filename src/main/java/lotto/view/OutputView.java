package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PURCHASE_TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STASTISTICS_MESSAGE = "당첨 통계";
    private static final String LINE = "---";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    
    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
    
    public void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + PURCHASE_TICKET_COUNT_MESSAGE);
    }
    
    public void printTickets(List<Lotto> lottoTickets) {
        StringBuilder messageBuilder = new StringBuilder();
        for (Lotto ticket : lottoTickets) {
            List<Integer> sortedTicket = sortByAscending(ticket);
            messageBuilder.append(sortedTicket).append("\n");
        }
        System.out.println(messageBuilder);
    }
    
    private List<Integer> sortByAscending(Lotto ticket) {
        return ticket.getNumbers().stream().sorted().collect(Collectors.toCollection(LinkedList::new));
    }
    
    public void printWinningstatistics() {
        System.out.println(WINNING_STASTISTICS_MESSAGE);
        System.out.println(LINE);
        System.out.println(makeWinningStatisticsText());
    }
    
    private String makeWinningStatisticsText() {
        return Arrays.stream(Ranking.values())
                .map(ranking -> String.format("%s - %d개", ranking.getMessage(), ranking.getCount()))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }
    
    public void printNewLine() {
        System.out.println();
    }
}
