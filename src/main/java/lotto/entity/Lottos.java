package lotto.entity;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public void publishedLottoCount(Lotto lotto) {
        lottos.add(lotto);
    }
}
