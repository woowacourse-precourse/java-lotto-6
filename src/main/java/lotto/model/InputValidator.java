package lotto.model;

public class InputValidator {
    public void checkCanParseInt(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력되었습니다.");
        }
    }

    public void checkIsNotBlank(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }
}
