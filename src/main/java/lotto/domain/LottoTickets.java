package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(this.tickets);
    }

}
