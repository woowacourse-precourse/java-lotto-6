package lotto.dto;

import lotto.collection.Lotto;

import java.util.List;

public class LottoTicketsDTO {
    int ticketAmount;
    List<Lotto> lottoTickets;

    public LottoTicketsDTO(int ticketAmount, List<Lotto> lottoTickets) {
        this.ticketAmount = ticketAmount;
        this.lottoTickets = lottoTickets;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
