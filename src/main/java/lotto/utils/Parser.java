package lotto.utils;

public class Parser {

    public static int parseToInt(String userInput) {
        try {
            return Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
        }
    }
}
