package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class LottoController {

    public void playLotto() {
        Money money = Money.createMoney();
        Lottos lottos = Lottos.createLottos(money);
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers();
    }
}
