package lotto.util;

import java.util.List;
import java.util.Objects;

public class StringUtil {

    public static List<String> toStringList(List<Integer> numbers) {
        return numbers.stream()
                .map(Objects::toString)
                .toList();
    }
}
