package lotto.converter;

import lotto.constant.ErrorMessage;

import java.util.regex.Pattern;

public class StringToInteger implements Converter<String, Integer> {

    public static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+$");

    @Override
    public Integer convert(String source) {
        validate(source);
        return Integer.valueOf(source);
    }

    private void validate(String source) {
        validateType(source);
        validateRange(source);
    }

    private void validateType(String source) {
        if (source == null || !NUMERIC_PATTERN.matcher(source).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE.getMessage());
        }
    }

    private void validateRange(String source) {
        try {
            Integer.parseInt(source);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE.getMessage(), e);
        }
    }
}
