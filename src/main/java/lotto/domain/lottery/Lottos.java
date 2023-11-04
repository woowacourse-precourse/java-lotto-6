package lotto.domain.lottery;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final int ticketCount) {
        List<Lotto> lottos = Stream.generate(Lotto::create)
                .limit(ticketCount)
                .toList();

        this.lottos = lottos;
    }

    public static Lottos publishTickets(final int ticketCount) {
        return new Lottos(ticketCount);
    }
}
