package lotto.utils;

public class Util {
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";

    public static String[] splitByComma(String value) {
        return value.split(COMMA);
    }

    public static String removeSpace(String value) {
        return value.replaceAll(SPACE, NO_SPACE);
    }
}
