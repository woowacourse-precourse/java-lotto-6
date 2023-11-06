package lotto.util.converter;

import java.util.List;
import java.util.stream.Stream;

public class IntegerListConverter {
    private static final String DELIMITER = ",";

    private IntegerListConverter() {
    }

    public static List<Integer> convert(String value) {
        return Stream.of(value.split(DELIMITER))
                .map(IntegerConverter::convert)
                .toList();
    }
}
