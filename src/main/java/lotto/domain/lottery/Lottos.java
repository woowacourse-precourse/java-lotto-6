package lotto.domain.lottery;

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

    private List<Lotto> generateLottos(final int ticketCount) {
        return Stream.generate(LottoService::generateOrderedLottoNumbers)
                .limit(ticketCount)
                .toList()

                .stream()
                .map(Lotto::new)
                .toList();
    }

    public List<Integer> generatePrizeResult(Lotto comparableNumbers) {
        return lottoTickets.stream()
                .map(lotto -> lotto.countSameNumberCount(comparableNumbers))
                .toList();
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
