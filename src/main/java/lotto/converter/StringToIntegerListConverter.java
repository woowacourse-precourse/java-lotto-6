package lotto.converter;

import java.util.Arrays;
import java.util.List;

public class StringToIntegerListConverter implements Converter<String, List<Integer>> {
    private static final String DELIMITER = ",";

    @Override
    public List<Integer> convert(String source) {
        return Arrays.stream(source.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
