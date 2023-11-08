package lotto.view;

import static lotto.global.validator.Validator.*;
import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnMessage;

public final class CostRequestView {
    private static final String COST_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";

    public static Integer request() {
        printlnMessage(COST_REQUEST_MESSAGE);
        String cost = Validator.validate(enterMessage());
        return Integer.parseInt(cost);
    }

    private static class Validator {
        private static String validate(String cost) {
            validateNumber(cost);
            return cost;
        }
    }
}
