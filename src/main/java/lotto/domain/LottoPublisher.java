package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public class LottoPublisher {

    private static final int UNIT = 1000;

    public Lottos publishLottosByAmount(Amount amount) {
        int lottoCount = getLottoCountByAmount(amount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(publishRandomLotto());
        }
        return new Lottos(lottos);
    }

    private int getLottoCountByAmount(Amount amount) {
        return amount.getAmount() / UNIT;
    }

    private Lotto publishRandomLotto() {
        return new Lotto(RandomNumberGenerator.createUniqueRandomNumbers());
    }

}
