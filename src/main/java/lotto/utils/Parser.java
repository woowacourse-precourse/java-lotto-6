package lotto.utils;

public class Parser {

    public static int parseBudget(String budget) {
        try {
            return Integer.parseInt(budget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                ExceptionMessage.INVALID_BUDGET_NON_NUMERIC.getMessage());
        }
    }


}
