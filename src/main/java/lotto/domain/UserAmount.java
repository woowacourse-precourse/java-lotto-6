package lotto.domain;

public class UserAmount {

    private int userAmount;

    private UserAmount(String userAmount) {

        this.userAmount = Integer.parseInt(userAmount);
    }

    public static UserAmount from(String userAmount) {
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


}
