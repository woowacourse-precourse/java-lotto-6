package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int quantity) {
        return new Lottos(
                IntStream.range(0, quantity)
                        .mapToObj(index -> Lotto.create())
                        .collect(Collectors.toList())
        );
    }

    public List<Lotto> getLotto() {
        return lottos;
    }
}
