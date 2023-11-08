package lotto.util;

public class StringToNumberConvertor {


    public static int convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    UtilErrorMessages.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
