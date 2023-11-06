package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoCondition;
import lotto.model.Lottos;

public class LottoService {
    private static final int MIN_NUMBER = LottoCondition.MIN_NUMBER.getNumber();
    private static final int MAX_NUMBER = LottoCondition.MAX_NUMBER.getNumber();
    private static final int COUNT = LottoCondition.COUNT.getNumber();

    public Lottos generateLottos(int lottoCount) {
        Lottos lottos = new Lottos();
        for(int i = 0; i < lottoCount; i++) {
            Lotto lotto = generateLotto();
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(
            Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER,
                MAX_NUMBER,
                COUNT)
        );
    }
}
