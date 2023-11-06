package lotto.view;

import java.util.List;
import lotto.dto.LottoTicket;

public class OutputView {

    public static void printTickets(List<LottoTicket> tickets) {
        System.out.printf(ViewConstant.LOTTO_COUNT_MESSAGE.toString(), tickets.size());
        tickets.forEach(OutputView::printTicket);
    }

    private static void printTicket(LottoTicket ticket) {
        System.out.printf(ViewConstant.TICKET_MESSAGE.toString(), ticket);
    }

}
