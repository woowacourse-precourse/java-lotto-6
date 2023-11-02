package lotto.Util;

public class Validator {

    public static final String NULL_OR_EMPTY_MESSAGE = "값을 입력해주세요";
    public static final String EMPTY = "";

    public static void validateNullOrEmpty(String input) throws IllegalArgumentException {
        if (input == null || input.equals(EMPTY)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_MESSAGE);
        }
    }

}
