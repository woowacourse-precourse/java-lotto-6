package lotto.domain.lottery;

import lotto.domain.lottery.generator.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private static final int UNIT_PRICE = 1_000;

    private final List<Lotto> lottos;

    private Lottos(final int ticketCount) {
        List<Lotto> lottos = generateLottos(ticketCount);

        this.lottos = lottos;
    }

    public static Lottos create(final int ticketCount) {
        return new Lottos(ticketCount);
    }

    private List<Lotto> generateLottos(final int ticketCount) {
        return Stream.generate(RandomNumberGenerator::generateLottoNumbers)
                .limit(ticketCount)
                .toList()

                .stream()
                .map(Lotto::new)
                .toList();
    }
}
