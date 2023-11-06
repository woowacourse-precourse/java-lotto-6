package lotto.domain;

public class UserAmount {

    private static final String EMPTY_VALUE = " ";
    private static final String LOTTO_USER_AMOUNT_CANT_CONTAIN_EMPTY_MESSAGE = "[ERROR] 로또 구입 금액은 공백이 포함될 수 없습니다.";
    private int userAmount;

    private UserAmount(String userAmount) {

        this.userAmount = Integer.parseInt(userAmount);
    }

    public static UserAmount from(String userAmount) {
        validateContainsEmpty(userAmount);
        validateNumeric(userAmount);
        return new UserAmount(userAmount);
    }

    private static void validateNumeric(String userAmount) {
        try {
            Integer.parseInt(userAmount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validateContainsEmpty(String userAmount) {
        if(userAmount.contains(EMPTY_VALUE)) {
            throw new IllegalArgumentException(LOTTO_USER_AMOUNT_CANT_CONTAIN_EMPTY_MESSAGE);
        }
    }


}
