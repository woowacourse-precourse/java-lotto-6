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

        private static String validateCost(String cost) {
            validateNumber(cost);
            validateUnit(cost);
            return cost;
        }

        private static void validateNumber(String cost) {
            if (isNotNumber(cost)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }

        private static boolean isNotNumber(String message) {
            return !message.matches("\\d+");
        }

        private static void validateUnit(String cost) {
            if (isNotDivisible(cost)) {
                throw new IllegalArgumentException(String.format("%s원 단위의 구입 금액을 입력해주세요."));
            }
        }

        private static boolean isNotDivisible(String cost) {
            return Integer.parseInt(cost) % 1000 != 0;
        }
    }
}
