package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Number> ticket;

    public LottoTicket(List<Number> ticket) {
        this.ticket = ticket;
    }

    public List<Number> getTicket() {
        return ticket;
    }

    public boolean hasBonusNumber(Number bonusNumber) {
        return ticket.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return "[" + ticket.stream()
                .map(Number::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

}
