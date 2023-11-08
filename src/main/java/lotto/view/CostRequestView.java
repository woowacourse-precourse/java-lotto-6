package lotto.view;

import static lotto.global.constants.NumberType.COST_UNIT;
import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnMessage;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public final class CostRequestView {
    private static final String COST_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";

    public static Integer request() {
        printlnMessage(COST_REQUEST_MESSAGE);
        String cost = Validator.validateCost(enterMessage());
        return Integer.parseInt(cost);
    }

    private static class Validator {
        private static String validateCost(String cost) {
            validateNumber(cost);
            validateUnit(cost);
            return cost;
        }

        private static void validateNumber(String message) {
            if (isNotNumber(message)) {
                throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
            }
        }

        private static boolean isNotNumber(String message) {
            return !message.matches("\\d+");
        }

        private static void validateUnit(String cost) {
            if (isNotDivisible(cost)) {
                throw LottoException.from(ErrorMessage.INVALID_UNIT_ERROR);
            }
        }

        private static boolean isNotDivisible(String cost) {
            return Integer.parseInt(cost) % COST_UNIT.getValue() != 0;
        }
    }
}
