package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterUtil {
    public static List<Integer> covertStringToList(String str) {
        return Arrays.stream(str.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

    }
}
