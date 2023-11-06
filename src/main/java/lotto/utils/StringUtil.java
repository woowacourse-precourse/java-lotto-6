package lotto.utils;

public class StringUtil {

    public static int stringToInt(String inputValue) {
        InputValidator.validateAmountNotNumber(inputValue);
        return Integer.parseInt(inputValue);
    }
}
