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


}
