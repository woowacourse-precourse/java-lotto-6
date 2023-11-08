package lotto.util.converter;

import java.util.List;
import java.util.stream.Stream;

public class MultipleNumericConverter {
    private static final String DELIMITER = ",";

    private MultipleNumericConverter() {
    }

    public static List<Integer> convert(String value) {
        return Stream.of(value.split(DELIMITER))
                .map(NumericConverter::convert)
                .toList();
    }
}
