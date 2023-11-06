package lotto.view;

import lotto.LottoTicketsDto;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String TOTAL_TICKETS_MESSAGE = "를 구매했습니다.";
    private static final String NEW_LINE = "\n";
    public void print(String message) {
        System.out.println(message);
    }

    public void printIssuedLottoTickets(LottoTicketsDto lottoTicketsDto) {
        StringBuilder issued = new StringBuilder();
        appendTotalTickets(issued, lottoTicketsDto.getTotalTickets());
        appendLottoTickets(issued, lottoTicketsDto.getLottos());
        print(issued.toString());
    }

    private void appendTotalTickets(StringBuilder issued, Integer totalTickets) {
        issued.append(totalTickets)
                .append(TOTAL_TICKETS_MESSAGE);
    }

    private void appendLottoTickets(StringBuilder issued, List<List<Integer>> lottoTickets) {
        lottoTickets.forEach(ticket -> {
            Collections.sort(ticket);
            issued.append(ticket);
            issued.append(NEW_LINE);
        });
    }
}
