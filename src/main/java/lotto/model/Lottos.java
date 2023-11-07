package lotto.model;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private Lottos(final Lotto... lottos) {
        this.lottos = List.of(lottos);
    }

    public static Lottos from(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos of(final Lotto... lottos) {
        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }
}
