package lotto;

import lotto.domain.factory.RandomLottoFactory;
import lotto.domain.lotto.LottoFactory;

class Configuration {

    public static LottoFactory lottoFactory() {
        return new RandomLottoFactory();
    }
}
