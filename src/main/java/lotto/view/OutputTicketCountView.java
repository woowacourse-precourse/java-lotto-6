package lotto.view;

import lotto.Ticket;

public class OutputTicketCountView {
    public static void printCountOfLotto(Ticket ticket) {
        System.out.printf(("%d개를 그매했습니다.") + "%n", ticket.countTicket());
    }
}
