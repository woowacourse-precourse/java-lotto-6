package lotto.validator;

public class Validator {

    private static final String NO_EMPTY_ERROR_MESSAGE = "공백 혹은 빈문자는 입력할 수 없습니다.";

    private Validator() {
    }

    public static void validateEmpty(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException(NO_EMPTY_ERROR_MESSAGE);
        }
    }
}
