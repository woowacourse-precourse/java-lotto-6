package lotto.view;

import lotto.domain.Lotto;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PURCHASE_TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    
    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
    
    public void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + PURCHASE_TICKET_COUNT_MESSAGE);
    }
    
    public void printNewLine() {
        System.out.println();
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
        return ticket.getNumbers().stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
