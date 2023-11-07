package lotto.util.parser;

import lotto.constant.ErrorMessage;

public abstract class AbstractParser<T> implements InputParser<T> {

    protected void validateIsNotBlank(String input) {
        // 입력값이 비어있는지 검증
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK);
        }
    }

    protected abstract T convert(String input);
}
