package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoSet {
    private final Set<Lotto> lottos;

    public LottoSet(Set<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Set<Lotto> getLottos() {
        return lottos;
    }

    public static LottoSet generateRandomLottoSetSizeWith(int size) {
        Set<Lotto> randomLottos = new HashSet<>();
        for (int i = 0; i < size; i++) {
            randomLottos.add(Lotto.generateRandom());
        }

        return new LottoSet(randomLottos);
    }

}
