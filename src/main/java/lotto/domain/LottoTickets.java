package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoTickets {
    private int money;
    private int ticketCount;
    private List<Lotto> Tickets = new ArrayList<>();

    public LottoTickets(int money) {
        ticketCount = TicketCount(money);
        makeLottoTickets();
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public List<Lotto> getTickets() {
        return Tickets;
    }

    private static int TicketCount(int money) {
        return money / 1000;
    }

    private void makeLottoTickets() {
        for (int i = 0; i < ticketCount; i++) {
            Tickets.add(new Lotto(LottoNumbersGenerator.generate()));
        }
    }
}
