package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.LottoGenerator;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets generateRandomLottoTickets(LottoGenerator generator, int ticket) {
        List<Lotto> lottoTickets = IntStream.range(0, ticket)
                .mapToObj(i -> generator.lottoGenerator())
                .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
