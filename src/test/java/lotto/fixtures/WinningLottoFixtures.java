package lotto.fixtures;

import java.util.List;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.WinningLotto;

public class WinningLottoFixtures {


    public static WinningLotto createWinningLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);

        return new WinningLotto(lotto, bonusNumber);
    }
}
