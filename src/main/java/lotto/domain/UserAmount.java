package lotto.domain;

public class UserAmount {

    private static final String EMPTY_VALUE = " ";
    private static final String LOTTO_USER_AMOUNT_CANT_CONTAIN_EMPTY_MESSAGE = "[ERROR] 로또 구입 금액은 공백이 포함될 수 없습니다.";
    private static final int USER_AMOUNT_DIVIDE_STANDARD = 1000;
    private static final String LOTTO_USER_AMOUNT_IS_DIVIDE_BY_STANDARD_MESSAGE = "[ERROR] 로또 구입 금액은 1000으로 나누어떨어져야 합니다.";
    private static final int ALL_DIVIDE_SIGNAL_VALUE = 0;
    private int userAmount;

    private UserAmount(int userAmount) {
        this.userAmount = userAmount;
    }

    public static UserAmount from(String userAmount) {
        validateContainsEmpty(userAmount);
        validateNumeric(userAmount);
        int amount = Integer.parseInt(userAmount);
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
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validateContainsEmpty(String userAmount) {
        if (userAmount.contains(EMPTY_VALUE)) {
            throw new IllegalArgumentException(LOTTO_USER_AMOUNT_CANT_CONTAIN_EMPTY_MESSAGE);
        }
    }

    private static void validateDivideByStandard(int userAmount) {
        if (!isDivideByStandard(userAmount)) {
            throw new IllegalArgumentException(LOTTO_USER_AMOUNT_IS_DIVIDE_BY_STANDARD_MESSAGE);
        }
    }

    private static boolean isDivideByStandard(int userAmount) {
        return userAmount % USER_AMOUNT_DIVIDE_STANDARD == ALL_DIVIDE_SIGNAL_VALUE;
    }


}
