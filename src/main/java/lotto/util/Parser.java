package lotto.util;

import static lotto.util.Constants.ERROR;

import java.util.Arrays;
import java.util.List;
import lotto.util.exception.input.ConstructionErrorException;

public class Parser {
    private static final String SPLIT_REGEX = ",";

    private Parser() {
        throw new ConstructionErrorException();
    }

    public static List<String> parseString(String numbers) {
        return Arrays.stream(numbers.split(SPLIT_REGEX))
                .map(String::trim)
                .toList();
    }
}
