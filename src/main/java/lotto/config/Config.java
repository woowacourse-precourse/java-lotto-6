package lotto.config;

import lotto.domain.lotto.Lotto;
import lotto.domain.num.RanNumbers;

public class Config {
    public static Lotto lotto() {
        return new Lotto(RanNumbers.createLottoNumbers());
    }
}
