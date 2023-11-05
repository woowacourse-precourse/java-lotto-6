package lotto;

import java.util.regex.Pattern;

public class NumberValidator implements Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    @Override
    public void validate(Object value) {
        validateNull((String) value);
        validateNumber((String) value);
    }

    private void validateNull(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private void validateNumber(String value) {
        if (!NUMBER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("숫자로 입력해야합니다.");
        }
    }

    @Override
    public boolean support(Class<?> clazz) {
        return InputView.class.isAssignableFrom(clazz);
    }
}
