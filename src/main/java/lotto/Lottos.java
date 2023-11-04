package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(Integer count) {
        return new Lottos(generateLottos(count));
    }

    public List<Lotto> getList() {
        return Collections.unmodifiableList(lottos);
    }

    private static List<Lotto> generateLottos(Integer count) {
        return Stream.generate(() ->
                        new Lotto(RandomNumberGenerator.generateUniqueNumbers()))
                .limit(count)
                .toList();
    }
}
