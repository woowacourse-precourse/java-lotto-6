package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> tickets;

    public LottoTicket(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static LottoTicket purchase(int amount) {
        return null;
    }

}
