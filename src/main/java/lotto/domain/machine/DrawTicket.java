package lotto.domain.machine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class DrawTicket {
    public static List<Lotto> tickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        while (tickets.size() < ticketCount) {
            tickets.add(ticket());
        }
        return tickets;
    }

    private static Lotto ticket() {
        return new Lotto(DrawTicketNumber.drawLottoTicket());
    }
}
