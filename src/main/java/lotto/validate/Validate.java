package lotto.validate;

public class Validate {
    public static void validateInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }

    // 입력 값이 나누어 떨어지는지 검증
    public static void validateDivideNumber(int number, int divide) {
        if (number % divide != 0) {
            throw new IllegalArgumentException(divide + " 값으로 나누어 떨어지지 않습니다.");
        }
    }
}
