package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.NumberGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(final int buyCount, final NumberGenerator numberGenerator) {
        List<Lotto> lottos = new ArrayList<>(buyCount);
        for (int count = 0; count < buyCount; count++) {
            List<Integer> randomNumbers = numberGenerator.generateSortedList();
            lottos.add(Lotto.fromIntegerList(randomNumbers));
        }

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
