package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public record LottoTicketsDTO(int ticketAmount, List<Lotto> lottoTickets) {
}
