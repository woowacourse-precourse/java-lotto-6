package lotto.util;

public class Util {
    public static int convertStringToInt(String input) {
        try
        {
            int convert = Integer.parseInt(input);
            return convert;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_FORMAT.getMessage());
        }
    }
}
