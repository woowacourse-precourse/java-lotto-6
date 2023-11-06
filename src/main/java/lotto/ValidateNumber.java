package lotto;

public class ValidateNumber {
    public static void isNumber(String number) {
        if (number.matches("\\d+")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력 해주세요.");
    }
}
