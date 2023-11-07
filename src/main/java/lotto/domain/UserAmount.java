package lotto.domain;

import lotto.constants.UserAmountErrorMessage;

public class UserAmount {

    private static final String EMPTY_VALUE = " ";
    private static final int USER_AMOUNT_DIVIDE_STANDARD = 1000;
    private static final int ALL_DIVIDE_SIGNAL_VALUE = 0;
    private static final int ZERO_EQUALS_VALUE = 0;

    private int userAmount;

    private UserAmount(int userAmount) {
        this.userAmount = userAmount;
    }

    public static UserAmount from(String userAmount) {
        validateContainsEmpty(userAmount);
        validateNumeric(userAmount);
        int amount = Integer.parseInt(userAmount);
        validateZero(amount);
        validateNatureNumber(amount);
        validateDivideByStandard(amount);
        return new UserAmount(amount);
    }

    public int calculateIssueAbleCount() {
        return this.userAmount / Lotto.PRICE_PER_LOTTO;
    }

    private static void validateNumeric(String userAmount) {
        try {
            Integer.parseInt(userAmount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(UserAmountErrorMessage.NUMERIC_INVALID.entireMessage());
        }
    }

    private static void validateContainsEmpty(String userAmount) {
        if (userAmount.contains(EMPTY_VALUE)) {
            throw new IllegalArgumentException(UserAmountErrorMessage.EMPTY_INVALID.entireMessage());
        }
    }

    private static void validateDivideByStandard(int userAmount) {
        if (!isDivideByStandard(userAmount)) {
            throw new IllegalArgumentException(UserAmountErrorMessage.NOT_DIVIDE_STANDARD_INVALID.entireMessage());
        }
    }

    private static boolean isDivideByStandard(int userAmount) {
        return userAmount % USER_AMOUNT_DIVIDE_STANDARD == ALL_DIVIDE_SIGNAL_VALUE;
    }

    private static void validateZero(int userAmount) {
        if (isEqualsZero(userAmount)) {
            throw new IllegalArgumentException(UserAmountErrorMessage.NOT_ZERO_INVALID.entireMessage());
        }
    }

    private static boolean isEqualsZero(int userAmount) {
        return userAmount == ZERO_EQUALS_VALUE;
    }

    private static void validateNatureNumber(int userAmount) {
        if(isNotNatureNumber(userAmount)) {
            throw new IllegalArgumentException(UserAmountErrorMessage.NATURE_NUMBER_INVALID.entireMessage());
        }
    }

    private static boolean isNotNatureNumber(int userAmount) {
        return userAmount < 0;
    }

    public int getUserAmount() {
        return userAmount;
    }
}
