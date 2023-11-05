package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class SystemController {
    private SystemController() {

    }

    public static SystemController create() {
        return new SystemController();
    }

    public void doLotto() {
        try {
            Money.createManual();
        } catch (Exception e) {
            OutputView.exceptionMessage(e);
            doLotto();
        }
    }
}
