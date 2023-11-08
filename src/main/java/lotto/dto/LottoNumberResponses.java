package lotto.dto;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.Lottos;

import java.util.List;

public record LottoNumberResponses(
        int purchaseCount,
        List<LottoNumberResponse> lottoResponses
) {
    public static LottoNumberResponses build(
            final Buyer buyer,
            final Lottos lottos
    ) {
        int ticketCount = buyer.getTicketCount();

        List<Lotto> lottoTickets = lottos.getLottoTickets();
        List<LottoNumberResponse> lottoResponses =
                lottoTickets.stream()
                        .map(LottoNumberResponse::build)
                        .toList();

        return new LottoNumberResponses(ticketCount, lottoResponses);
    }
}
