package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final static int LOTTO_GENERATE_START_SIZE = 0;
    private final static int BUY_AMOUNT_DIVIDE_TO_COUNT = 1000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int buyAmount) {
        return new Lottos(createLottos(buyAmount));
    }

    public static List<Lotto> createLottos(int buyAmount) {
        List<Lotto> lottos = IntStream.range(LOTTO_GENERATE_START_SIZE, buyAmount / BUY_AMOUNT_DIVIDE_TO_COUNT)
                .mapToObj(i -> new Lotto(Generator.createNumbers())).collect(
                        Collectors.toList());
        return lottos;
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
