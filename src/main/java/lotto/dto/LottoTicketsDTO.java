package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public record LottoTicketsDTO(int ticketAmount, List<Lotto> lottoTickets) {
    @Override
    public int ticketAmount() {
        return ticketAmount;
    }

    @Override
    public List<Lotto> lottoTickets() {
        return lottoTickets;
    }
}
