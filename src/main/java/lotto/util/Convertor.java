package lotto.util;

public class Convertor {
    private static final String COMMA = ",";

    private Convertor() {
    }

    public static int convertStringToInt(String value) {
        return Integer.parseInt(value);
    }

    public static String[] splitByComma(String input) {
        return input.split(COMMA);
    }
}
