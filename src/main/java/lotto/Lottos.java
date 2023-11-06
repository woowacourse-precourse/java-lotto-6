package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos;

    public static Lottos create(Integer ticketCount) {
        List<Lotto> lottos = IntStream.range(0, ticketCount)
                .mapToObj(count -> Lotto.create())
                .toList();

        return new Lottos(lottos);
    }

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
