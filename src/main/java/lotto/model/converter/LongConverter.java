package lotto.model.converter;

import static lotto.util.ExceptionMessage.INVALID_TYPE;

public class LongConverter implements StringConverter<Long> {
    @Override
    public Long toType(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }
}
