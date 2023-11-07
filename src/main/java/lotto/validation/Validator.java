package lotto.validation;

public class Validator {
    public static boolean checkIsNotNumber(String pay) {
        try {
            Integer.parseInt(pay);
            return false;
        } catch (NumberFormatException error) {
            return true;
        }
    }
    public static boolean checkIsZero(int pay) {
        if (pay == 0) {
            return true;
        }
        return false;
    }
    public static boolean checkMultipleOf1000(int pay) {
        if (pay % 1000 != 0) {
            return true;
        }
        return false;
    }
}
