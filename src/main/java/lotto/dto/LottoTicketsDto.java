package lotto.dto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTickets;

public record LottoTicketsDto(int quantity, List<Lotto> lottoTickets) {
    public LottoTicketsDto(LottoTickets lottoTickets) {
        this(lottoTickets.getQuantity(), lottoTickets.getLottoTickets());
    }
}
