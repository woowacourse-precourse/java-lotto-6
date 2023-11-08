package lotto.view;

import static lotto.global.validator.Validator.*;
import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnMessage;

import lotto.domain.Cost;

public final class CostRequestView {
    private static final String COST_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";

    public static Cost request() {
        printlnMessage(COST_REQUEST_MESSAGE);
        try {
            String cost = Validator.validate(enterMessage());
            return Cost.from(Integer.parseInt(cost));
        } catch (IllegalArgumentException e) {
            printlnMessage(e.getMessage());
            return request();
        }
    }

    private static class Validator {
        private static String validate(final String cost) {
            validateNumber(cost);
            return cost;
        }
    }
}
