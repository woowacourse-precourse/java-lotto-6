package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoValue;

public class LottoStore {
    public Lottos buyLottos(int money) {
        int lottoNumber = money / LottoValue.AMOUNT_UNIT.getValue();
        return createLottos(lottoNumber);
    }

    private Lottos createLottos(int lottoNumber) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < lottoNumber; i++) {
            lottos.addLotto(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(LottoValue.MIN_RANGE.getValue(),
                        LottoValue.MAX_RANGE.getValue(),
                        LottoValue.NUMBERS_COUNT.getValue())
        );
    }
}
