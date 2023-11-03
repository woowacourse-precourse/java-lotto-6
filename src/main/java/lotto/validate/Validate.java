package lotto.validate;

public class Validate {
    public static void validateInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }
}
