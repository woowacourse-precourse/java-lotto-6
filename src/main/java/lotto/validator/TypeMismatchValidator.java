package lotto.validator;

public class TypeMismatchValidator {

    public static void validateInputInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("가격정보는 숫자만 입력할 수 있습니다.");
        }
    }
}
