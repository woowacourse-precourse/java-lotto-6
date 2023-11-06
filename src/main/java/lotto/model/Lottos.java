package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;


    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int buyAmount) {
        List<Lotto> lottoValues = IntStream.range(0, buyAmount / 1000)
                .mapToObj(i -> new Lotto(Generator.createNumbers())).collect(
                        Collectors.toList());
        return new Lottos(lottoValues);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
