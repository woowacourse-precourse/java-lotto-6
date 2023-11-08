package lotto.domain.lottoGenerateMethod;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lottoTicket.Lotto;
import lotto.domain.lottoTicket.LottoTickets;

public class LottoTicketsGenerator {

    public static LottoTicketsGenerator getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        public static final LottoTicketsGenerator INSTANCE = new LottoTicketsGenerator();
    }

    public LottoTickets generateLottoTickets(final int count, final LottoGenerateMethod lottoGenerateMethod) {
        List<Lotto> lottoTickets = IntStream.range(0, count)
                .mapToObj(i -> lottoGenerateMethod.generateLotto())
                .collect(Collectors.toList());

        return LottoTickets.of(lottoTickets);
    }
}
