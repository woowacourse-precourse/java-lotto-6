package lotto.domain.lottery;

import lotto.domain.prize.MatchingResult;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeRank;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottoTickets;

    // Constructor
    private Lottos(final Buyer buyer) {
        final int ticketCount = buyer.getTicketCount();

        this.lottoTickets = generateLottos(ticketCount);
    }

    // Static Factory Method
    public static Lottos create(final Buyer buyer) {
        return new Lottos(buyer);
    }

    // Utility Method
    private List<Lotto> generateLottos(final int ticketCount) {
        List<List<Integer>> generatedLottoNumbers = generateRandomNumbers(ticketCount);

        return generatedLottoNumbers
                .stream()
                .map(Lotto::new)
                .toList();
    }

    private static List<List<Integer>> generateRandomNumbers(final int ticketCount) {
        return Stream.generate(LottoService::generateOrderedLottoNumbers)
                .limit(ticketCount)
                .toList();
    }

    public PrizeRank generatePrizeResult(final Prize prize) {
        List<MatchingResult> results = generateMatchingResult(prize);

        return PrizeRank.from(results);
    }

    private List<MatchingResult> generateMatchingResult(final Prize prize) {
        return lottoTickets.stream()
                .map(lotto -> MatchingResult.of(lotto, prize))
                .toList();
    }

    // Getter
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
