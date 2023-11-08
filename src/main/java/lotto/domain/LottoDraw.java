package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoDraw {
    // 전역적으로 쓰는 방법?
    private List<Lotto> lottos = new ArrayList();

    public void createLottos(Integer amount, Integer price) {
        for (int i = 0; i < amount / price; i++) {
            lottos.add(Lotto.create());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
