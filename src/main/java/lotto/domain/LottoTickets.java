package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoTickets {
    private static int ticketCount;
    private static List<Lotto> Tickets = new ArrayList<>();

    public LottoTickets(int money) {
        ticketCount = TicketCount(money);
        makeLottoTickets();
    }

    public static int getTicketCount() {
        return ticketCount;
    }

    public static List<Lotto> getTickets() {
        return Tickets;
    }

    private static int TicketCount(int money) {
        return money / 1000;
    }

    private static void makeLottoTickets() {
        for (int i = 0; i < ticketCount; i++) {
            Tickets.add(new Lotto(LottoNumbersGenerator.generate()));
        }
    }
}
