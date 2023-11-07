package lotto.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parser {
    private Parser() {
    }

    public static String intListToString(List<Integer> numbers) {
        List<String> collect = numbers.stream()
                .map(Object::toString)
                .toList();

        return stringListToString(collect);
    }

    public static List<String> stringToStringList(String numbers) {
        return Arrays.asList(numbers.split(",", -1));
    }

    public static List<Integer> stringListToIntList(List<String> strings) {
        return strings.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static String stringListToString(List<String> strings) {
        return String.join(", ", strings);
    }
}
