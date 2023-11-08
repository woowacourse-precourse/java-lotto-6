package lotto.view;

import lotto.domain.ViewContract;

public class ConsoleView implements ViewContract {

    @Override
    public String purchaseAmount() {
        return "1000";
    }
}
