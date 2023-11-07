package lotto.controller;

import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class LottoController {

    public void playLotto() {
        Money money = Money.createMoney();
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers();
    }
}
