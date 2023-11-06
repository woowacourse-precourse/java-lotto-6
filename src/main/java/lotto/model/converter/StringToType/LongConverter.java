package lotto.model.converter.StringToType;

import static lotto.util.ExceptionMessage.INVALID_LONG_TYPE;

public class LongConverter implements StringConverter<Long> {
    @Override
    public Long toType(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LONG_TYPE.getMessage());
        }
    }
}
