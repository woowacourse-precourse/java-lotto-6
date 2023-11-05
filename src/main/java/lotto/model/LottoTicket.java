package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Number> ticket;

    public LottoTicket(List<Number> ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "[" + ticket.stream()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

}
