package lotto;

public class Validation {

    public static void isNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]: 숫자를 입력해야 합니다.");
        }
    }
}