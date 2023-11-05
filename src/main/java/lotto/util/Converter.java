package lotto.util;

public class Converter {
    private static final String NON_NUMERIC_INPUT_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    public static int stringToInt(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_MESSAGE);
        }
    }
    
}
