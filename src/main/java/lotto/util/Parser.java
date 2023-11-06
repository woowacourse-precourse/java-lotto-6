package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static int stringToInt(String str) throws NumberFormatException {
            return Integer.parseInt(str);
    }

    public static List<Integer> stringToList(String str) {
        return Stream.of(str.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
