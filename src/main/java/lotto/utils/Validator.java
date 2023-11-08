package lotto.utils;

public class Validator {

    public static void checkMoneyInput(String moneyInput) {
        checkPositiveInteger(moneyInput);
        checkNullOrBlank(moneyInput);
        checkGreaterThanThousand(moneyInput);
        checkDivisibleByThousand(moneyInput);
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

    private static void checkGreaterThanThousand(String moneyInput) {
        if (Integer.parseInt(moneyInput) < 1000) {
            throw new IllegalArgumentException(Message.LOWER_THAN_1000.getMessage());
        }
    }

    private static void checkDivisibleByThousand(String moneyInput) {
        if (Integer.parseInt(moneyInput) % 1000 != 0) {
            throw new IllegalArgumentException(Message.NOT_DIVISIBLE_BY_1000.getMessage());
        }
    }
}
