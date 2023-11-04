package lotto.view.validator;

public class InputValidator {
    public static void validMoneyType(String money) throws IllegalArgumentException {
        if (digitCheck(money)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public static void validBonusType(String number) {
        if (digitCheck(number)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static boolean digitCheck(String number) {
        String regex = "^[0-9]+$";
        return !number.matches(regex);
    }
}
