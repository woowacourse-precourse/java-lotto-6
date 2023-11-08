package lotto.utils;

import java.util.NoSuchElementException;
import lotto.constants.Message;

public final class Converter {
    public static Long convertToLong(String value) {
        Long convertedValue;
        try {
            convertedValue = Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INPUT_NOT_NUMBER_EXCEPTION);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Message.INPUT_NULL_EXCEPTION);
        }
        return convertedValue;
    }

    public static Integer convertToInteger(String value) {
        Integer convertedValue;
        try {
            convertedValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INPUT_NOT_NUMBER_EXCEPTION);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Message.INPUT_NULL_EXCEPTION);
        }
        return convertedValue;
    }
}
