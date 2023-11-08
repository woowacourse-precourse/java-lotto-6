package utils;

public class Validator {

    public static void checkMoneyInput(String moneyInput) {
        checkPositiveInteger(moneyInput);
        checkNullOrBlank(moneyInput);
    }

    private static void checkPositiveInteger(String moneyInput) {
        if (!moneyInput.matches(Constant.POSITIVE_NUMBER_FORMAT.getValue())) {
            throw new IllegalArgumentException(Message.NON_POSITIVE_INTEGER.getMessage());
        }
    }

    private static void checkNullOrBlank(String moneyInput) {
        if (moneyInput == null || moneyInput.strip().isEmpty()) {
            throw new IllegalArgumentException(Message.NULL_OR_BLANK.getMessage());
        }
    }
}
