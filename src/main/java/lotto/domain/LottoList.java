package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottos;

    public LottoList(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static LottoList generateRandomLottoSetSizeWith(int size) {
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomLottos.add(Lotto.generateRandom());
        }

        return new LottoList(randomLottos);
    }

}
