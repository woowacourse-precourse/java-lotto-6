package lotto.domain.lottery;

import lotto.domain.prize.MatchingResult;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeRank;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottoTickets;

    private Lottos(final Buyer buyer) {
        final int ticketCount = buyer.getTicketCount();
        this.lottoTickets = generateLottos(ticketCount);
    }

    public static Lottos create(final Buyer buyer) {
        return new Lottos(buyer);
    }

    public PrizeRank generatePrizeResult(Prize prize) {
        List<MatchingResult> results = lottoTickets.stream()
                .map(lotto -> MatchingResult.of(lotto, prize))
                .toList();
        return PrizeRank.from(results);
    }

    private List<Lotto> generateLottos(final int ticketCount) {
        return Stream.generate(LottoService::generateOrderedLottoNumbers)
                .limit(ticketCount)
                .toList()

                .stream()
                .map(Lotto::new)
                .toList();
    }


    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
