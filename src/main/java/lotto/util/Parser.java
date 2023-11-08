package lotto.util;

import static lotto.util.Constants.ERROR;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String SPLIT_REGEX = ",";

    private Parser() {
        throw new AssertionError(ERROR+"생성할 수 없는 클래스입니다.");
    }

    public static List<String> parseString(String numbers) {
        return Arrays.stream(numbers.split(SPLIT_REGEX))
                .map(String::trim)
                .toList();
    }
}
