package lotto.dto;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public record LottoNumberResponses(
        int purchaseCount,
        List<LottoNumberResponse> lottoResponses
) {
    public static LottoNumberResponses buildLottoResponses(
            final Buyer buyer,
            final Lottos lottos
    ) {
        int ticketCount = buyer.getTicketCount();

        List<Lotto> lottoTickets = lottos.getLottoTickets();
        List<LottoNumberResponse> lottoResponses =
                lottoTickets.stream()
                        .map(LottoNumberResponse::buildLottoResponse)
                        .toList();

        return new LottoNumberResponses(ticketCount, lottoResponses);
    }
}
