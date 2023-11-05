package lotto.util;

import java.util.Arrays;
import java.util.List;

// 리팩터링 진행할 것
public class Converter {
    public static List<Integer> toIntegerList(String input) {
        return Arrays.stream(input.trim().split(","))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }
}

