package lotto;

import lotto.domain.Money;
import lotto.view.InputMessageView;
import lotto.view.MoneyInputView;

public class LottoApplication {

    Money money;

    public void run() {
        String money = getMoneyFromUserInput();
    }

    private String getMoneyFromUserInput() {
        InputMessageView.printMoneyInputMessage();
        return MoneyInputView.input();
    }

    private void storeMoneyOf(String money) {
        this.money = Money.of(money);
    }
}
