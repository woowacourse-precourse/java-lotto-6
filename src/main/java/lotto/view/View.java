package lotto.view;

import static lotto.view.constants.MessageType.COST_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.MessageType;

public final class View {
    public static String requestCost() {
        printlnMessage(COST_REQUEST_MESSAGE);
        return Validator.validateCost(enterMessage());
    }

    /* Output View */
    private static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    /* Input View */
    private static String enterMessage() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        private static String validate(String message) {
            if (isBlank(message)) {
                throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
            }
            return message;
        }

        private static boolean isBlank(String message) {
            return message.isBlank();
        }

        public static String validateCost(String cost) {
            if (isNotNumber(cost)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
            return cost;
        }

        private static boolean isNotNumber(String message) {
            return !message.matches("\\d+");
        }
    }
}
