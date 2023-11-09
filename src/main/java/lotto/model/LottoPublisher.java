package lotto.model;

import java.util.List;
import java.util.stream.Stream;

public class LottoPublisher {

    private final LottoGenerator generator;

    public LottoPublisher(final LottoGenerator generator) {
        this.generator = generator;
    }

    public List<Lotto> publish(final Money money) {
        return Stream.generate(generator::generate)
                .limit(money.calculateTicketCount())
                .toList();
    }
}
