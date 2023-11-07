package lotto.fixture;

import lotto.model.Lotto;
import lotto.model.Number;
import lotto.model.WinningLotto;

public class WinningLottoFixture {

    public static WinningLotto create(final String lotto, final String bonus) {
        return new WinningLotto(Lotto.fromInput(lotto), Number.from(bonus));
    }
}
