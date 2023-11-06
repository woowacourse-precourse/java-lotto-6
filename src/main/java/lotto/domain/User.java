package lotto.domain;

import java.util.List;

public class User {

    public Integer lottoCount;
    public List<Lotto> lottos;

    public void purchaseLotto(Money money) {
        lottoCount = money.countThousand();
        lottos = LottoGenerator.createLottos(lottoCount);
    }
}

