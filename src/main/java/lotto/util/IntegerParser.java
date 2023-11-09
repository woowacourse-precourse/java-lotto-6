package lotto.util;

import java.util.List;

public class IntegerParser {

    public static int parse(String number) {
        return Integer.parseInt(number);
    }

    public static List<Integer> parse(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt).toList();
    }
}
