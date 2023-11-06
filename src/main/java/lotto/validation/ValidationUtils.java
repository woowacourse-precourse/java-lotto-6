package lotto.validation;

public class ValidationUtils {
    private static final String INCORRECT_THOUSANDS_FORMAT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 됩니다.";

    public ValidationUtils() {}

    public boolean validateUserAmount(int money) {
        if (money / 1000 != 0 && money % 1000 == 0) {
            return true;
        }

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(INCORRECT_THOUSANDS_FORMAT_ERROR_MESSAGE);
        }

        return false;
    }

}
