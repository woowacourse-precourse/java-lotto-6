package lotto;

import lotto.money.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    public void run() {
        OutputView.inputMoney();
        Money money = InputView.getMoney();
    }
}
