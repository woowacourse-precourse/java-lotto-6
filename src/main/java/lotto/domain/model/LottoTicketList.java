package lotto.domain.model;

import java.util.Collections;
import java.util.List;

public class LottoTicketList {
    private final List<LottoTicket> lottoTickets;

    public LottoTicketList(List<LottoTicket> ticket) {
        this.lottoTickets = Collections.unmodifiableList(ticket);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public Integer getNumberOfTickets(){
        return this.lottoTickets.size();
    }

    @Override
    public String toString() {
        StringBuilder totalOut = new StringBuilder();
        lottoTickets.forEach(element -> totalOut
                .append(element.toString())
                .append("\n"));
        return totalOut.toString();
    }
}
