package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.NumberGenerator;

public class Lottos {

    private static final int START_INDEX = 0;

    private final List<Lotto> purchasedLottos;

    private Lottos(final List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public static Lottos of(final long buyCount, final NumberGenerator numberGenerator) {
        return IntStream.range(START_INDEX, (int) buyCount)
                .mapToObj(count -> Lotto.fromNumbers(numberGenerator.generateSortedList()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    public List<Lotto> getPurchasedLottos() {
        return Collections.unmodifiableList(purchasedLottos);
    }
}
