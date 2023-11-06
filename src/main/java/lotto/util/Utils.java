package lotto.util;

public class Utils {
    public static int parseInt(String input) {
        Validator.validateInputString(input);
        return Integer.parseInt(input);
    }
}
