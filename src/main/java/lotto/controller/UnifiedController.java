package lotto.controller;

import static lotto.view.SystemMessage.ASK_MONEY;

import lotto.model.Money;
import lotto.model.Register;
import lotto.view.InputView;
import lotto.view.OutputView;


public class UnifiedController {
    public void inputAndStoreMoney() {
        OutputView.printSystemMessage(ASK_MONEY);
        boolean valid = false;
        while (!valid) {
            try {
                Register.money = new Money(Long.parseLong(InputView.inputLongData()));
                valid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
