package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {

    public LottoPurchase() {
    }

    public static List<Lotto> purchasedLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new LottoGenerator().generateLotto();
            lottos.add(lotto);
        }
        return lottos;
    }
}
