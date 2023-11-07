package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> packOfLotteryTickets;

    private Lottos(List<Lotto> packOfLotteryTickets) {
        this.packOfLotteryTickets = Collections.unmodifiableList(packOfLotteryTickets);
    }

    public static Lottos of(final Quantity totalLotteries, final LottoGenerator generator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < totalLotteries.getAmount(); i++) {
            lottos.add(new Lotto(generator.generate()));
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getPackOfLotteryTickets() {
        return packOfLotteryTickets;
    }
}
