package util;

import view.InputView;

public class UserInput {
    public static final int UNIT = 1000;
    public static final int MIN_PAYMENT = 1000;
    private static final String START_MESSAGE = "[ERROR]";
    private static final String WRONG_PAYMENT_MESSAGE = "%s %d 이상의 수를 %d 단위로 입력해주세요.";
    private static final String BLANK_ERROR_MESSAGE = "%s 아무 것도 입력되지 않았습니다.";
    private static final String WRONG_VALUE_MESSAGE = "%s 숫자가 아닌 값이 입력되었습니다.";

    public static long getUserPayment() {
        String userInput = InputView.setUserPayment();
        checkEmpty(userInput);
        long userPayment = checkLong(userInput);
        checkExceedsMinValue(userPayment);
        checkValidUnit(userPayment);
        return userPayment;
    }

    private static void checkEmpty(String userInput) {
        if (userInput.length() == 0) {
            throw new IllegalArgumentException(
                    String.format(BLANK_ERROR_MESSAGE, START_MESSAGE));
        }
    }

    private static long checkLong(String userInput) {
        try {
            return Long.parseLong(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(WRONG_VALUE_MESSAGE, START_MESSAGE));
        }
    }

    private static void checkExceedsMinValue(long userInput) {
        if (userInput < MIN_PAYMENT) {
            throw new IllegalArgumentException(
                    String.format(WRONG_PAYMENT_MESSAGE, START_MESSAGE, MIN_PAYMENT, UNIT));
        }
    }

    private static void checkValidUnit(long userInput) {
        if (userInput % UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format(WRONG_PAYMENT_MESSAGE, START_MESSAGE, MIN_PAYMENT, UNIT));
        }
    }
}
