package lotto.service;

public class BonusValidator {
    private static final String ONLY_NUMBER = "^[0-9 ]*$";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static int validate(String userInput) {
        // Only number
        if (!userInput.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException(UserNumbersValidateStatus.PRE_NUMBERS_ERROR.get());
        }

        int bonus = Integer.parseInt(userInput);
        // Lotto number range
        rangeValidate(bonus);

        return bonus;
    }

    private static void rangeValidate(int bonus) {
        maxValidate(bonus);
        minValidate(bonus);
    }

    private static void maxValidate(int bonus) {
        if (bonus > MAX_NUMBER) {
            throw new NumberFormatException(UserNumbersValidateStatus.LOTTO_NUMBERS_ERROR.get());
        }
    }

    private static void minValidate(int bonus) {
        if (bonus < MIN_NUMBER) {
            throw new NumberFormatException(UserNumbersValidateStatus.LOTTO_NUMBERS_ERROR.get());
        }
    }
}
