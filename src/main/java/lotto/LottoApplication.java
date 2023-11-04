package lotto;

import lotto.view.InputMessageView;
import lotto.view.MoneyInputView;

public class LottoApplication {



    public void run() {
        String money = getMoneyFromUserInput();
    }

    private String getMoneyFromUserInput() {
        InputMessageView.printMoneyInputMessage();
        return MoneyInputView.input();
    }
}
