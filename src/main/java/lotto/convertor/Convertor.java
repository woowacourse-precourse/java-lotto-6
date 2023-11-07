package lotto.convertor;

import static lotto.exception.ErrorMessage.NOT_INTEGER;

import java.util.Arrays;
import java.util.List;
import lotto.exception.InvalidTypeException;

public final class Convertor {

    private static final String SPLIT_SIGNAL = ",";

    private Convertor() {
    }

    public static int toInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw InvalidTypeException.from(NOT_INTEGER);
        }
    }

    public static List<Integer> toIntegerList(final String input) {
        return Arrays.stream(input.split(SPLIT_SIGNAL))
                .map(Convertor::toInt)
                .toList();
    }
}
