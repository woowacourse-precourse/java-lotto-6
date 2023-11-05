package lotto.service;

import static lotto.util.LottoGenerator.createRandomNumber;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoService {

    public Lottos generateLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        for (int count = 0; count < lottoCount; count++) {
            Lotto lotto = new Lotto(createRandomNumber());
            lottos.purchaseLotto(lotto);
        }

        return lottos;
    }
}
