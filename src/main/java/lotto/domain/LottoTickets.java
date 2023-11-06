package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(this.tickets);
    }

    public int getSize() {
        if (Objects.isNull(this.tickets) || this.tickets.isEmpty()) {
            return 0;
        }
        return this.tickets.size();
    }

}
