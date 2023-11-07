package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Parsor {
    private Parsor() {
    }

    public static String intListToString(List<Integer> numbers) {
        List<String> collect = numbers.stream()
                .map(Object::toString)
                .toList();

        return stringListToString(collect);
    }

    public static String stringListToString(List<String> strings) {
        return String.join(", ", strings);
    }
}
