package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.NumberGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int lottoCnt) {
        this.lottos = createLottos(lottoCnt);
    }

    public static Lottos numberOf(int lottoCnt) {
        return new Lottos(lottoCnt);
    }

    private List<Lotto> createLottos(int lottoCnt) {
        return IntStream.range(0, lottoCnt)
                .mapToObj(i -> new Lotto(NumberGenerator.generateNumber()))
                .collect(Collectors.toList());
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int getLottoCnt() {
        return lottos.size();
    }
}
